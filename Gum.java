public class Gum extends Snack{
    private String gumName;
    private double gumPrice;
    private int gumQuantity;

    public Gum(String name, double price, int quantity) {
        gumName = name;
        gumPrice = price;
        gumQuantity = quantity;
    }

    public Gum() {
        gumName = "N/A";
        gumPrice = 0;
        gumQuantity = 0;
    }
    public Gum(Gum GO) {
    	gumName = GO.gumName;
    	gumPrice = GO.gumPrice;
    	gumQuantity = GO.gumQuantity;
    }

    @Override
    public String toString() {
        StringBuilder t = new StringBuilder();
        t.append("Gum: ").append(gumName)
                .append("\n")
                .append("Price: ").append(gumPrice)
                .append("\n")
                .append("Quantity: ").append(gumQuantity);
        return t.toString();
    }
//----------------------------------------------------------------------------\\    
    public void setName(String Name){gumName = Name;}

    public String getName(){return this.gumName;}

    public void setPrice(double Price){gumPrice = Price;}

    public double getPrice(){return this.gumPrice;}

    public void setQuantity(int Quantity){gumQuantity = Quantity;}

    public int getQuantity(){return gumQuantity;}
    
}