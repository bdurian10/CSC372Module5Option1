package csc372Module5Option1;

import java.util.ArrayList;
import java.util.Scanner;

public class Product {
	
	private static double product = 1;
	static ArrayList<Double> unusedNums = new ArrayList<Double>();
	static ArrayList<Double> usedNums = new ArrayList<Double>();
	
	public static double multiply(ArrayList<Double> unusedNumbers, ArrayList<Double> usedNumbers) {
		//base case if 1 element left in unused nums
		if(unusedNumbers.size() == 1) {
			/*
			 * Debugging statement
			 *System.out.println("base case starting " + product);
			 */
			product = product * unusedNumbers.get(0);
			usedNumbers.add(unusedNumbers.get(0));
			unusedNumbers.remove(0);
			
			/*
			 * Debugging Statement
			 * System.out.println("base case executed " + product);
			 */
		}
		
		else {
			product = product * unusedNumbers.get(0) * unusedNumbers.get(1);
			
			//add used numbers to usedNums and remove from unusedNums
			usedNumbers.add(unusedNumbers.get(0));
			unusedNumbers.remove(0);
			usedNumbers.add(unusedNumbers.get(0));
			unusedNumbers.remove(0);
			/*
			 *Debugging statement 
			 *System.out.println("Recursive case executed " + product);
			 */
			//Recursive call for next iteration
			multiply(unusedNumbers, usedNumbers);
		}
	
		return product;
	}
	
	public static void main(String[] args) {
		//Create scanner object for user input
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter 5 Numbers");
		//Loop through asking user for input until 5 numbers collected
		while(unusedNums.size() < 5) {
			try {
				unusedNums.add(scnr.nextDouble());
				System.out.println("Program has " + unusedNums.size() + " out of 5 numbers.");
			}
			//Inform user of bad inputs
			catch(Exception e) {
				System.out.println("Invalid Input: " + scnr.next());
			}
		}
		//Close scanner when user input is complete
		scnr.close(); 
		
		//Call method to multiply inputed numbers
		double finalProduct = multiply(unusedNums, usedNums);
		
		//Print the result for the user
		System.out.print("The product of ");
		for(double num : usedNums) {
			System.out.print(num + " ");
		}
		System.out.print("is: " + finalProduct);
		
	}
	
	

}
