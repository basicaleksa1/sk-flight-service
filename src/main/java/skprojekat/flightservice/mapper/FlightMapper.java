package skprojekat.flightservice.mapper;

import org.springframework.stereotype.Component;

import skprojekat.flightservice.dto.FlightCreateDto;
import skprojekat.flightservice.dto.FlightDto;
import skprojekat.flightservice.model.Flight;
import skprojekat.flightservice.model.Plane;

@Component
public class FlightMapper {

	public FlightDto flightToFlightDto(Flight flight) {
		FlightDto flightDto = new FlightDto();
		flightDto.setId(flight.getId());
		flightDto.setDeparture(flight.getDeparture());
		flightDto.setDestination(flight.getDestination());
		flightDto.setPrice(flight.getPrice());
		flightDto.setFlightDurHrs(flight.getFlightDurHrs());
		flightDto.setPlaneName(flight.getPlane().getName());
		return flightDto;
	}
	
	public Flight filghtCreateDtoToFlight(FlightCreateDto flightCD, Plane plane) {
		Flight flight = new Flight();
		flight.setDeparture(flightCD.getDeparture());
		flight.setDestination(flightCD.getDestination());
		flight.setPlane(plane);
		flight.setPrice(flightCD.getPrice());
		flight.setFlightDurHrs(flightCD.getFlightDurHrs());
		flight.setCapacity(flightCD.getCapacity());
		return flight;
	}
}
