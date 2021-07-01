package CarServiceCenter;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JOptionPane;

public class CarServiceCenter {
	
	protected static MobilePhone connections;
	protected static Finance financeDepartment;
	protected static ArrayList<WorkStation> WorkStations;
	protected static OptionPane menu;

	protected CarServiceCenter() throws CloneNotSupportedException {
		connections = new MobilePhone();
		financeDepartment = new Finance();
		menu = new OptionPane();
		WorkStations = new ArrayList<WorkStation>();
		Tiers s1 = new Tiers("Boaz", 300, 1000, 0);
		Electric s2 = new Electric("Hezi", 400, 1000, 0);
		Engine s3 = new Engine("Eli", 500, 1000, 0);
		Inspection s4 = new Inspection("Ron", 600, 100, 0);
		CarServiceCenter.WorkStations.add(s1);
		CarServiceCenter.WorkStations.add(s2);
		CarServiceCenter.WorkStations.add(s3);
		CarServiceCenter.WorkStations.add(s4);
	}
	// This function set station parameters
	protected void setStation() throws Exception{
		String option = " "; 
		option = JOptionPane.showInputDialog("Enter Option: 1. Tiers 2. Electric 3. Engine 4. Inspection"); // Read user input
		if(option == null) {return;}
		String name;
		int price;
		int duration;
		try {
		switch (option) {
		  case "1":
			    name = JOptionPane.showInputDialog("Enter station manager name:"); // Read user input
			    if(name == null) {return;}
			    CarServiceCenter.WorkStations.get(0).setStation_manager(name);
			    try {
				    price = Integer.parseInt(JOptionPane.showInputDialog("Enter price:")); // Read user input
				    }
				    catch(NumberFormatException e) {
				    	return;
				    }
			    if(price < 1 || price > 1000) { // Input integrity check
			    	JOptionPane.showMessageDialog(null,"Illegal price","ERROR",JOptionPane.PLAIN_MESSAGE);
			    	break;
			    }
			    CarServiceCenter.WorkStations.get(0).setPrice(price);
			    try {
			    duration = Integer.parseInt(JOptionPane.showInputDialog("Enter duration:")); // Read user input
			    }
			    catch(NumberFormatException e) {
			    	return;
			    }
			    if(duration < 1 || duration > 1000) { // Input integrity check
			    	JOptionPane.showMessageDialog(null,"duration","ERROR",JOptionPane.PLAIN_MESSAGE);
			    	break;
			    }
			    CarServiceCenter.WorkStations.get(0).setDuration(duration);
		        break;
		  case "2":
			    name = JOptionPane.showInputDialog("Enter station manager name:"); // Read user input
			    if(name == null) {return;}
			    CarServiceCenter.WorkStations.get(1).setStation_manager(name);
			    try {
				    price = Integer.parseInt(JOptionPane.showInputDialog("Enter price:")); // Read user input
				    }
				    catch(NumberFormatException e) {
				    	return;
				    }
			    if(price < 1 || price > 1000) { // Input integrity check
			    	JOptionPane.showMessageDialog(null,"Illegal price","ERROR",JOptionPane.PLAIN_MESSAGE);
			    	break;
			    }
			    CarServiceCenter.WorkStations.get(1).setPrice(price);
			    try {
				    duration = Integer.parseInt(JOptionPane.showInputDialog("Enter duration:")); // Read user input
				    }
				    catch(NumberFormatException e) {
				    	return;
				    }
			    if(duration < 1 || duration > 1000) { // Input integrity check
			    	JOptionPane.showMessageDialog(null,"duration","ERROR",JOptionPane.PLAIN_MESSAGE);
			    	break;
			    }
			    CarServiceCenter.WorkStations.get(1).setDuration(duration);
		        break;
		  case "3":
			    name = JOptionPane.showInputDialog("Enter station manager name:"); // Read user input
			    if(name == null) {return;}
			    CarServiceCenter.WorkStations.get(2).setStation_manager(name);
			    try {
			    price = Integer.parseInt(JOptionPane.showInputDialog("Enter price:")); // Read user input
			    }
			    catch(NumberFormatException e) {
			    	return;
			    }
			    if(price < 1 || price > 1000) { // Input integrity check
			    	JOptionPane.showMessageDialog(null,"Illegal price","ERROR",JOptionPane.PLAIN_MESSAGE);
			    	break;
			    }
			    CarServiceCenter.WorkStations.get(2).setPrice(price);
			    try {
				    duration = Integer.parseInt(JOptionPane.showInputDialog("Enter duration:")); // Read user input
				    }
				    catch(NumberFormatException e) {
				    	return;
				    }
			    if(duration < 1 || duration > 1000) { // Input integrity check
			    	JOptionPane.showMessageDialog(null,"duration","ERROR",JOptionPane.PLAIN_MESSAGE);
			    	break;
			    }
			    CarServiceCenter.WorkStations.get(2).setDuration(duration);
		        break;
		  case "4":
			    name = JOptionPane.showInputDialog("Enter station manager name:"); // Read user input
			    if(name == null) {return;}
			    CarServiceCenter.WorkStations.get(3).setStation_manager(name);
			    try {
				    price = Integer.parseInt(JOptionPane.showInputDialog("Enter price:")); // Read user input
				    }
				    catch(NumberFormatException e) {
				    	return;
				    }
			    if(price < 1 || price > 1000) { // Input integrity check
			    	JOptionPane.showMessageDialog(null,"Illegal price","ERROR",JOptionPane.PLAIN_MESSAGE);
			    	break;
			    }
			    CarServiceCenter.WorkStations.get(3).setPrice(price);
			    try {
				    duration = Integer.parseInt(JOptionPane.showInputDialog("Enter duration:")); // Read user input
				    }
				    catch(NumberFormatException e) {
				    	return;
				    }
			    if(duration < 1 || duration > 1000) { // Input integrity check
			    	JOptionPane.showMessageDialog(null,"duration","ERROR",JOptionPane.PLAIN_MESSAGE);
			    	break;
			    }
			    CarServiceCenter.WorkStations.get(3).setDuration(duration);
		        break;
		  default:
			    JOptionPane.showMessageDialog(null,"No such option","ERROR",JOptionPane.PLAIN_MESSAGE);
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	// This function print all the work stations
	protected void printWorkStations() {
		JOptionPane.showMessageDialog(null,WorkStations,"Work Stations",JOptionPane.PLAIN_MESSAGE);
		
	}
	// This function control the mobile phone
	protected void connectionsControl() {
		CarServiceCenter.connections.menu();	
	}
	// This function control the finance department
	protected void financeControl() {
		CarServiceCenter.financeDepartment.menu();	
	}
	// This function print all the car service center
	protected void printCarServiceCenter() {

		// here print the workstations
	    JOptionPane.showMessageDialog(null,connections.pb,"Phone Book",JOptionPane.PLAIN_MESSAGE);
	    JOptionPane.showMessageDialog(null,connections.myDiary,"Diary",JOptionPane.PLAIN_MESSAGE);
	    JOptionPane.showMessageDialog(null,connections.smsSystem.printAllCorresponding(),"Messages",JOptionPane.PLAIN_MESSAGE);
	    JOptionPane.showMessageDialog(null,connections.myPlayer.playAll(),"Player",JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null,financeDepartment,"Finance Department",JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null,WorkStations,"Work Stations",JOptionPane.PLAIN_MESSAGE);
	}
	// This function make simulation
	protected void simulation() throws InterruptedException {
		CarServiceCenter.menu.simulation();
		CarFactory c = new CarFactory();
		for(int i = 0 ; i < 2 ; i++) {
			c.getCar().start();
			Thread.sleep(1000);
			c.resetFactory();
		}
	}
	// This function is the main menu
	protected void mainMenu() {
		while(true) {
			switch (menu.waitForOption(this.printMenu())) {
			  case "1":
				try {
					this.setStation();
				} catch (Exception e1) {
				}
			        break;
			  case "2":
				    this.printWorkStations();
			        break;
			  case "3":
				    this.connectionsControl();
			        break;
			  case "4":
				    this.financeControl();
			        break;
			  case "5":
				    this.printCarServiceCenter();
			        break;
			  case "6":
				try {
					this.simulation();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			        break;
			  case "7":
				    menu.close();
				    JOptionPane.showMessageDialog(null,"Goodbye!","Note",JOptionPane.PLAIN_MESSAGE);
				    return;
			  default:
				    JOptionPane.showMessageDialog(null,"No such option","ERROR",JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
	// Printing the menu
	protected String printMenu() {
		String str1,str2,str3,str4,str5,str6,str7;
		str1 = "1. Set Station\n";
		str2 = "2. Print Work Stations\n";
		str3 = "3. Connections\n";
		str4 = "4. Finance Department\n";
		str5 = "5. Print Car Service Center\n";
		str6 = "6. Simulation\n";
		str7 = "7. Exit\n";
		return str1+str2+str3+str4+str5+str6+str7;
	}
}
