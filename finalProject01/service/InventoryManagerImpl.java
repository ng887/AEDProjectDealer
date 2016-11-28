package finalProject01.service;

import java.util.HashSet;

import finalProject01.dao.InventoryDAO;
import finalProject01.dto.InventoryResults;

public class InventoryManagerImpl implements InventoryManager {
	InventoryDAO InventoryDAO = new InventoryDAO();
	
	@Override
	public InventorySearchControl getInventorySearchControl(String dealerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InventoryResults getInventoryResults(String dealerId) {
		// TODO Auto-generated method stub
		return InventoryDAO.getInventory(dealerId);
	}

	@Override
	public InventorySearchControl getInventorySearchControlForMakeSelection(String make, String dealerId) {
		HashSet<String>  = new HashSet<String>();
        for (Vehicle ve: pool.values()) ls.add(ve.getMake());
        
        return ls;
		return null;
	}

	@Override
	public Inventory sort(String sortCriterion, Inventory inventory) {
		// TODO Auto-generated method stub
		return null;
	}

}
