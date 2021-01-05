package skprojekat.flightservice.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import skprojekat.flightservice.dto.PlaneCreateDto;
import skprojekat.flightservice.dto.PlaneDto;
import skprojekat.flightservice.mapper.PlaneMapper;
import skprojekat.flightservice.model.Flight;
import skprojekat.flightservice.repository.FlightRepository;
import skprojekat.flightservice.repository.PlaneRepository;
import skprojekat.flightservice.service.PlaneService;

import java.util.Optional;

@Service
public class PlaneServiceImpl implements PlaneService{

	private PlaneRepository planeRepo;
	private PlaneMapper planeMapper;
	private FlightRepository flightRepo;
	
	public PlaneServiceImpl(PlaneRepository planeRepo, PlaneMapper planeMapper, FlightRepository flightRepo) {
		this.planeMapper = planeMapper;
		this.planeRepo = planeRepo;
		this.flightRepo = flightRepo;
	}
	
	@Override
	public Page<PlaneDto> findAll(Pageable pageable) {
		return planeRepo.findAll(pageable).
				map(planeMapper::PlaneToPlaneDto);
	}

	@Override
	public PlaneDto findById(Integer id) {
		return planeRepo.findById(id).
				map(planeMapper::PlaneToPlaneDto).
				orElseThrow();
	}

	@Override
	public PlaneDto add(PlaneCreateDto planeCreateDto) {
		return planeMapper.PlaneToPlaneDto(planeRepo
				.save(planeMapper.PlaneCreateDtoToPlane(planeCreateDto)));
	}

	@Override
	public void deleteById(Integer id) {
		Optional<Flight> flights = flightRepo.findByPlane_Id(id);
		if(flights.isPresent())
			return;
		planeRepo.deleteById(id);
	}

}
