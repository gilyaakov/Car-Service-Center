package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.lang.Cloneable;

public abstract class Vehicle extends Thread implements Cloneable{
	String vehicle_type;
	int manufacture_year;
	String license_plate_num;  		//changed from int to string
	String owner_name;
	String owner_phone;
	int bill=0;
	List<Boolean> work_stations; 
	
	public Vehicle(String type, int year, String license, String owner_name, String owner_phone) {
	    this.vehicle_type = type;
	    this.manufacture_year = year;
	    this.license_plate_num = license;
	    this.owner_name = owner_name;
	    this.owner_phone = owner_phone;
	    List<Boolean> list=new ArrayList<Boolean>(Arrays.asList(new Boolean[2]));
	    Collections.fill(list, Boolean.FALSE);
	    this.work_stations = list;
	}
	
	public void setStation(int st)
	{
		if(st == 1)
		{
			this.work_stations.set(0 ,true);
		}
		
		else if(st == 2)
		{
			this.work_stations.set(1 ,true);
		}
			
		else if(st == 3)
		{
			this.work_stations.set(2 ,true);
		}
		else
		{
			System.out.println("Wrong input to set funtion");	//TODO: delete later after debug
		}		
			
		
	}
	
	public List<Boolean> getStations()
	{
		return this.work_stations;
		
	}
	 public String getType() {
		 return this.vehicle_type;
	 }
	 
	 public int getManufactureYear() {
		 return this.manufacture_year;
	 }
	 
	 public String getLicensePlateNum() {
		 return this.license_plate_num;
	 }
	
	public int getBill() {
		return this.bill;
	}
	
	public void setBill(int bill) {
		this.bill=bill;
	}
	
	public void setLicencePlate(String licence) {
		this.license_plate_num=licence;
	}
	
	public void setManufactureYear(int year) {
		this.manufacture_year= year;
	}
	
	public void setType(String type){
		this.vehicle_type=type;
	}
	
	
	/*
	public void addStation(String station ) {
		this.work_stations.add(station);
	}
	*/
	
	public String toString() {
	    return (vehicle_type.toString() + " " +"|" + manufacture_year + " " +"|" + license_plate_num.toString() + " " +"|" + owner_name.toString() + " " +"|" +
	    		owner_phone.toString() + " " + "|" + bill);
	}
	
	//public string returnStations() {
	//	
	//}
	
	@Override
    protected Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }
	
	/* public void run()  
	    {    
	        System.out.println("Vehicle starts repair..."); 
	        this.startRepair();
	    }  
	 
	 public void startRepair() {
		 for (int i=0; i<work_stations.size(); i++) {
			 if (work_stations.get(i)=="Inspection"){
				 super.WorkStation[0].startInspection();
			 } 
			 if (work_stations.get(i)=="Electric"){
				 super.WorkStation[1].startElectric();
			 } 	 
			 if (work_stations.get(i)=="Engine"){
				 super.WorkStation[2].startEngine();
			 } 	 
			 if (work_stations.get(i)=="Tiers"){
				 super.WorkStation[0].startTiers();
			 } 
		 }		 
	 } */
	 
}