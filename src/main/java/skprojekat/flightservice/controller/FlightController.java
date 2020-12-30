package skprojekat.flightservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import skprojekat.flightservice.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {

	private FlightService service;
	
	public FlightController(FlightService service) {
		this.service = service;
	}
	
	@GetMapping("/all")
	public void getAll(){
		System.out.println("radi mi kurac jebem ti se sa kevom");
	}
}
