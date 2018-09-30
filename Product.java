public abstract class Product {
    public String proType;

    public Product(String type){
        proType = type;
    }

    public Product(){
        proType = "N/A";
    }
    public Product(Product PO) {
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
