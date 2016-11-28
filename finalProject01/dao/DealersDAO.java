package finalProject01.dao;


import java.util.List;

public interface DealersDAO {

	//public List<Dealer> readDealers(); -- added in class
	
	// Added by group02
	public void readDealers();
//	public HashMap<String,Dealer> getDealers();
	public List<String> getDealerNameList();
	public String getDealerIDByName (String name);
}
