package skprojekat.flightservice.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Plane {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(mappedBy="plane")
	private List<Flight> flight;
	
	@Column(columnDefinition="TEXT", length=20, nullable=false)
	private String name;
	
	@Column(nullable=false, columnDefinition="int default 100")
	private Integer capacity;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the flight
	 */
	public List<Flight> getFlight() {
		return flight;
	}

	/**
	 * @param flight the flight to set
	 */
	public void setFlight(List<Flight> flight) {
		this.flight = flight;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the capacity
	 */
	public Integer getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	
}
