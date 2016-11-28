package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import dao.DealersDAO.DealersParser;
import dto.Vehicle;
import dto.Dealer;
import dto.Inventory;

public class InventoryDAO {
	
	private String[] InventoryColumns;
	//String dealerInventoryFile = "/Users/vibho/Desktop/AEDProject/data/car-dealers.txt";
	File[] inventoryFiles;
	
	public InventoryDAO(){
		 	File inventories = new File("/Users/vibho/Desktop/AEDProject/data/inventory");
	        inventoryFiles = inventories.listFiles();
	        System.out.println("^^^^" + inventoryFiles[0]);
	        
	}
	
	//instead of readFiles
	public HashMap<String, Inventory> getDealerInvertoryInfoFromFile() {
        // TODO Auto-generated method stub
        
       
		InventoryParser ip = new InventoryParser();

        for (File dealerInventoryFile: inventoryFiles) {
            ip.ReadFileHelper(dealerInventoryFile); // inv
            ip.AddInventoryToPool();
        }
		/*
        for (int i=0; i<1; i++) {
            ip.ReadFileHelper(inventoryFiles[i]); // inv
            ip.AddInventoryToPool();
        }
                */
        return ip.inventoryPool;
        
    }
    
	class InventoryParser extends ReadFile {
		
		private Inventory inventory;
		private HashMap<String, Inventory> inventoryPool;
		private boolean isDealerIDSet;
		private String dealerID;
		//HashMap<String, Vehicle> inventory;
		
		InventoryParser(){
			ResetInventoryParser();
			inventoryPool = new HashMap<String, Inventory>();
		}
		
		private	void ResetInventoryParser(){
			isDealerIDSet = false;
			inventory = new Inventory();
		}
		
		@Override
		public void ReadFileLine(String line) {
			InventoryColumns = line.split("~");
			System.out.println("**********" + InventoryColumns.length + "##########");
			readInventory();
		}

		private void readInventory() {
			Vehicle vehicle = new Vehicle(); //id~webId~category~year~make~model~trim~type~price
            vehicle.setId(InventoryColumns[0]);
            vehicle.setWebId(InventoryColumns[1]);
            if(!isDealerIDSet) {
            	dealerID = InventoryColumns[1];
            	isDealerIDSet = true;
            }
            
            vehicle.setCategory(InventoryColumns[2]);
            vehicle.setYear(InventoryColumns[3]);
            vehicle.setMake(InventoryColumns[4]);
            vehicle.setModel(InventoryColumns[5]);
            vehicle.setTrim(InventoryColumns[6]);
            vehicle.setType(InventoryColumns[7]);
            vehicle.setPrice(InventoryColumns[8]);
            
            inventory.addVehicle(vehicle);
    	}

		public void AddInventoryToPool() {
			if (!inventoryPool.containsKey(dealerID)) {
				inventoryPool.put(dealerID, inventory);
			}
			
			ResetInventoryParser();
		}
		
		 
		    
		

	}

}
