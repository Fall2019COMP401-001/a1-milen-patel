package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		//Create a scanner to read the user input
		Scanner userInput = new Scanner(System.in);
		//Start by getting the number of items that will be in the inventory arrays
		int NUM_OF_INVENTORY_ITEMS = userInput.nextInt();
		//Create two arrays to model the inventory of goods in the store
		String[] INVENTORY_ITEMS = new String[NUM_OF_INVENTORY_ITEMS];
		double[] INVENTORY_PRICES = new double[NUM_OF_INVENTORY_ITEMS];
		
		//Now, add all NUM_OF_INVENTORY_ITEMS to the two inventory arrays
		for(int i = 0; i < NUM_OF_INVENTORY_ITEMS; i++) {
			//Add the item name
			INVENTORY_ITEMS[i] = userInput.next();
			//Add the item cost
			INVENTORY_PRICES[i] = userInput.nextDouble();
		}
		
		//Now, create a variable to get the number of customers that will be accounted for
		int NUMBER_OF_CUSTOMERS = userInput.nextInt();
		
		//Now, create an array to model all of the customer names
		String[] CUSTOMER_NAMES = new String[NUMBER_OF_CUSTOMERS];
		//Also, create an array to model all of the customer totals
		double[] CUSTOMER_TOTALS = new double[NUMBER_OF_CUSTOMERS];
		
		//For each customer, add the appropriate data to CUSTOMER_NAMES and CUSTOMER_TOTALS
		for (int i = 0; i < NUMBER_OF_CUSTOMERS; i++) {
			//Add the customer name to the CUSTOMER_NAMES array
			CUSTOMER_NAMES[i] = userInput.next() + " " + userInput.next();
			//Now, get the number of item entries that the current customer has purchased
			int NUMBER_OF_ITEMS_PURCHASED = userInput.nextInt();
			//Now loop over each item purchased and add its price to the table
			for (int j = 0; j < NUMBER_OF_ITEMS_PURCHASED; j++) {
				CUSTOMER_TOTALS[i] += userInput.nextInt()*FindItemPrice(userInput.next(),INVENTORY_ITEMS,INVENTORY_PRICES);
			}
		}
		//Call the three functions implemented below to display the targeted A1Adept output
		FindBiggestSpender(CUSTOMER_NAMES, CUSTOMER_TOTALS);
		FindLowestSpender(CUSTOMER_NAMES, CUSTOMER_TOTALS);
		ComputeAverageSpending(CUSTOMER_TOTALS);
	}
	
	/* FindBiggestSpender
	 * Prints the name and transaction total of the customer who spent the most amount of money
	 * 
	 * Input: An array of strings containing all the numbers of the customers (name)
	 * 		  An array of doubles containing all the transaction totals for each customer (totals)
	 * 
	 * Output: A summary line containing the name and transaction total of the customer who spent the most amount of money
	 * 
	 * Precondition: Both arrays are populated and for valid i names[i] corresponds to totals[i]
	 * 
	 */
	public static void FindBiggestSpender(String[] names, double[] totals) {
		//Loop over all the entries in the totals array
		int highestIndex = 0;
		for (int i = 0; i < totals.length; i++) {
			if (totals[i] > totals[highestIndex]) {
				highestIndex = i;
			}
		}
		//Print a summary line to the screen
		System.out.println("Biggest: " + names[highestIndex] + " (" + String.format("%.2f", totals[highestIndex]) + ")");
	}
	
	/* FindLowestSpender
	 * Prints the name and transaction total of the customer who spent the least amount of money
	 * 
	 * Input: An array of strings containing all the numbers of the customers (name)
	 * 		  An array of doubles containing all the transaction totals for each customer (totals)
	 * 
	 * Output: A summary line containing the name and transaction total of the customer who spent the least amount of money
	 * 
	 * Precondition: Both arrays are populated and for valid i names[i] corresponds to totals[i]
	 * 
	 */
	public static void FindLowestSpender(String[] names, double[] totals) {
		//Loop over all the entries in the totals array
		int lowestIndex = 0; //Have a variable to keep track of the index of the customer who spent the least amount
		for (int i = 0; i < totals.length; i++) {
			if (totals[i] < totals[lowestIndex]) {
				lowestIndex = i; //If this customer spent less than the current lowest, then the current lowest becomes this customer
			}
		}
		//Print a summary line to the screen
		System.out.println("Smallest: " + names[lowestIndex] + " (" + String.format("%.2f", totals[lowestIndex]) + ")");
	}
	
	/* ComputeAverageSpending
	 * Finds the average spent by all customers
	 * 
	 * Input: An array of all the customer totals (spendingValues)
	 * 
	 * Output: A line printed to the console with the average transaction total for all customers
	 * 
	 * Precondition: spendingValues is populated correctly
	 * 
	 */
	public static void ComputeAverageSpending(double[] spendingValues) {
		double total = 0; //Keep a running total
		for (int i = 0; i < spendingValues.length; i++) {
			total += spendingValues[i]; //Increment the running total by the transaction amount of the current customer
		}
		//Print the final message while dividing the running total by the number of customers
		System.out.println("Average: " + String.format("%.2f",total/spendingValues.length));
	}
	
	/* FindItemPrice
	 * Finds the price of an item given its associated name
	 * 
	 * Input: A string representing the name of an item (itemName)
	 * 		  An array of strings representing the names of all items in the inventory (names)
	 * 		  An array of doubles representing the cost of all items in the inentory (prices)
	 * 
	 * Output: A double representing the cost of the item with name 'itemName'
	 * 
	 * Precondition:
	 * itemName, names, and prices are all populated
	 * itemName is a valid item that is in the inventory of 'names' and has an associated 'prices' value
	 */
	public static double FindItemPrice(String itemName, String[] names, double[] prices) {
		//Loop over all the items in names and find a matching item name
		int nameIndex = 0;
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(itemName)) {
				//if the name matches the target name, then get the index value and leave
				nameIndex = i;
				break;
			}
		}
		//Now return the price of the targeted index value
		return prices[nameIndex];
	}
}
