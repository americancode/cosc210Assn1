import java.util.*;

/**
 * COSC 210-001  Assignment 1
 * Prog1.java
 * 
 * This program asks a user for the name of the salesperson and then records
 * the values until a negative number is entered.  After the data is entered
 * the program prints the sales with the corresponding commission for each sale.
 * This program also finds and prints the total sales as well as the high and low sales
 * 
 * @author Nathaniel Churchill
 *
 */

public class Prog1 {
	public static double COMMISSION_RATE = 0.12;

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		
		//ask the user for their name and save it to a string
		System.out.print("Please enter the name of the sales person:  ");
		String name = in.nextLine();
		int numberOfSales = 0;
		//creating a double array to hold each sale value
		double[] sales = new double[10];
		
		
		System.out.print("Please enter a sale value or a negative number to quit:  ");
		double saleValue = in.nextDouble();
		
		//loop to fill the array
		while(saleValue >= 0){
			sales[numberOfSales] = saleValue;
			System.out.print("Please enter a sale value or a negative number to "
					+ "quit:  ");
			saleValue = in.nextDouble();
		
			numberOfSales++;
		}
		
		double totalSales =0;
		for (int counter = 0; counter < sales.length; counter++){
			totalSales += sales[counter];
		}
		
		//output
		System.out.println("\n");
		System.out.printf("Weekly sales for %-40s\n\n", name);
		System.out.println("    Sales   Commission");
		
		for (int counter = 0; counter < numberOfSales; counter++){
			System.out.printf("%10.2f%10.2f\n", sales[counter], comm(sales[counter]));
		}
		System.out.printf("Total Sales:%10.2f\n", totalSales);
		System.out.printf("High Sales%20.2f\n", max(sales, numberOfSales));
		System.out.printf("Low Sales %20.2f", min(sales, numberOfSales));
		
	

	}
	/**
	 * This method calculates the commission for all sales
	 * @param sales filled with doubles of sales
	 * @return return the amount of commission
	 */
	public static double comm( double sales ) {
		double commission = sales * COMMISSION_RATE;
		
		return commission;
	}
	
	
	/**
	 * This method determines the smallest number in an array
	 * @param arr  an array of doubles
	 * @param num  the current size of the array
	 * @return minimum  the minimum number found in the array
	 */
	public static double min( double[] arr, int num){
		
		double minimum = arr[0];
		for(int counter = 1; counter < num; counter++){
			if (arr[counter] < minimum){
				minimum = arr[counter];
			}
		}
		return minimum;
	}
	
	
	/**
	 * 
	 * @param arr an array of doubles
	 * @param num the current size of the array
	 * @return maximum  the max number found in the array
	 */
	public static double max(double[] arr, int num){
		double maximum = arr[0];
		for(int counter = 1; counter < num; counter++){
			if (arr[counter] > maximum){
				maximum = arr[counter];
			}
		}
		return maximum;
	}

}
