package service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import dto.Dealer;
import dao.DealersDAO;



public class DealerManager {
	
	/*
	//public List<Dealer> getAllDealersInSystem();
	
	public List<String> getAllDealerNamesInSystem(); // in class
	
	//By group 02
	//public HashMap<String,Dealer> getDealersInSystem();
	public String getDealerIDByNameInSystem (String name);
	
	*/
		
	  DealersDAO dealerDAO = new DealersDAO();
	  private HashMap<String, Dealer> dealerManager;
	    
	    

	    public DealerManager() {
	    	dealerManager = dealerDAO.GetDealerInfoFromFile();
	    }
	    
	  /*  public void addDealer(Dealer dealer) {
	        if (!dealerManager.containsKey(dealer.getName())) {
	        	dealerManager.put(dealer.getName(), dealer);
	        }
	    }
	   */ 
	/*    public void addDealer(String id, String name, String url) {
	        if (!dealerManager.containsKey(name)) dealerManager.put(name, new Dealer(id, name, url));
	    }
	*/
	    
	    public Set<String> getDealersName() {
	        return dealerManager.keySet();
	    }
	    
	    public String getDealerIDbyName(String name) {
	        if (dealerManager.containsKey(name)) {
	            Dealer dealer = dealerManager.get(name);
	            return dealer.getId();
	        }
	        return null;
	    }


}
