package skprojekat.flightservice.runner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import skprojekat.flightservice.model.Plane;
import skprojekat.flightservice.repository.FlightRepository;
import skprojekat.flightservice.repository.PlaneRepository;

@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner {

    private PlaneRepository planeRepository;
    private FlightRepository flightRepository;

    public TestDataRunner(PlaneRepository planeRepository, FlightRepository flightRepository){
        this.planeRepository = planeRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Plane plane = new Plane("Boing", 100);
        planeRepository.save(plane);
        Plane plane1 = new Plane("Pita sa sirom", 1312);
        planeRepository.save(plane1);

    }
}
