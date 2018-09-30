import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Dispenser {
	public String[] prodLocations = {"A1","A2","A3","A4","B1","B2","B3","B4",
			"C1","C2","C3","C4","D1","D2","D3","D4"};
	public Object[] prodObjects = new Object[prodLocations.length];
	protected String[] productNameList = {};
	protected String[] productPriceList = {};
	protected String[] productQuantList = {};
	protected String[] productTypeList = {};
	
	public Dispenser() {		
		createProducts();		
		for (int x = 0; x<prodLocations.length;x++) {
			Random randNum = new Random();
			int index = randNum.nextInt(productNameList.length);
			if ("chip".equals(productTypeList[index])) {
				Snack obj = new Chips(productNameList[index], Double.parseDouble(productPriceList[index]), Integer.parseInt(productQuantList[index]));
				prodObjects[x] = obj;
			}
			else if ("drink".equals(productTypeList[index])) {
				Product obj = new Drink(productNameList[index], Double.parseDouble(productPriceList[index]), Integer.parseInt(productQuantList[index]));
				prodObjects[x] = obj;
			}
			else if ("gum".equals(productTypeList[index])) {
				Snack obj = new Gum(productNameList[index], Double.parseDouble(productPriceList[index]), Integer.parseInt(productQuantList[index]));
				prodObjects[x] = obj;
			}
			else if ("candy".equals(productTypeList[index])) {
				Snack obj = new Candy(productNameList[index], Double.parseDouble(productPriceList[index]), Integer.parseInt(productQuantList[index]));
				prodObjects[x] = obj;
			}
		}
	}
	
	private void createProducts(){
		//Get list of items for the constructor to fill
		File txtFile = new File("Products.txt");
		try {
			Scanner scanner1 = new Scanner(txtFile); 
			while (scanner1.hasNextLine()) {
				String[] fileLine = scanner1.nextLine().split("="); //Split using delimiter "="
				if (fileLine.length>0 && fileLine[0].toString() != "" && fileLine[0].matches("ProductName")) { 
					productNameList = fileLine[1].split(",");
				}
				if (fileLine.length>0 && fileLine[0].toString() != "" && fileLine[0].matches("ProductPrice")) {
					productPriceList = fileLine[1].split(",");
				}
				if (fileLine.length>0 && fileLine[0].toString() != "" && fileLine[0].matches("ProductQuant")) {
					productQuantList = fileLine[1].split(",");
				}
				if (fileLine.length>0 && fileLine[0].toString() != "" && fileLine[0].matches("ProductType")) {
					productTypeList = fileLine[1].split(",");
				}
			}
			scanner1.close(); //close scanner to silence Eclipse error message
		}
		catch (IOException e) {
			System.out.println(e); //print the error
		}
		
	}
	
	public void displayProducts() {
		
		List<String> pName = new ArrayList<String>();
		List<String> pPrice = new ArrayList<String>();
		List<String> pQuant = new ArrayList<String>();
		List<String> pType = new ArrayList<String>();
		List<String> pLocation = new ArrayList<String>();
		pName.add("Product Name");
		pPrice.add("Price");
		pQuant.add("Quantity");
		pType.add("Type");
		pLocation.add("Location");

		for (int x = 0; x<prodObjects.length;x++) {
			if (prodObjects[x] instanceof Chips) {
				pName.add(((Chips)prodObjects[x]).getName());
				pPrice.add(String.valueOf(((Chips)prodObjects[x]).getPrice()));
				pQuant.add(String.valueOf(((Chips)prodObjects[x]).getQuantity()));
				pType.add("Chips");
			}
			else if (prodObjects[x] instanceof Drink) {
				pName.add(((Drink)prodObjects[x]).getName());
				pPrice.add(String.valueOf(((Drink)prodObjects[x]).getPrice()));
				pQuant.add(String.valueOf(((Drink)prodObjects[x]).getQuantity()));
				pType.add("Drink");
			}
			else if (prodObjects[x] instanceof Gum) {
				pName.add(((Gum)prodObjects[x]).getName());
				pPrice.add(String.valueOf(((Gum)prodObjects[x]).getPrice()));
				pQuant.add(String.valueOf(((Gum)prodObjects[x]).getQuantity()));
				pType.add("Gum");
			}
			else if (prodObjects[x] instanceof Candy) {
				pName.add(((Candy)prodObjects[x]).getName());
				pPrice.add(String.valueOf(((Candy)prodObjects[x]).getPrice()));
				pQuant.add(String.valueOf(((Candy)prodObjects[x]).getQuantity()));
				pType.add("Candy");
			}
			pLocation.add(prodLocations[x]);
		}
		for (int index = 0; index < pName.size(); index++) { //Use for loop to get each item in the lists and print them
			System.out.format("%1$-20s %2$-10s %3$-10s %4$-10s %5$-10s\n", pName.get(index), pPrice.get(index), pQuant.get(index), pType.get(index), pLocation.get(index)); //Format the indexed items so they look tabular.
		}
	}
	
}
