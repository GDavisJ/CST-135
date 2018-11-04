
public class Inventory_Management {
	private int _stock;
	private int _cart;
	
	public Inventory_Management(int stock, int cart) {
		_stock = stock;
		_cart = cart;
	}

	public int getNewStock() {
		return _stock - _cart;
	}
	
}
