import java.io.File;
import java.io.IOException;
import java.util.*;
public class ProcessCustomerQueue {
	public static ArrayList<Customer> custQueueList = new ArrayList<Customer>();
	public ProcessCustomerQueue() {
		createCustomer();
	}
	
	private static void createCustomer(){
		//Get list of items for the constructor to fill
		String fileName = "CustomerQueue.csv";
		File csvFile = new File(fileName);
		try {
			Scanner scanner1 = new Scanner(csvFile); 
			int lnCnt = 0;
			while (scanner1.hasNextLine()) {
				String[] fileLine = scanner1.nextLine().split(","); //Split using delimiter "="
				if (fileLine.length>0 && fileLine[0].toString() != "" && lnCnt > 0) { 
					//System.out.println(fileLine[0] + ", " + fileLine[1] + ", " +fileLine[2] + ", " +fileLine[3]);
					Customer custInQueue = new Customer(fileLine[0], fileLine[1], Integer.parseInt(fileLine[2]), Integer.parseInt(fileLine[3]));
					Add(custQueueList, custInQueue);
				}
				lnCnt = lnCnt + 1;
			}
			scanner1.close(); //close scanner to silence Eclipse error message
		}
		catch (IOException e) {
			System.out.println(e); //print the error
		}
		
	}
	
	//Get the first customer in Queue
	public Customer First(ArrayList<Customer> list) {
		if (list.size() > 0) {
			return list.get(0);
		}
		else {
			return null;
		}
	}
	
	//Get the length of customer Queue
	public static int Length(ArrayList<Customer> list) {
		return list.size();
	}	

	//Add to customer Queue
	public static ArrayList<Customer> Add(ArrayList<Customer> list, Customer customer) {
		list.add(customer);
		return list;
	}
	//Remove from customer Queue
	public static ArrayList<Customer> Out(ArrayList<Customer> list, Customer customer) {
		list.remove(customer);
		return list;
	}
	//Get isEmpty of customer Queue
	public static boolean isEmpty(ArrayList<Customer> list) {
		if (list.size() > 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	
	//used for class testing
	public static void main(String[] args) {
		createCustomer();
		System.out.println(custQueueList.get(23).toString());
	}

}
