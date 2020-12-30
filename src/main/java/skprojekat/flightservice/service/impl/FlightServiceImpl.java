package skprojekat.flightservice.service.impl;

import org.springframework.stereotype.Service;

import skprojekat.flightservice.model.Flight;
import skprojekat.flightservice.repository.FlightRepository;
import skprojekat.flightservice.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService{

	private FlightRepository flightRepo;
	
	public FlightServiceImpl(FlightRepository flightRepo) {
		this.flightRepo = flightRepo;
	}
	
	@Override
	public void add() {
		flightRepo.save(new Flight());
		
	}

}
