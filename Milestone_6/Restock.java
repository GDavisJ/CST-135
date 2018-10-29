
public class Restock {
	private int maxDrink = 10;
	private int maxCandy = 15;
	private int maxChips = 10;
	private int maxGum = 20;
	private int _orderItem=0;
	private String _prodType;
	private Product _tempProd;
	private int minStock = 3;

	Restock(Product prod){
		_tempProd = prod;
		_prodType = prodType();
		
	}
	public int getItemDiff() {
		if (_prodType == "Candy") {
			_orderItem = maxCandy - _tempProd.getQuantity();
			return _orderItem;
		}
		else if (_prodType == "Chips") {
			_orderItem = maxChips - _tempProd.getQuantity();
			return _orderItem;
		}
		else if (_prodType == "Gum") {
			_orderItem = maxGum - _tempProd.getQuantity();
			return _orderItem;
		}
		else if (_prodType == "Drink") {
			_orderItem = maxDrink - _tempProd.getQuantity();
			return _orderItem;
		}
		return 0; 
	}
	public boolean itemLow() {
		if (_tempProd.getQuantity() <= minStock) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Used to get the class type
	private String prodType() {
		if (_tempProd instanceof Chips)  {
			return "Chips";
		}
		else if (_tempProd instanceof Candy)  {
			return "Candy";
		}
		else if (_tempProd instanceof Gum)  {
			return "Gum";
		}
		else if (_tempProd instanceof Drink)  {
			return "Drink";
		}
		else {
			return "";
		}
	}
	
}
