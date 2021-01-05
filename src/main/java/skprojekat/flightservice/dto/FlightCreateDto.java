package skprojekat.flightservice.dto;


public class FlightCreateDto {

	private String departure;
	private String destination;
	private Double price;
	private Double distance;
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
	public Double getDistance() {
		return distance;
	}
	/**
	 * @param distance the flightDurHrs to set
	 */
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	
}
