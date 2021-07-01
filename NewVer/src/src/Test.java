package src;

import java.util.concurrent.Semaphore;

public class Test {

	public Test() 
	{
		Semaphore sem = null;
		Inspection st1 = new Inspection("Inspection", 100, 5, 0, 1, sem);
		PrivateCar car1 = new PrivateCar("Private", 1970, "5344453", "Ron", "0523905057",4);
		PrivateCar car2 = new PrivateCar("Private", 1955, "5344453", "Nirn", "0523905057",4);
		st1.startInspection(car1);
		
	}

}
