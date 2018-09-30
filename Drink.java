public class Drink extends Product{
    private String driName;
    private double driPrice;
    private int driQuantity;

    public Drink(String name, double price, int quantity) {
        driName = name;
        driPrice = price;
        driQuantity = quantity;
    }

    public Drink() {
        driName = "N/A";
        driPrice = 0;
        driQuantity = 0;
    }
    public Drink(Drink DO) {
    	driName = DO.driName;
    	driPrice = DO.driPrice;
    	driQuantity = DO.driQuantity;
    }

    @Override
    public String toString() {
        StringBuilder t = new StringBuilder();
        t.append("Drink: ").append(driName)
                .append("\n")
                .append("Price: ").append(driPrice)
                .append("\n")
                .append("Quantity: ").append(driQuantity);
        return t.toString();
    }
//----------------------------------------------------------------------------\\    
    public void setName(String Name){driName = Name;}

    public String getName(){return this.driName;}

    public void setPrice(double Price){driPrice = Price;}

    public double getPrice(){return this.driPrice;}

    public void setQuantity(int Quantity){driQuantity = Quantity;}

    public int getQuantity(){return driQuantity;}
    
}
