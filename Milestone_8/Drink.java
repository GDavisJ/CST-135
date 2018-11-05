public class Drink extends Product implements Comparable<Drink> {
    private String driName;
    private double driPrice;
    private int driQuantity;
    private String driLocation;

    public Drink(String name, double price, int quantity, String location) {
        driName = name;
        driPrice = price;
        driQuantity = quantity;
        driLocation = location;
    }

    public Drink() {
        driName = "N/A";
        driPrice = 0;
        driQuantity = 0;
        driLocation = "N/A";
    }
    public Drink(Drink DO) {
    	driName = DO.driName;
    	driPrice = DO.driPrice;
    	driQuantity = DO.driQuantity;
    	driLocation = DO.driLocation;
    }

    @Override
    public String toString() {
        StringBuilder t = new StringBuilder();
        t.append("Drink: ").append(driName)
                .append(";   ")
                .append("Price: ").append(driPrice)
                .append(";   ")
                .append("Quantity: ").append(driQuantity)
        		.append(";   ")
        		.append("Location: ").append(driLocation);
        return t.toString();
    }

    
    @Override // Implement the compareTo method defined in Comparable 
    public int compareTo(Drink obj) {
    	//LowerCase and convert to char array
    	String nameLow1 = getName().toLowerCase();
    	char[] nameChar1 = nameLow1.toCharArray();
    	String nameLow2 = obj.getName().toLowerCase();
    	char[] nameChar2 = nameLow2.toCharArray();
    			
    	//find the minimum array length
    	int scanRange;
    	if (nameChar1.length > nameChar2.length) {
    		scanRange = nameChar2.length;
    	}
    	else {
    		scanRange = nameChar1.length;
    	}
    			
    	//Find change in char
    	int holdVar = 0;
    	for (int i = 0; i < scanRange; i++) { 
    	          if (nameChar1[i]-nameChar2[i] != 0 && holdVar == 0) {
    	            	holdVar = (nameChar1[i]-nameChar2[i]);
    	          }
    	 }
    			
    	//Logic used to determine Alpha order
    	if (holdVar == 0 && nameChar1.length == nameChar2.length) {
    		if (getPrice() == obj.getPrice()) {
    			return 0;
    		}
    		else if (getPrice() < obj.getPrice()) {
    			return -1;
    		}
    		else if (getPrice() > obj.getPrice()) {
    			return 1;
    		}
    	}
    	else if (holdVar == 0 && nameChar1.length < nameChar2.length) {
    		return -1;
    	}
    	else if (holdVar == 0 && nameChar1.length > nameChar2.length) {
    		return 1;
    	}
    	else if (holdVar < 0) {
    		return -1;
    	}
    	else if (holdVar > 0) {
    		return 1;
    	}
    	return 0;
    }

//----------------------------------------------------------------------------\\    
    public void setName(String Name){driName = Name;}

    public String getName(){return this.driName;}

    public void setPrice(double Price){driPrice = Price;}

    public double getPrice(){return this.driPrice;}

    public void setQuantity(int Quantity){driQuantity = Quantity;}

    public int getQuantity(){return driQuantity;}
    
    public void setLocation(String Location){driLocation = Location;}

    public String getLocation(){return driLocation;}  
    
}
