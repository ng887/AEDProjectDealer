package dto;

public class Vehicle {
    
    private String id;
    private String webId;
    private String category;
    private int year;
    private String make;
    private String model;
    private String trim;
    private String type;
    private double price;
    

    /*
    public Vehicle() {
        
    }

    
    public Vehicle(String id, String webId, String category, String year, String make, String model, String trim, String type,
            String price) {
        super();
        this.id = id;
        this.webId = webId;
        this.category = category;
        this.year = Integer.parseInt(year);
        this.make = make;
        this.model = model;
        this.trim = trim;
        this.type = type;
        this.price = Double.parseDouble(price);
        
        
    }
    */
    
    public String[] getVehicleInfo() {
        
        return new String[]{id, webId, category, year + "", make, model, trim, type,
                price + ""};
    }


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getWebId() {
        return webId;
    }
    public void setWebId(String webId) {
        this.webId = webId;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = Integer.parseInt(year);
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getTrim() {
        return trim;
    }
    public void setTrim(String trim) {
        this.trim = trim;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = Double.parseDouble(price);
    }
    
    
    public String toString() {
        
        return id + " " + webId + " " + category + " " + year + " " + " " + make + " " +model + " " + trim + " " + type + " " +price;
  
    }
   
}
