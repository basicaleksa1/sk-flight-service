package skprojekat.flightservice.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import skprojekat.flightservice.dto.FlightCreateDto;
import skprojekat.flightservice.dto.FlightDto;
import skprojekat.flightservice.mapper.FlightMapper;
import skprojekat.flightservice.repository.FlightRepository;
import skprojekat.flightservice.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService{

	private FlightRepository flightRepo;
	private FlightMapper flightMapper;
	
	public FlightServiceImpl(FlightRepository flightRepo, FlightMapper flightMapper) {
		this.flightRepo = flightRepo;
		this.flightMapper = flightMapper;
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
	public FlightDto add(FlightCreateDto flightCreateDto) {
		return flightMapper.flightToFlightDto(flightRepo
				.save(flightMapper.filghtCreateDtoToFlight(flightCreateDto)));
	}

	@Override
	public void deleteById(Integer id) {
		flightRepo.deleteById(id);
		
	}
	
	
}
