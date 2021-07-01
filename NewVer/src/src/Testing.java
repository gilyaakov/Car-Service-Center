package src;

import java.util.concurrent.Semaphore;

public class Testing extends Thread 
{
	Semaphore sem = null;
	Inspection st1 = new Inspection("Inspection", 100, 5, 0, 1, sem);
	
    public void run(){
        System.out.println("MyThread running");
		PrivateCar car1 = new PrivateCar("Private", 1970, "5344453", "Ron", "0523905057",4);
		st1.startInspection(car1);
     }

	
	public Testing() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {	
		PrivateCar car1 = new PrivateCar("Private", 1970, "5344453", "Ron", "0523905057",4);
		PrivateCar car2 = new PrivateCar("Private", 1955, "5344453", "Nirn", "0523905057",4);
		Thread th1 = new Thread();
		Thread th2 = new Thread();
		th1.start();
		th2.start();
		
	}

}
