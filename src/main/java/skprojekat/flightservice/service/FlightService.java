package skprojekat.flightservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import skprojekat.flightservice.dto.FlightCreateDto;
import skprojekat.flightservice.dto.FlightDto;

@Service
public interface FlightService {

	Page<FlightDto> findAll(Pageable pageable);
	
	FlightDto findById(Integer id);	
	
	void deleteById(Integer id); // mozda bi trebalo da vraca objekat koji je obrisao zbog toga sto posle moramo preko message broker da vidimo 

	FlightDto add(FlightCreateDto flightCreateDto, Integer planeId);
}								 // koje karte treba da obrisemo i da vratimo navac to se vrv radi preko kljuca pa cemo imati i tamo u bazama kljuceve
								 // ja se barem nadam
