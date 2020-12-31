package skprojekat.flightservice.dto;

import skprojekat.flightservice.model.Plane;

public class FlightCreateDto {

	private Plane plane;
	private String departure;
	private String destination;
	private Double price;
	private Double flightDurHrs;
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
	
	
}
