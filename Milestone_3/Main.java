
public class Main {

	public static void main(String[] args) {
		
		//Print random drink products and locations, created by the Dispenser class. 
		System.out.println("Randomly generated drink vending machine:");
		Dispenser dispDrink = new Dispenser("Drink");
		dispDrink.displayProducts();
		
		//Run displayProducts again to verify the changes.
		System.out.println("\nAlphabetical ordering of drink vending machine");

		//Sort the drink objects and display again
		java.util.Arrays.sort(dispDrink.prodObjects);
		dispDrink.displayProducts();

		
		
		//Print random snack products and locations, created by the Dispenser class. 
		System.out.println("\nRandomly generated snack vending machine:");
		Dispenser dispSnack = new Dispenser("Snack");
		dispSnack.displayProducts();
		
		//Run displayProducts again to verify the changes.
		System.out.println("\nAlphabetical ordering of snack vending machine");
		java.util.Arrays.sort(dispSnack.prodObjects);
		dispSnack.displayProducts();

	}

}
