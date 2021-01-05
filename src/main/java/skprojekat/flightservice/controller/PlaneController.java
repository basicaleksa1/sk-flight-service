package skprojekat.flightservice.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import skprojekat.flightservice.dto.PlaneCreateDto;
import skprojekat.flightservice.dto.PlaneDto;
import skprojekat.flightservice.model.Flight;
import skprojekat.flightservice.security.CheckSecurity;
import skprojekat.flightservice.service.FlightService;
import skprojekat.flightservice.service.PlaneService;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Optional;

@RestController
@RequestMapping("/plane")
public class PlaneController {
	
	private PlaneService planeService;
	private FlightService flightService;
	
	public PlaneController(PlaneService planeService, FlightService flightService) {
		this.planeService = planeService;
		this.flightService = flightService;
	}

	@GetMapping
	@CheckSecurity(roles = {"ROLE_USER", "ROLE_ADMIN"})
	public ResponseEntity<Page<PlaneDto>> findAll(@RequestHeader("Authorization") String authorization, @ApiIgnore Pageable pageable){
		return new ResponseEntity<>(planeService.findAll(pageable), HttpStatus.OK);
	}

	@GetMapping("/id")
	@CheckSecurity(roles = {"ROLE_USER", "ROLE_ADMIN"})
	public ResponseEntity<PlaneDto> findById(@RequestHeader("Authorization") String authorization, Integer id){
		return new ResponseEntity<>(planeService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	@CheckSecurity(roles = {"ROLE_ADMIN"})
	public ResponseEntity<PlaneDto> add(@RequestHeader("Authorization") String authorization, PlaneCreateDto planeCreateDto){
		return new ResponseEntity<>(planeService.add(planeCreateDto), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/id")
	@CheckSecurity(roles = {"ROLE_ADMIN"})
	public ResponseEntity<PlaneDto> delete(@RequestHeader("Authorization") String authorization, Integer id) {
//		Optional<Flight> flights = flightService.findByPlane_Id(id);
//		if(flights.isPresent())
//			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		planeService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
