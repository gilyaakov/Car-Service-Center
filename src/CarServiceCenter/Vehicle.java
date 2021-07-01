package CarServiceCenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.lang.Cloneable;

public abstract class Vehicle extends Thread implements Cloneable{
	String vehicle_type;
	int manufacture_year;
	String license_plate_num;
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
	    List<Boolean> list=new ArrayList<Boolean>(Arrays.asList(new Boolean[3]));
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
	public String toString() {
	    return (vehicle_type.toString() + " " +"|" + manufacture_year + " " +"|" + license_plate_num.toString() + " " +"|" + owner_name.toString() + " " +"|" +
	    		owner_phone.toString() + " " + "|" + bill);
	}
	@Override
    protected Vehicle clone()
        throws CloneNotSupportedException
    {
        return (Vehicle)super.clone();
    }
	public void run() {
		((Inspection)CarServiceCenter.WorkStations.get(3)).startInspection(this);
		CarServiceCenter.menu.add("Car number: " + this.getLicensePlateNum() +  " started Repair");
	        this.startRepair();
	    }  
	public void startRepair() {
		 
		String s = "";
		 
		 if (this.work_stations.get(0)){
			 ((Tiers)CarServiceCenter.WorkStations.get(0)).startTiers(this);
			 s+="Tiers ";
		 }
		 if (this.work_stations.get(1)){
			 ((Electric)CarServiceCenter.WorkStations.get(1)).startElectric(this);
			 s+="Electric ";
		 }
		 if (this.work_stations.get(2)){
			 ((Engine)CarServiceCenter.WorkStations.get(2)).startEngine(this);
			 s+="Engine ";
		 }
		 try {
			CarServiceCenter.financeDepartment.addPayment(bill, owner_phone, owner_name, s);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}