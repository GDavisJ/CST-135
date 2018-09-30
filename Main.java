
public class Main {

	public static void main(String[] args) {
		Dispenser dis1 = new Dispenser();
		
		//Print random products and locations, created by the Dispenser class.  
		dis1.displayProducts();
		
		
		//This is used for testing. Verify the setters are working properly.
		for (int x = 0; x < dis1.prodObjects.length; x++) {
			if (dis1.prodObjects[x] instanceof Chips) {
				((Chips)dis1.prodObjects[x]).setName("Chip Name");
				((Chips)dis1.prodObjects[x]).setPrice(100.0);
				((Chips)dis1.prodObjects[x]).setQuantity(0);
			}
			if (dis1.prodObjects[x] instanceof Candy) {
				((Candy)dis1.prodObjects[x]).setName("Candy Name");
				((Candy)dis1.prodObjects[x]).setPrice(0.0);
				((Candy)dis1.prodObjects[x]).setQuantity(50);
			}
			if (dis1.prodObjects[x] instanceof Gum) {
				((Gum)dis1.prodObjects[x]).setName("Gum Name");
				((Gum)dis1.prodObjects[x]).setPrice(10.0);
				((Gum)dis1.prodObjects[x]).setQuantity(64);
			}
			if (dis1.prodObjects[x] instanceof Drink) {
				((Drink)dis1.prodObjects[x]).setName("Drink Name");
				((Drink)dis1.prodObjects[x]).setPrice(1000.0);
				((Drink)dis1.prodObjects[x]).setQuantity(222);
			}
		}
		

		//Run displayProducts again to verify the changes.
		System.out.println("\nVerify setter changes");
		dis1.displayProducts();
		
		
		


		
	}

}
