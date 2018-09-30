public class Candy extends Snack{
    private String canName;
    private double canPrice;
    private int canQuantity;

    public Candy(String name, double price, int quantity) {
        canName = name;
        canPrice = price;
        canQuantity = quantity;
    }

    public Candy() {
        canName = "N/A";
        canPrice = 0;
        canQuantity = 0;
    }
    
    public Candy(Candy C) {
    	canName = C.canName;
    	canPrice = C.canPrice;
    	canQuantity = C.canQuantity;
    }


	@Override
    public String toString() {
        StringBuilder t = new StringBuilder();
        t.append("Candy: ").append(canName)
                .append("\n")
                .append("Price: ").append(canPrice)
                .append("\n")
                .append("Quantity: ").append(canQuantity);
        return t.toString();
    }
//----------------------------------------------------------------------------\\    
    public void setName(String Name){canName = Name;}

    public String getName(){return this.canName;}

    public void setPrice(double Price){canPrice = Price;}

    public double getPrice(){return this.canPrice;}

    public void setQuantity(int Quantity){canQuantity = Quantity;}

    public int getQuantity(){return canQuantity;}
    
}
