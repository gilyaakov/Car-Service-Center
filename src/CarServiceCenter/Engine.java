package CarServiceCenter;
import java.util.concurrent.Semaphore;

public class Engine extends WorkStation  
{
	private Semaphore sem;
	
	public Engine(String name, int price, int duration, int counter) {
		super( name,  price,  duration,  counter);
		sem = new Semaphore(1);
	}
	
	public void startEngine(Vehicle car)
	{
		CarServiceCenter.menu.add("Car number: " + car.getLicensePlateNum() + " Waiting for Engine fix");
		car.setBill(this.getPrice()+car.getBill());
		// Lock the Station
		try {
			this.sem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CarServiceCenter.menu.add("Car number: " + car.getLicensePlateNum() + " Started Engine fix");
		this.setVehicle_id(car.getLicensePlateNum());
		this.setCounter(this.getCounter() + 1);
		// Sleep for the duration of the station work - make sure assign this.duration right
		// Note: We multiply the duration with the number of tires!
		try {
			Thread.sleep(this.getDuration());
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		// Release Semaphore
		CarServiceCenter.menu.add("Engine station Done with car: " + car.getLicensePlateNum());
		this.sem.release();
	}
	// toString override
	@Override
	public String toString(){
		return super.toString();
	}
}