package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		//Create a scanner to read whitespace separated input from the user
		Scanner userInput = new Scanner(System.in);
		
		//Start by reading the total number of customers that will exist for the program
		int NUMBER_OF_CUSTOMERS = userInput.nextInt();
		//Now, create an array to model all of the customer names
		String[] CUSTOMER_NAMES = new String[NUMBER_OF_CUSTOMERS];
		//Also, create an array to model all of the customer totals
		double[] CUSTOMER_TOTALS = new double[NUMBER_OF_CUSTOMERS];
		
		//Now start reading the data and parsing through it
		//For each of the customers...
		for(int i = 0; i < NUMBER_OF_CUSTOMERS; i++) {
			//Add their name to the array, but format it for the desired output type F. LAST
			CUSTOMER_NAMES[i] = userInput.next().substring(0, 1) + ". " + userInput.next();
			
			//Loop through all the customer transactions and add the final total to the CUSTOMER_TOTALS array
			int numItemsForCurrentUser = userInput.nextInt();
			for(int j = 0; j < numItemsForCurrentUser; j++) {
				//Get the quantity of the current item that was purchased
				int ItemQuantity = userInput.nextInt();
				//Ignore the name
				userInput.next();
				//Get the price of the current item that was purchased
				double ItemPrice = userInput.nextDouble();
				//Now compute the total price and add it to the customer's total
				CUSTOMER_TOTALS[i] += ItemQuantity*ItemPrice;
			}
		}
		
		//Now handle the output by looping over each customer
		for(int i = 0; i < NUMBER_OF_CUSTOMERS; i++) {
			//Print the customer name and his/her total
			System.out.println(CUSTOMER_NAMES[i] + ": " + String.format("%.2f", CUSTOMER_TOTALS[i]));
		}
	}
}

//Is there an error with my newline when reading input