package skprojekat.flightservice.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import skprojekat.flightservice.dto.FlightCreateDto;
import skprojekat.flightservice.dto.FlightDto;
import skprojekat.flightservice.security.CheckSecurity;
import skprojekat.flightservice.service.FlightService;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/flight")
public class FlightController {

	private FlightService service;
	
	public FlightController(FlightService service) {
		this.service = service;
	}
	
	@ApiOperation(value = "Get all flights")
	@GetMapping
	public ResponseEntity<Page<FlightDto>> findAll(@ApiIgnore Pageable pageable){
		return new ResponseEntity<>(service.findAll(pageable), HttpStatus.OK);
	}
	
	@PostMapping
	@CheckSecurity(roles = {"ROLE_ADMIN"})
	public ResponseEntity<FlightDto> add(@RequestBody FlightCreateDto flightCreateDto, Integer id){
		return new ResponseEntity<>(service.add(flightCreateDto, id), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	@CheckSecurity(roles = {"ROLE_ADMIN"})
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
