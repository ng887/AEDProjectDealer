package service;

import java.util.HashMap;

//import org.neu.project.dto.Inventory;
//import org.neu.project.dto.InventoryResults;
//import org.neu.project.dto.InventorySearchControl;

import dto.Inventory;
import dao.InventoryDAO;


public class InventoryManager {
	/*public InventorySearchControl getInventorySearchControl(String dealerId);

	public InventoryResults getInventoryResults(String dealerId);

	public InventorySearchControl getInventorySearchControlForMakeSelection(String make, String dealerId);

	public Inventory sort(String sortCriterion, Inventory inventory);
*/
	
	InventoryDAO inventoryDAO = new InventoryDAO();
	  private HashMap<String, Inventory> inventoryManager;
	    
	    

	    public InventoryManager() {
	    	inventoryManager = inventoryDAO.getDealerInvertoryInfoFromFile();
	    }
	    
	    public void addInventory(String dealerID, Inventory inventory) {
	        if (!inventoryManager.containsKey(dealerID)) inventoryManager.put(dealerID, inventory);
	    }
	    
	    public Inventory getInventoryByDealerID(String dealerId) {
	        
	        if (inventoryManager.containsKey(dealerId)) return inventoryManager.get(dealerId);
	        return null;
	        
	    }
}