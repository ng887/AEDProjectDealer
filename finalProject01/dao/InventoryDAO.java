package finalProject01.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


import finalProject01.dto.Vehicle;
import finalProject01.dto.Inventory;
import finalProject01.dto.InventoryPool;

public class InventoryDAO {
	
	private String[] InventoryColumns;
	Inventory inventory = new Inventory();
	
	HashMap<String, Vehicle> vehiclesInventory;
	InventoryPool inventoryPool = new InventoryPool();
	
	InventoryDAO(){
		 	File inventories = new File("/Users/vibho/Desktop/AEDProject/data");
	        File[] inventoryFiles = inventories.listFiles();
	        readFiles(inventoryFiles);
	        
	}
	
	
	public InventoryPool readFiles(File[] inventoryFiles) {
        // TODO Auto-generated method stub
        
       // InventoryPool inventoryPool = new InventoryPool();
        
        for (File dealerInventoryFile: inventoryFiles) {
           // if(file.isHidden()) continue;
            
            new InventoryParser().ReadFileHelper(dealerInventoryFile); // inv
            String dealerID = this.getDealerId(dealerInventoryFile);
            inventoryPool.addInventory(dealerID, inventory);
        }
        
        return inventoryPool;
        
    }
    
    
	private String getDealerId(File dealerInventoryFile) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(dealerInventoryFile));
            String data = br.readLine();
            data = br.readLine();
//            System.out.println(data);
            String[] seq = data.split("~");
            String id = seq[1];
            br.close();
            return id;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
    
   
	
	public Inventory getInventory(String dealerId) {
		   if (inventoryPool.getInventory().containsKey(dealerId)) return inventoryPool.getInventory().get(dealerId);
	        return null;
		
	}
	
	class InventoryParser extends ReadFile {


		@Override
		public void ReadFileLine(String line) {
			InventoryColumns = line.split("~");
			readInventory();
		}

		private void readInventory() {
			Vehicle vehicle = new Vehicle(); //id~webId~category~year~make~model~trim~type~price
            vehicle.setId(InventoryColumns[0]);
            vehicle.setWebId(InventoryColumns[1]);
            vehicle.setCategory(InventoryColumns[2]);
            vehicle.setYear(InventoryColumns[3]);
            vehicle.setMake(InventoryColumns[4]);
            vehicle.setModel(InventoryColumns[5]);
            vehicle.setTrim(InventoryColumns[6]);
            vehicle.setType(InventoryColumns[7]);
            vehicle.setPrice(InventoryColumns[8]);
            addVehicle(vehicle);
            
    	}

		private void addVehicle(Vehicle vehicle) {
			if (!vehiclesInventory.containsKey(vehicle.getId())) {
            	vehiclesInventory.put(vehicle.getId(), vehicle);
            	inventory.setVehicles(vehiclesInventory);
            }
		}
		
		 
		    
		

	}

}
