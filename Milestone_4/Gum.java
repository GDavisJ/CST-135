public class Gum extends Snack{
    private String gumName;
    private double gumPrice;
    private int gumQuantity;
    private String gumLocation;

    public Gum(String name, double price, int quantity, String location) {
        gumName = name;
        gumPrice = price;
        gumQuantity = quantity;
        gumLocation = location;
    }

    public Gum() {
        gumName = "N/A";
        gumPrice = 0;
        gumQuantity = 0;
        gumLocation = "N/A";
    }
    public Gum(Gum GO) {
    	gumName = GO.gumName;
    	gumPrice = GO.gumPrice;
    	gumQuantity = GO.gumQuantity;
    	gumLocation = GO.gumLocation;
    }

    @Override
    public String toString() {
        StringBuilder t = new StringBuilder();
        t.append("Gum: ").append(gumName)
                .append(";   ")
                .append("Price: ").append(gumPrice)
                .append(";   ")
                .append("Quantity: ").append(gumQuantity)
                .append(";   ")
        		.append("Location: ").append(gumLocation);
        return t.toString();
    }
//----------------------------------------------------------------------------\\    
    public void setName(String Name){gumName = Name;}

    public String getName(){return this.gumName;}

    public void setPrice(double Price){gumPrice = Price;}

    public double getPrice(){return this.gumPrice;}

    public void setQuantity(int Quantity){gumQuantity = Quantity;}

    public int getQuantity(){return gumQuantity;}
    
    public void setLocation(String Location){gumLocation = Location;}

    public String getLocation(){return gumLocation;}
    
}