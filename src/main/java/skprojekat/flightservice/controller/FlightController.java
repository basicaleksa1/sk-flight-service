package skprojekat.flightservice.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.models.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import skprojekat.flightservice.dto.FlightCreateDto;
import skprojekat.flightservice.dto.FlightDto;
import skprojekat.flightservice.security.CheckSecurity;
import skprojekat.flightservice.service.FlightService;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/flight")
public class FlightController {

	private FlightService flightService;
	
	public FlightController(FlightService flightService) {
		this.flightService = flightService;
	}
	
	@ApiOperation(value = "Get all flights")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "What page number you want", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "size", value = "Number of items to return", dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
					value = "Sorting criteria in the format: property(,asc|desc). " +
							"Default sort order is ascending. " +
							"Multiple sort criteria are supported.")})
	@GetMapping
	public ResponseEntity<Page<FlightDto>> findAll(@ApiIgnore Pageable pageable) {
		return new ResponseEntity<>(flightService.findAll(pageable), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@CheckSecurity(roles = {"ROLE_ADMIN", "ROLE_USER"})
	public ResponseEntity<FlightDto> findById(@RequestHeader("Authorization") String authorization, @PathVariable("id") Integer id){
		return new ResponseEntity<>(flightService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	@CheckSecurity(roles = {"ROLE_ADMIN"})
	public ResponseEntity<FlightDto> add(@RequestHeader("Authorization") String authorization, @RequestBody FlightCreateDto flightCreateDto, Integer id){
		return new ResponseEntity<>(flightService.add(flightCreateDto, id), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	@CheckSecurity(roles = {"ROLE_ADMIN"})
	public ResponseEntity<?> delete(@RequestHeader("Authorization") String authorization, @PathVariable("id") Integer id){
		flightService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@CheckSecurity(roles = {"ROLE_ADMIN"})
	public ResponseEntity<?> updateCapacity(@PathVariable Integer id) {
		flightService.updateCapacity(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
