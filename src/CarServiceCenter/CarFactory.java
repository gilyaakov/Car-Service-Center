package CarServiceCenter;
import java.util.Random;

public class CarFactory 
{
	private String namePool[] = new String[] {"Ron", "Gil", "Eli", "Matan","Nir","Mico"};
	private int carYear;
	private String ownerName;
	private String carId;
	private String phoneNum;
	

	public CarFactory() 
	{
		Random rand = new Random();
	    int rand_int = rand.nextInt(5);
		phoneNum = generateRandomNumber(10);
		carId = generateRandomNumber(7);
		carYear = Integer.parseInt(generateRandomNumber(3)) + 1000;
		ownerName = namePool[rand_int];		    
	}
	
	public void resetFactory()
	{
		Random rand = new Random();
	    int rand_int = rand.nextInt(5);
		phoneNum = generateRandomNumber(10);
		carId = generateRandomNumber(7);
		carYear = Integer.parseInt(generateRandomNumber(3)) + 1000;
		ownerName = namePool[rand_int];	
	}
	

	public Vehicle getCar()
	{
		Random rand = new Random();
	    int rand_int = rand.nextInt(2);
	    
	    if(rand_int == 0)
	    {
	    	PrivateCar car = new PrivateCar("Private", this.getCarYear(), this.getCarId(), this.getOwnerName(), this.getPhoneNum(), 4);
	    	return car;
	    }
	    else if(rand_int == 1)
	    {
	    	Truck truck = new Truck("Truck", this.getCarYear(), this.getCarId(), this.getOwnerName(), this.getPhoneNum(), 8);
	    	return truck;
	    }
	    else
	    {
	    	MotorCycle mCycle = new MotorCycle("MotorCycle", this.getCarYear(), this.getCarId(), this.getOwnerName(), this.getPhoneNum(), 2);
	    	return mCycle;
	    }		
	}
	
	
	public static String generateRandomNumber(int len) {
		String chars = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	
	public static String generateRandomYear(int len) {
		String chars = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	
	public String[] getNamePool() {
		return namePool;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getCarId() {
		return carId;
	}

	public int getCarYear() {
		return carYear;
	}

	public String getOwnerName() {
		return ownerName;
	}
}
