import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Global_Inventory_Management {
	public Product[] prodManObjects = new Product[0];
	public List<String> productNameList = new ArrayList<String>();
	public List<String>  productPriceList = new ArrayList<String>();
	public List<String>  productQuantList = new ArrayList<String>();
	public List<String>  productTypeList = new ArrayList<String>();
	public List<String>  productLocationList = new ArrayList<String>();
	public List<String>  machineNumber = new ArrayList<String>();
	
	public Global_Inventory_Management() {
		createProducts();
		prodManObjects = new Product[productLocationList.size()];
		for (int x = 0; x<productLocationList.size();x++) {
			int index = x;
			if ("chips".equals(productTypeList.get(index))) {
				Snack obj = new Chips(productNameList.get(index), Double.parseDouble(productPriceList.get(index)), Integer.parseInt(productQuantList.get(index)), productLocationList.get(index));
				obj.setMachine(machineNumber.get(x));
				prodManObjects[x] = obj;
			}
			else if ("drink".equals(productTypeList.get(index))) {
				Drink obj = new Drink(productNameList.get(index), Double.parseDouble(productPriceList.get(index)), Integer.parseInt(productQuantList.get(index)), productLocationList.get(index));
				obj.setMachine(machineNumber.get(x));
				prodManObjects[x] = obj;
			}
			else if ("gum".equals(productTypeList.get(index))) {
				Snack obj = new Gum(productNameList.get(index), Double.parseDouble(productPriceList.get(index)), Integer.parseInt(productQuantList.get(index)), productLocationList.get(index));
				obj.setMachine(machineNumber.get(x));
				prodManObjects[x] = obj;
			}
			else if ("candy".equals(productTypeList.get(index))) {
				Snack obj = new Candy(productNameList.get(index), Double.parseDouble(productPriceList.get(index)), Integer.parseInt(productQuantList.get(index)), productLocationList.get(index));
				obj.setMachine(machineNumber.get(x));
				prodManObjects[x] = obj;
			}
		}
	}
	
	
	private void createProducts(){
		//Get list of items for the constructor to fill
		int mCnt=1;
		File folder = new File(System.getProperty("user.dir")); //find the files in the current working dir
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	if (file.getName().split("VendingMachine").length == 2) { //Used to verify the csv
		    		String machNameStr = "VendingMachine_"+mCnt;
		    		//System.out.println(file.getName()); //Prints the vending machine file name
		    		String fileName = file.getName(); //The csv file name
		    		File txtFile = new File(fileName);
		    		try {
		    			Scanner scanner1 = new Scanner(txtFile); 
		    			while (scanner1.hasNextLine()) {
		    				String[] fileLine = scanner1.nextLine().split(","); //Split using delimiter "="
		    				if (fileLine.length>0 && fileLine[0].toString() != "" && fileLine[0].matches("ProductName")) { 
		    					for (int x=1;x<fileLine.length;x++) {
		    						productNameList.add(fileLine[x]);
		    						machineNumber.add(machNameStr);
		    					}	
		    				}
		    				if (fileLine.length>0 && fileLine[0].toString() != "" && fileLine[0].matches("ProductPrice")) {
		    					for (int x=1;x<fileLine.length;x++) {
		    						productPriceList.add(fileLine[x]);
		    					}
		    				}
		    				if (fileLine.length>0 && fileLine[0].toString() != "" && fileLine[0].matches("ProductQuant")) {
		    					for (int x=1;x<fileLine.length;x++) {
		    						//System.out.println(fileLine[x]);
		    						productQuantList.add(fileLine[x]);
		    					}
		    				}
		    				if (fileLine.length>0 && fileLine[0].toString() != "" && fileLine[0].matches("ProductType")) {
		    					for (int x=1;x<fileLine.length;x++) {
		    						//System.out.println(fileLine[x]);
		    						productTypeList.add(fileLine[x]);
		    					}
		    				}
		    				if (fileLine.length>0 && fileLine[0].toString() != "" && fileLine[0].matches("ProductLocation")) {
		    					for (int x=1;x<fileLine.length;x++) {
		    						//System.out.println(fileLine[x]);
		    						productLocationList.add(fileLine[x]);
		    					}
		    				}
		    			}
		    			scanner1.close(); //close scanner to silence Eclipse error message
		    			mCnt = mCnt + 1;
		    		}
		    		catch (IOException e) {
		    			System.out.println(e); //print the error
		    		}
		    	}
		    }
		}
	}
	
	//Quick Sort Methods
	public static void quickSort(Product[] list) {
       quickSort(list, 0, list.length - 1);
        }

  public static void quickSort(Product[] list, int first, int last) {
        if (last > first) {
              int pivotIndex = partition(list, first, last);
        quickSort(list, first, pivotIndex - 1);
        quickSort(list, pivotIndex + 1, last);
        }
  }


  /** Partition the array list[first..last] */
  public static int partition(Product[] list, int first, int last) {
        Product pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1;// Index for forward search
        int high = last; // Index for backward search
        while (high > low) {
              // Search forward from left
              while (low <= high && list[low].getName().compareToIgnoreCase(pivot.getName()) <= 0)
                    low++;
              // Search backward from right
              while (low <= high && list[high].getName().compareToIgnoreCase(pivot.getName()) > 0)
                    high--;
              // Swap two elements in the list
              if (high > low) {
                    Product temp = list[high];
                    list[high] = list[low];
                    list[low] = temp;
                    }
              }
        while (high > first && list[high].getName().compareToIgnoreCase(pivot.getName()) >= 0)
              high--;
        // Swap pivot with list[high]
        if (0 > list[high].getName().compareToIgnoreCase(pivot.getName())) {
              list[first] = list[high];
              list[high] = pivot;
              return high;
              }
        else {
              return first;
              }
        }	
	
	
  	//Search Method
	public static Product prodSearch(Product[] list, String userWord) {
		return prodSearch(list, 0, list.length - 1, userWord);
	}
	
	private static Product prodSearch(Product[] pList, int low, int high, String wordSearch) {
		if (wordSearch.equals(pList[low].getName()) ||  wordSearch.equals(pList[high].getName()))// Base case 
			if (wordSearch.equals(pList[low].getName())){
				//System.out.println("Recursive Call low returned, low="+low);
				return pList[low];
			}
			else {
				//System.out.println("Recursive Call high returned, high="+high);
				return pList[high];
				
			}
		else if (high <= low) {
			//System.out.println("Recursive Call high <= low and null returned (not in list)");
			return null;
		}
		else
			//System.out.println("Recursive Call prodSearch, high="+high+" ,low="+low);
			return prodSearch(pList, low + 1, high - 1, wordSearch);
	}
  
  
	//Used for Testing
	public static void main(String[] args) {
		Global_Inventory_Management test = new Global_Inventory_Management();
        quickSort(test.prodManObjects);
        for (int x=0;x<test.prodManObjects.length;x++) {
            System.out.println(test.prodManObjects[x].getName());
        }
        System.out.println(test.prodManObjects[20].getMachine());
        if (prodSearch(test.prodManObjects,"Oreos") != null) {
        	System.out.println("found " + prodSearch(test.prodManObjects,"Oreos"));
        }

        

	}

}
