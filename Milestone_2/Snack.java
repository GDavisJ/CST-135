public abstract class Snack extends Product {

    public String snackKind;

    public Snack(String kind){
        snackKind = kind;
    }

    public Snack(){
        snackKind = "unk";
    }
    public Snack(Snack SO) {
    	snackKind = SO.snackKind;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Snack Type: ").append(this.snackKind).append("\n");

        return s.toString();
    }
    public void setSnackType(String snackType){this.snackKind = snackType;}
    public String getSnackType(){return this.snackKind;}
}
