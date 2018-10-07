public abstract class Snack extends Product implements Comparable<Snack> {

    public String snackKind;

    public Snack(String kind){
        snackKind = kind;
    }

    public Snack(){
        snackKind = "NA";
    }
    public Snack(Snack SO) {
    	snackKind = SO.snackKind;
    }

    public String toString1(){
        StringBuilder s = new StringBuilder();
        s.append("Snack Type: ").append(this.snackKind).append("\n");

        return s.toString();
    }
    
    public void setSnackType(String snackType){this.snackKind = snackType;}
    public String getSnackType(){return this.snackKind;}
    
    public abstract String getName();
    public abstract double getPrice();
    @Override // Implement the compareTo method defined in Comparable 
    public int compareTo(Snack obj) {
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
}
