package CarServiceCenter;

import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JOptionPane;

public class CarServiceCenter {
	
	protected static MobilePhone connections;
	//protected static Finance financeDepartment;
	//ArrayList<Printable> WorkStations;

	protected CarServiceCenter() {
		connections = new MobilePhone();
		//financeDepartment = new Finance();
		//WorkStations = new ArrayList<Printable>();
		//Build up all the 4 stations here
	}
	// This function add work stations to WorkStations array
	/*protected void addStation(WorkStation s) {
	*	
	*}
	*/
	// This function print station by name
	/*protected void printStation(String name) {
	*	
	*}
	*/
	// This function set station parameters
	/*protected void setStation() {
	*	
	*}
	*/
	// This function print all the work stations
	/*protected void printWorkStations() {
	*	
	*}
	*/
	// This function control the mobile phone
	protected void connectionsControl() {
		CarServiceCenter.connections.menu();	
	}
	// This function control the finance department
	/*protected void financeControl() {
	*	CarServiceCenter.financeDepartment.menu();	
	*}
	*/
	// This function print all the car service center
	/*protected void printCarServiceCenter() {
	* 
	*}
	*/
	// This function make simulation
	/*protected void simulation() {
	* 
	*}
	*/
	// This function is the main menu
	protected void mainMenu() {
		while(true) {
			OptionPane menu = new OptionPane(this.printMenu());
			switch (menu.option) {
			  case "1":
			        break;
			  case "2":
			        break;
			  case "3":
			        break;
			  case "4":
			        break;
			  case "5":
				    this.connectionsControl();
			        break;
			  case "6":
			        break;
			  case "7":
			        break;
			  case "8":
			        break;
			  case "9":
				    JOptionPane.showMessageDialog(null,"Goodbye!","Note",JOptionPane.PLAIN_MESSAGE);
				    return;
			  default:
				    JOptionPane.showMessageDialog(null,"No such option","ERROR",JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
	// Printing the menu
	protected String printMenu() {
		String str1,str2,str3,str4,str5,str6,str7,str8,str9,str10;
		str1 = "1. Add Station\n";
		str2 = "2. Print Station\n";
		str3 = "3. Set Station\n";
		str4 = "4. Print Work Stations\n";
		str5 = "5. Connections\n";
		str6 = "6. Finance Department\n";
		str7 = "7. Print Car Service Center\n";
		str8 = "8. Simulation\n";
		str9 = "9. Exit\n";
		str10 = "Enter option:\n";
		return str1+str2+str3+str4+str5+str6+str7+str8+str9+str10;
	}

}
