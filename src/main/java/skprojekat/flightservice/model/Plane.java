package skprojekat.flightservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Plane {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(optional=true) 
	private Flight flight;
	
	@Column(columnDefinition="TEXT", length=20)
	private String name;
	
	@Column(nullable=false, columnDefinition="int default 100")
	private Integer capacity;

	/**
	 * @return the planeId
	 */
	public Integer getPlaneId() {
		return id;
	}

	/**
	 * @param planeId the planeId to set
	 */
	public void setPlaneId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}

	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flight flight) {
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
