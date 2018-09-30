public class Chips extends Snack{
private String chipName;
    private double chipPrice;
    private int chipQuantity;

    public Chips(String name, double price, int quantity) {
        chipName = name;
        chipPrice = price;
        chipQuantity = quantity;
    }

    public Chips() {
        chipName = "N/A";
        chipPrice = 0;
        chipQuantity = 0;
    }
    public Chips(Chips CO) {
    	chipName = CO.chipName;
    	chipPrice = CO.chipPrice;
    	chipQuantity = CO.chipQuantity;
    }

    @Override
    public String toString() {
        StringBuilder t = new StringBuilder();
        t.append("Chips: ").append(chipName)
                .append("\n")
                .append("Price: ").append(chipPrice)
                .append("\n")
                .append("Quantity: ").append(chipQuantity);
        return t.toString();
    }
//----------------------------------------------------------------------------\\    
    public void setName(String Name){chipName = Name;}

    public String getName(){return this.chipName;}

    public void setPrice(double Price){chipPrice = Price;}

    public double getPrice(){return this.chipPrice;}

    public void setQuantity(int Quantity){chipQuantity = Quantity;}

    public int getQuantity(){return chipQuantity;}
    
}
