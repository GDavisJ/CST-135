public abstract class Product {
    public String proType;

    protected Product(String type){
        proType = type;
    }

    protected Product(){
        proType = "N/A";
    }
    protected Product(Product PO) {
    	proType = PO.proType;
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Product is: ").append(this.proType).append("\n");

        return s.toString();
    }
    public void setSnackType(String snackType){this.proType = snackType;}
    public String getSnackType(){return this.proType;}
}
