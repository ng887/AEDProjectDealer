package finalProject01.dto;

import java.util.HashMap;
import java.util.List;

public class InventoryPool {
	
	
	
	private HashMap<String, Inventory> inventories;
	
	
	 public InventoryPool() {
	        inventories = new HashMap<String, Inventory>();
	    }
	    

	public HashMap<String, Inventory> getInventory() {
		return inventories;
	}

	public void setInventory(HashMap<String, Inventory> inventories) {
		this.inventories = inventories;
	}

	 public Inventory getInventoryByDealerID(String dealerId) {
	        
	        if (inventories.containsKey(dealerId)) return inventories.get(dealerId);
	        return null;
	        
	    }


	public void addInventory(String dealerID, Inventory inventory) {
		// TODO Auto-generated method stub
		 if (!inventories.containsKey(dealerID)) inventories.put(dealerID, inventory);
	}
	
	//public List<Vehicle> vehicles; -- class
}
