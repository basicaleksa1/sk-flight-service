package skprojekat.flightservice.model;

import javax.persistence.*;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Plane plane;
	@Column(columnDefinition="TEXT", length=30, nullable=false)
	private String departure;
	@Column(columnDefinition="TEXT", length=30, nullable=false)
	private String destination;
	@Column(columnDefinition="Decimal(10,2) default '100.00'", nullable=false)
	private Double price;
	@Column(columnDefinition="Decimal(10,2) default '100.00'", nullable=false)
	private Double flightDurHrs;
	@Column(nullable=false, columnDefinition="int default 0")
	private Integer capacity;
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
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @return the flightDurHrs
	 */
	public Double getFlightDurHrs() {
		return flightDurHrs;
	}
	/**
	 * @param flightDurHrs the flightDurHrs to set
	 */
	public void setFlightDurHrs(Double flightDurHrs) {
		this.flightDurHrs = flightDurHrs;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the plane
	 */
	public Plane getPlane() {
		return plane;
	}
	/**
	 * @param plane the plane to set
	 */
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	/**
	 * @return the departure
	 */
	public String getDeparture() {
		return departure;
	}
	/**
	 * @param departure the departure to set
	 */
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
