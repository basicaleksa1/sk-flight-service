package skprojekat.flightservice.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import skprojekat.flightservice.dto.FlightCreateDto;
import skprojekat.flightservice.dto.FlightDto;
import skprojekat.flightservice.mapper.FlightMapper;
import skprojekat.flightservice.model.Plane;
import skprojekat.flightservice.repository.FlightRepository;
import skprojekat.flightservice.repository.PlaneRepository;
import skprojekat.flightservice.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService{

	private FlightRepository flightRepo;
	private FlightMapper flightMapper;
	private PlaneRepository planeRepo;
	
	public FlightServiceImpl(FlightRepository flightRepo, FlightMapper flightMapper, PlaneRepository planeRepo) {
		this.flightRepo = flightRepo;
		this.flightMapper = flightMapper;
		this.planeRepo = planeRepo;
	}

	@Override
	public Page<FlightDto> findAll(Pageable pageable) {
		return flightRepo.findAll(pageable)
				.map(flightMapper::flightToFlightDto);
	}

	@Override
	public FlightDto findById(Integer id) {
//		return flightRepo.findById(id)
//				.map(flightMapper::flightToFlightDto)
//				.orElseThrow(() -> new NotFoundException(String.format("Flight with id: %d not found", id)));
		return null;
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
		flightRepo.deleteById(id);
		
	}
	
	
}
