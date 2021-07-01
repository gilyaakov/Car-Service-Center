package CarServiceCenter;
import java.util.concurrent.Semaphore;
import java.util.Random;


public class Inspection extends WorkStation  
{
	private Semaphore sem;
	private static int allowed = 2;		// Lets do that 2 car can be inspected at the same time
	
	public Inspection(String name, int price, int duration, int counter) 
	{
		super( name,  price,  duration,  counter);
		this.sem = new Semaphore(allowed);
	}
	public void startInspection(Vehicle car)
	{	
		// Lock the Station
		CarServiceCenter.menu.add("Car number: " + car.getLicensePlateNum() + " Waiting for inspection");
		car.setBill(this.getPrice());
		try {
			this.sem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CarServiceCenter.menu.add("Car number: " + car.getLicensePlateNum() +  " started inspection");
		this.setVehicle_id(car.getLicensePlateNum());
		this.setCounter(this.getCounter() + 1);
		// Randomize the fixes the Car need
		Random rand = new Random();
	    int rand_int1 = rand.nextInt(2);
        int rand_int2 = rand.nextInt(2);
        int rand_int3 = rand.nextInt(2);
        
        if(rand_int1 == 1)
        {
        	car.setStation(1);
        }
        if(rand_int2 == 1)
        {
        	car.setStation(2);
        }
        if(rand_int3 == 1)
        {
        	car.setStation(3);
        }
		// Sleep for the duration of the station work - make sure assign this.duration right
		try
		{
			Thread.sleep(this.getDuration());
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		CarServiceCenter.menu.add("Inspection Done with car: " + car.getLicensePlateNum());
		this.sem.release();
	}

}