package finalProject01.service;

import java.util.List;

public interface DealerManager {
	//public List<Dealer> getAllDealersInSystem();
	
	public List<String> getAllDealerNamesInSystem(); // in class
	
	//By group 02
	//public HashMap<String,Dealer> getDealersInSystem();
	public String getDealerIDByNameInSystem (String name);
}
