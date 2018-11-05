
public class Customer {

	private String custName;
	private String prodName;
    private int prodQuantity;
    private int prodLocation;

    public Customer(String cName, String name, int quantity, int location) {
    	custName = cName;
        prodName = name;
        prodQuantity = quantity;
        prodLocation = location;
    }

    @Override
    public String toString() {
        StringBuilder t = new StringBuilder();
        t.append("Customer: ").append(custName)
                .append(";   ")
                .append("Product: ").append(prodName)
                .append(";   ")
                .append("Quantity: ").append(prodQuantity)
        		.append(";   ")
        		.append("Location: ").append(prodLocation);
        return t.toString();
    }

    public void setCustName(String cName){custName = cName;}

    public String getCustName(){return this.custName;}
    
    public void setName(String Name){prodName = Name;}

    public String getName(){return this.prodName;}

    public void setQuantity(int Quantity){prodQuantity = Quantity;}

    public int getQuantity(){return prodQuantity;}
    
    public void setLocation(int Location){prodLocation = Location;}

    public int getLocation(){return prodLocation;}

}
