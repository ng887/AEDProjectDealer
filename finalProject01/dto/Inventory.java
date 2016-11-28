package finalProject01.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Inventory {


	private HashMap<String, Vehicle> vehicles;

	public HashMap<String, Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(HashMap<String, Vehicle> vehicles) {
		this.vehicles = vehicles;
	}


	/*private String[] titles;

    public Inventory() {
    	vehicles = new HashMap<String, Vehicle>();

    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public String[] getTitles() {
        return titles;
    }

    public void addVehicle(Vehicle vehicle) {
        if (!vehicles.containsKey(vehicle.getId())) {
        	vehicles.put(vehicle.getId(), vehicle);
        }
    }

    public Collection<Vehicle> getAllVehicles() {
        return vehicles.values();
    }
	 */
	/*public HashSet<String> getAllType() {
        HashSet<String> ls = new HashSet<String>();
        for (Vehicle ve: pool.values()) {
            ls.add(ve.getType());
        }

        return ls;   
    }

    public HashSet<String> getAllCategory() {
        HashSet<String> ls = new HashSet<String>();
        for (Vehicle ve: pool.values()) {
            ls.add(ve.getCategory());
        }

        return ls; 
    }

    public HashSet<String> getAllModel() {

        HashSet<String> ls = new HashSet<String>();
        for (Vehicle ve: pool.values()) ls.add(ve.getModel());

        return ls;
    }

    public HashSet<String> getAllMaker() {
        HashSet<String> ls = new HashSet<String>();
        for (Vehicle ve: pool.values()) ls.add(ve.getMake());

        return ls;
    }

    public void removeVehicle(String vehicleID) {
        if (pool.containsKey(vehicleID)) {
            pool.remove(vehicleID);
        }
    }

    public void modifyCategory(String vehicleID, String category) {
        if (pool.containsKey(vehicleID)) {
            Vehicle ve = pool.get(vehicleID);
            ve.setCategory(category);
        }
    }

    public void modifyYear(String vehicleID, String year) {
        if (pool.containsKey(vehicleID)) {
            Vehicle ve = pool.get(vehicleID);
            ve.setYear(year);
        }
    }

    public void modifyMaker(String vehicleID, String make) {
        if (pool.containsKey(vehicleID)) {
            Vehicle ve = pool.get(vehicleID);
            ve.setMake(make);
        }
    }

    public void modifyModel(String vehicleID, String model) {
        if (pool.containsKey(vehicleID)) {
            Vehicle ve = pool.get(vehicleID);
            ve.setModel(model);
        }
    }

    public void modfiyTrime(String vehicleID, String trim) {
        if (pool.containsKey(vehicleID)) {
            Vehicle ve = pool.get(vehicleID);
            ve.setTrim(trim);
        }
    }

    public void modfiyType(String vehicleID, String type) {
        if (pool.containsKey(vehicleID)) {
            Vehicle ve = pool.get(vehicleID);
            ve.setType(type);
        }
    }

    public void modifyPrice(String vehicleID, String price) {
        if (pool.containsKey(vehicleID)) {
            Vehicle ve = pool.get(vehicleID);
            ve.setPrice(price);
        }
    }
	 */




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}






}
