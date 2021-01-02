package skprojekat.flightservice.mapper;

import org.springframework.stereotype.Component;

import skprojekat.flightservice.dto.PlaneCreateDto;
import skprojekat.flightservice.dto.PlaneDto;
import skprojekat.flightservice.model.Plane;

@Component
public class PlaneMapper {

	public PlaneDto PlaneToPlaneDto(Plane plane) {
		PlaneDto planeDto = new PlaneDto();
		planeDto.setId(plane.getId());
		planeDto.setCapacity(plane.getCapacity());
		planeDto.setFlight(plane.getFlight());
		planeDto.setName(plane.getName());
		return planeDto;
	}
	
	public Plane PlaneCreateDtoToPlane(PlaneCreateDto planeCD) {
		Plane plane = new Plane();
		plane.setCapacity(planeCD.getCapacity());
		plane.setName(planeCD.getName());
		return plane;
	}
}
