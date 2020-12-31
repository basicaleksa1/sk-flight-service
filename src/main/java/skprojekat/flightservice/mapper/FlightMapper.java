package skprojekat.flightservice.mapper;

import skprojekat.flightservice.dto.FlightCreateDto;
import skprojekat.flightservice.dto.FlightDto;
import skprojekat.flightservice.model.Flight;

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
	
	public Flight filghtCreateDtoToFlight(FlightCreateDto flightCD) {
		Flight flight = new Flight();
		flight.setDeparture(flightCD.getDeparture());
		flight.setDestination(flightCD.getDestination());
		flight.setPlane(flightCD.getPlane());
		flight.setPrice(flightCD.getPrice());
		flight.setFlightDurHrs(flightCD.getFlightDurHrs());
		return flight;
	}
}
