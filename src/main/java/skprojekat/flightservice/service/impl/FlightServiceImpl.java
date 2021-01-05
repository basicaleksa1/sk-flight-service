package skprojekat.flightservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import skprojekat.flightservice.dto.FlightCreateDto;
import skprojekat.flightservice.dto.FlightDto;
import skprojekat.flightservice.mapper.FlightMapper;
import skprojekat.flightservice.model.Flight;
import skprojekat.flightservice.model.Plane;
import skprojekat.flightservice.repository.FlightRepository;
import skprojekat.flightservice.repository.PlaneRepository;
import skprojekat.flightservice.service.FlightService;

import java.util.*;

@Service
public class FlightServiceImpl implements FlightService{

	private FlightRepository flightRepo;
	private FlightMapper flightMapper;
	private PlaneRepository planeRepo;
	private JmsTemplate jmsTemplate;
	private String destinationDelete;
	private ObjectMapper objectMapper;
	
	public FlightServiceImpl(FlightRepository flightRepo,
							 FlightMapper flightMapper,
							 PlaneRepository planeRepo,
							 JmsTemplate jmsTemplate,
							 @Value("${destination.delete_flight}") String destinationDelete,
							 ObjectMapper objectMapper) {
		this.flightRepo = flightRepo;
		this.flightMapper = flightMapper;
		this.planeRepo = planeRepo;
		this.jmsTemplate = jmsTemplate;
		this.destinationDelete = destinationDelete;
		this.objectMapper = objectMapper;
	}

	@Override
	public Page<FlightDto> findAll(Pageable pageable) {
		Page<Flight> flights = flightRepo.findAll(pageable);
		Iterator<Flight> iterator = flights.iterator();
		while(iterator.hasNext()){
			Flight flight = iterator.next();
//			System.out.println(flight.getPlane().getName() + Integer.toString(flight.getPlane().getCapacity()));
			if(!(flight.getPlane().getCapacity() >= flight.getCapacity())){

				iterator.remove();
			}
		}
		return flights.map(flightMapper::flightToFlightDto);
	}

	@Override
	public Page<FlightDto> findAllByDepartureAndDestinationAndPrice(Pageable pageable, String departure, String destination, Double price) {
		return flightRepo.findAllByDepartureAndDestinationAndPrice(pageable, departure, destination, price);
	}

	@Override
	public Page<FlightDto> findAllByDeparture(Pageable pageable, String departure) {
		return flightRepo.findAllByDeparture(pageable, departure);
	}

	@Override
	public Page<FlightDto> findAllByDepartureAndDestination(Pageable pageable, String departure, String destination) {
		return flightRepo.findAllByDepartureAndDestination(pageable, departure, destination);
	}


	@Override
	public Optional<Flight> findByPlane_Id(Integer id) {
		return flightRepo.findByPlane_Id(id);
	}

	@Override
	public FlightDto findById(Integer id) {
		return flightRepo.findById(id)
				.map(flightMapper::flightToFlightDto)
				.orElseThrow();
	}

	@Override
	public FlightDto add(FlightCreateDto flightCreateDto, Integer planeId) {
		Plane plane = this.planeRepo.findById(planeId).orElseThrow();
		System.out.println(plane);
		System.out.println("paradajz");
		return flightMapper.flightToFlightDto(flightRepo
				.save(flightMapper.filghtCreateDtoToFlight(flightCreateDto, plane)));
	}

	@Override
	public void deleteById(Integer id) {
		Flight flight = flightRepo.findById(id).orElseThrow();
		try {
			jmsTemplate.convertAndSend(new ActiveMQTopic(destinationDelete), objectMapper.writeValueAsString(flight.getId()));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		flight.setStatus("CANCELED");
		flightRepo.save(flight);
	}

	@Override
	public void updateCapacity(Integer id) {
		Flight flight = flightRepo.findById(id).orElseThrow();
		flight.setCapacity(flight.getCapacity() + 1);
		flightRepo.save(flight);

	}
}
