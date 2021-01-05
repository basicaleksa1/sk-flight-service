package skprojekat.flightservice.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import skprojekat.flightservice.dto.FlightDto;
import skprojekat.flightservice.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{

	void deleteById(Integer id);

	Page<FlightDto> findAllByDepartureAndDestinationAndPrice(Pageable pageable,
															 String departure,
															 String destination,
															 Double price);

	Page<FlightDto> findAllByDeparture(Pageable pageable, String departure);

	Page<FlightDto> findAllByDepartureAndDestination(Pageable pageable, String departure, String destination);

	Optional<Flight> findByPlane_Id(Integer id);

}
