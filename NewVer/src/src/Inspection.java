package src;
import java.util.concurrent.Semaphore;
import java.util.Random;


public class Inspection extends WorkStation  
{
	private Semaphore sem;
	private static int allowed = 2;		// Lets do that 2 car can be inspected at the same time
	
	public Inspection(String name, int price, int duration, int counter, int id, Semaphore sema) 
	{
		super( name,  price,  duration,  counter,  id);
		this.sem = new Semaphore(allowed);
	}
	
	// TODO: Add car input - adjust prints and variables after done
	// TODO: need to write to the car WorkStation ArrayList via setter
	public void startInspection(Vehicle car)
	{	
		// Lock the Station
		System.out.println("Car number " + car.getLicensePlateNum() + "Wating for inspection");
		
		try {
			this.sem.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Car number " + car.getLicensePlateNum() +  "started inspection");
		
		// Randomize the fixes the Car need
		Random rand = new Random();
	    int rand_int1 = rand.nextInt(1);
        int rand_int2 = rand.nextInt(1);
        int rand_int3 = rand.nextInt(1);
        
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
        
        System.out.println("Inspection Done with car: " + car.getLicensePlateNum());    
		this.sem.release();
	}

}
