package a1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		//Create a scanner to read the user input
		Scanner userInput = new Scanner(System.in);
		//Create a map to model the inventory of good and their prices
		Map<String, Double> Inventory = new HashMap<String, Double>();
		//Start by getting the number of items that will be in the inventory map
		int NUM_OF_INVENTORY_ITEMS = userInput.nextInt();
		//Now, add all NUM_OF_INVENTORY_ITEMS to the Inventory map
		for(int i = 0; i < NUM_OF_INVENTORY_ITEMS; i++) {
			//Add the item and its associated cost to the map
			Inventory.put(userInput.next(), userInput.nextDouble());
		}
		
		//Now, create a variable to get the number of customers that will be accounted
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
				CUSTOMER_TOTALS[i] += userInput.nextInt()*Inventory.get(userInput.next());
			}
		}
		
		FindBiggestSpender(CUSTOMER_NAMES, CUSTOMER_TOTALS);
		FindLowestSpender(CUSTOMER_NAMES, CUSTOMER_TOTALS);
		ComputeAverageSpending(CUSTOMER_TOTALS);
	}
	
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
	
	public static void FindLowestSpender(String[] names, double[] totals) {
		//Loop over all the entries in the totals array
		int lowestIndex = 0;
		for (int i = 0; i < totals.length; i++) {
			if (totals[i] < totals[lowestIndex]) {
				lowestIndex = i;
			}
		}
		//Print a summary line to the screen
		System.out.println("Smallest: " + names[lowestIndex] + " (" + String.format("%.2f", totals[lowestIndex]) + ")");
	}
	public static void ComputeAverageSpending(double[] spendingValues) {
		double total = 0;
		for (int i = 0; i < spendingValues.length; i++) {
			total += spendingValues[i];
		}
		System.out.println("Average: " + String.format("%.2f",total/spendingValues.length));
	}
}
