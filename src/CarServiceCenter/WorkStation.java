package CarServiceCenter;

public abstract class WorkStation
{
	private String station_manager;
	private int price;
	private int duration;
	private volatile int counter;
	private String vehicle_id;
	
	// C'tor
	public WorkStation(String name, int price, int duration, int counter)
	{
		this.station_manager = name;
		this.price = price;
		this.duration = duration;
		this.counter = counter;

	}
	// Getters and Setters
	public String getStation_manager() {
		return station_manager;
	}
	public void setStation_manager(String station_manager) {
		this.station_manager = station_manager;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public String getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	// toString override
	@Override
	public String toString(){
		return "Station name: " + this.getClass().getName() + "\n" + "Station Manager name: " + station_manager + "\n" + "Price: " + price + "\n" + "Duration: " + duration + "\n" + "Counter: " + counter + "\n" +  "Vehicle id: " + vehicle_id + "\n";
	}
}