package dao;


import java.io.File;
import java.util.HashMap;

import dto.Dealer;

public class DealersDAO {

	/*
	//public List<Dealer> readDealers(); -- added in class
	
	// Added by group02
	public void readDealers();
//	public HashMap<String,Dealer> getDealers();
	public List<String> getDealerNameList();
	public String getDealerIDByName (String name);
	*/
	
	private String[] dealerColumns;
	//DealerManager dealerManager; 
	
	public DealersDAO() {
		//dealerManager = new DealerManager();
    }
    
	public HashMap<String, Dealer> GetDealerInfoFromFile() {
		DealersParser dealerParser = new DealersParser();
		dealerParser.ReadFileHelper(new File("/Users/vibho/Desktop/AEDProject/data/car-dealers.txt"));
		return dealerParser.dealersPool;
	}
	 
 
		/*  public DealerManager getDealerManager(){
        return dealerManager;
    }  
   */     
        class DealersParser extends ReadFile {
        	HashMap<String, Dealer> dealersPool;
        	
        	DealersParser() {
        		dealersPool = new HashMap<String, Dealer>();
        	}
        	
    		@Override
    		public void ReadFileLine(String line) {
    			dealerColumns = line.split("\\|");
    			readDealerData();

    			/*dealers.put(dealer.getName(), dealer);
    			dealerNameList.add(dealerColumns[1]);*/
    		}
    		
    		private void readDealerData() {
        		Dealer dealer = new Dealer();
        		dealer.setId(dealerColumns[0]);
        		dealer.setName(dealerColumns[1]);
        		dealer.setUrl(dealerColumns[2]);
        		
        		if (!dealersPool.containsKey(dealer.getName())) {
        			dealersPool.put(dealer.getName(),dealer);
    	        }
        		
            }
    	}
        
    	
}
