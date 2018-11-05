public class Chips extends Snack{
private String chipName;
    private double chipPrice;
    private int chipQuantity;
    private String chipLocation;

    public Chips(String name, double price, int quantity, String location) {
        chipName = name;
        chipPrice = price;
        chipQuantity = quantity;
        chipLocation = location;
    }

    public Chips() {
        chipName = "N/A";
        chipPrice = 0;
        chipQuantity = 0;
        chipLocation = "N/A";
    }
    public Chips(Chips CO) {
    	chipName = CO.chipName;
    	chipPrice = CO.chipPrice;
    	chipQuantity = CO.chipQuantity;
    	chipLocation = CO.chipLocation;
    }

    @Override
    public String toString() {
        StringBuilder t = new StringBuilder();
        t.append("Chips: ").append(chipName)
                .append(";   ")
                .append("Price: ").append(chipPrice)
                .append(";   ")
                .append("Quantity: ").append(chipQuantity)
                .append(";   ")
        		.append("Location: ").append(chipLocation);
        return t.toString();
    }
//----------------------------------------------------------------------------\\    
    public void setName(String Name){chipName = Name;}

    public String getName(){return this.chipName;}

    public void setPrice(double Price){chipPrice = Price;}

    public double getPrice(){return this.chipPrice;}

    public void setQuantity(int Quantity){chipQuantity = Quantity;}

    public int getQuantity(){return chipQuantity;}
    
    public void setLocation(String Location){chipLocation = Location;}

    public String getLocation(){return chipLocation;}
    
}
