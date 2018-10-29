public abstract class Product {
    public String proType;
    public String _machLocation;

    protected Product(String type, String machineLocation){
        proType = type;
        _machLocation = machineLocation;
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
    public abstract String getName();
    public abstract double getPrice();
    public abstract int getQuantity();
    public abstract String getLocation();
    public void setMachine(String machineLoc){_machLocation = machineLoc;}
    public String getMachine(){return this._machLocation;}
}
