public class Candy extends Snack{
    private String canName;
    private double canPrice;
    private int canQuantity;
    private String canLocation;

    public Candy(String name, double price, int quantity, String location) {
        canName = name;
        canPrice = price;
        canQuantity = quantity;
        canLocation = location;
    }

    public Candy() {
        canName = "N/A";
        canPrice = 0;
        canQuantity = 0;
        canLocation = "N/A";
    }
    
    public Candy(Candy C) {
    	canName = C.canName;
    	canPrice = C.canPrice;
    	canQuantity = C.canQuantity;
    	canLocation = C.canLocation;
    }


	@Override
    public String toString() {
        StringBuilder t = new StringBuilder();
        t.append("Candy: ").append(canName)
                .append(";   ")
                .append("Price: ").append(canPrice)
                .append(";   ")
                .append("Quantity: ").append(canQuantity)
                .append(";   ")
        		.append("Location: ").append(canLocation);
        return t.toString();
    }
//----------------------------------------------------------------------------\\    
    public void setName(String Name){canName = Name;}

    public String getName(){return this.canName;}

    public void setPrice(double Price){canPrice = Price;}

    public double getPrice(){return this.canPrice;}

    public void setQuantity(int Quantity){canQuantity = Quantity;}

    public int getQuantity(){return canQuantity;}
    
    public void setLocation(String Location){canLocation = Location;}

    public String getLocation(){return canLocation;}
    
}
