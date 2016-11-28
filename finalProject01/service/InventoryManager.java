package finalProject01.service;

import org.neu.project.dto.Inventory;
import org.neu.project.dto.InventoryResults;
import org.neu.project.dto.InventorySearchControl;

public interface InventoryManager {
	public InventorySearchControl getInventorySearchControl(String dealerId);

	public InventoryResults getInventoryResults(String dealerId);

	public InventorySearchControl getInventorySearchControlForMakeSelection(String make, String dealerId);

	public Inventory sort(String sortCriterion, Inventory inventory);

}
