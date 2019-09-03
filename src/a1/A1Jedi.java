package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		//Create a scanner to read the user input
		Scanner userInput = new Scanner(System.in);

		//Start by getting the number of items that will be in the inventory arrays
		int NUM_OF_INVENTORY_ITEMS = userInput.nextInt();
		//Create two arrays to model the inventory of goods in the store
		//INVENTORY_ITEMS[i] will contain the name of the ith item in the store (starting from i=0)
		//INVENTORY_PRICES[i] will contain the price of the ith item in the store (starting from i=0)
		String[] INVENTORY_ITEMS = new String[NUM_OF_INVENTORY_ITEMS];
		double[] INVENTORY_PRICES = new double[NUM_OF_INVENTORY_ITEMS];
		//Create two additional arrays for storing purchase statistics
		//UNIQUE_CUSTOMERS[i] will contain the number of unique customers that have purchased INVENTORY_ITEMS[i]
		//QUANTITY_PURCHASED[i] will the contian the number of units that have been purchased of INVENTORY_ITEMS[i]
		int[] UNIQUE_CUSTOMERS = new int[NUM_OF_INVENTORY_ITEMS];
		int[] QUANTITY_PURCHASED = new int[NUM_OF_INVENTORY_ITEMS]; 

		//As a side note all four arrays will contain data about the same object given a consistent position
		//INVENTORY_ITEMS, INVENTORY_PRICES, UNIQUE_CUSTOMERS, QUANTITY_PURCHASED are all related


		//Now, add all NUM_OF_INVENTORY_ITEMS items to the INVENTORY_ITEMS array and add their prices to the INVENTORY_PRICES array
		for(int i = 0; i < NUM_OF_INVENTORY_ITEMS; i++) {
			//Add the next line (item name) to the INVENTORY_ITEMS array
			INVENTORY_ITEMS[i] = userInput.next();
			//Add the next douvle (item cost) to the INVENTORY_PRICES array
			INVENTORY_PRICES[i] = userInput.nextDouble();
		}

		//Now, create a variable to get the number of customers that will be accounted for
		int NUMBER_OF_CUSTOMERS = userInput.nextInt(); 

		//For each customer, add the appropriate data to UNIQUE_CUSTOMERS and QUANTITY_PURCHASED
		for (int i = 0; i < NUMBER_OF_CUSTOMERS; i++) {
			//Discard names since they are irrelevant for A1Jedi
			userInput.next();
			userInput.next();
			//Now, get the number of item entries that the current customer has purchased
			int NUMBER_OF_ITEMS_PURCHASED = userInput.nextInt();

			//Create an array of booleans to see if the customer has already purchased the current item before since we don't want to count two transactions by the same customer as 2 distinct customers
			boolean[] hasPurchasedThisItemAlready = new boolean[NUM_OF_INVENTORY_ITEMS];
			//Before we look at the current customer, reset all the values in hasPurchasedThisItemAlready
			clearBooleanArray(hasPurchasedThisItemAlready);
			//Now loop over each item purchased and add its price to the table
			for (int j = 0; j < NUMBER_OF_ITEMS_PURCHASED; j++) {
				//Measure how many units the customer purchased of the current good
				int quantityPurchased = userInput.nextInt();
				//Get the index of the item so we can refer to the appropriate arrays
				int itemIndex = getItemIndex(userInput.next(),INVENTORY_ITEMS);
				//Check to see if the customer has already bought this item
				if (!hasPurchasedThisItemAlready[itemIndex]) {
					//If they have purchased the item, then update the value in hasPurchasedThisItemAlready
					hasPurchasedThisItemAlready[itemIndex] = true;
					//Increase the number of unique customers for this item
					UNIQUE_CUSTOMERS[itemIndex]++;
					//Increase the quantity of the item purchased by the appropriate amount
					QUANTITY_PURCHASED[itemIndex] += quantityPurchased;
				} else {
					//If they have already purchased the item before, then only update its quantity purchased
					QUANTITY_PURCHASED[itemIndex] += quantityPurchased;
				}	
			}
		}
		
		//Close scanner
		userInput.close();
		
		//Print the spending summary statistics now that all the data has been read and processed from the user
		printSpendingStats(INVENTORY_ITEMS, UNIQUE_CUSTOMERS, QUANTITY_PURCHASED);
	}

	/* clearBooleanArray
	 * Takes an array of booleans and resets them all to be false
	 * 
	 * Input: An array of booleans (x)
	 * 
	 * Output: An array of booleans of equal length, all containing false values
	 * 
	 * Precondition:
	 * Input array must not be null
	 */
	public static void clearBooleanArray(boolean[] x) {
		for(int i = 0; i < x.length; i++) {
			x[i]=false;
		}
	}
	/* getItemIndex
	 * Returns the index of an item in an array, given the item's name
	 * 
	 *  Input: An array of Strings (name); A String that has the name of the target item in the array (items)
	 *  
	 *  Output: An integer representing the items of 'name' in 'items'
	 *  
	 *  Precondition:
	 *  Input array must not be null
	 *  The key value must appear one time in the array that is being searched
	 */
	public static int getItemIndex(String name, String[] items) {
		int currentIndex = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(name)) {
				currentIndex = i;
				break;
			}
		}
		return currentIndex;
	}
	/* printSpendingStats
	 * Prints the summary statistics about the items purchased in the A1 Jedi Format
	 * 
	 * Input: An array containing all of the item names (items)
	 * 		  An array containing the number of unique consumers for each item (uniqueCustomers)
	 * 		  An array containing the quantity of each item that was purchased (quantitiesPurchased)
	 * 
	 * Output: Summary statistics are printed to the console in A1 Jedi Format
	 * 
	 * Precondition:
	 * All arrays must not be null
	 * The index values in each of the arrays must be consistent in the following manner:
	 * 		items[i] represents the name of an item
	 * 		uniqueCustomers[i] represents the number of unique purchases of the item
	 * 		quantitiesPurchased[i] represents the total number of units of the item that were sold
	 */
	public static void printSpendingStats(String[] items, int[] uniqueCustomers, int[] quantitiesPurchased) {
		for (int i = 0; i < items.length; i++) {
			if (uniqueCustomers[i] > 0) {
				System.out.println(uniqueCustomers[i] + " customers bought " + quantitiesPurchased[i] + " " + items[i]);
			} else {
				System.out.println("No customers bought " + items[i]);
			}
		}
	}


}
