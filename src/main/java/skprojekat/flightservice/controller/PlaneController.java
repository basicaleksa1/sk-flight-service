package skprojekat.flightservice.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import skprojekat.flightservice.dto.PlaneCreateDto;
import skprojekat.flightservice.dto.PlaneDto;
import skprojekat.flightservice.service.PlaneService;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/plane")
public class PlaneController {
	
	private PlaneService planeService;
	
	public PlaneController(PlaneService planeService) {
		this.planeService = planeService;
	}

	@GetMapping
	public ResponseEntity<Page<PlaneDto>> findAll(@ApiIgnore Pageable pageable){
		return new ResponseEntity<>(planeService.findAll(pageable), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<PlaneDto> add(PlaneCreateDto planeCreateDto){
		return new ResponseEntity<>(planeService.add(planeCreateDto), HttpStatus.CREATED);
	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("/id")
	public ResponseEntity<PlaneDto> delete(Integer id) {
		planeService.deleteById(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
