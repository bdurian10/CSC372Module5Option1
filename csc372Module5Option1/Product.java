package csc372Module5Option1;

import java.util.ArrayList;
import java.util.Scanner;

public class Product {
	
	private static double product = 1;
	
	public static double multiply(ArrayList<Double> numbers) {
		//base case if 1 element left in unused nums
		if(numbers.isEmpty()) {
			return product;
		}
		
		else {
			double num = numbers.remove(0);
			product *= num;
			return multiply(numbers);
		}
	}
	
	public static void main(String[] args) {
		//Create scanner object for user input
		Scanner scnr = new Scanner(System.in);
		ArrayList<Double> numbers = new ArrayList<>();
		
		System.out.println("Enter 5 Numbers");
		//Loop through asking user for input until 5 numbers collected
		while(numbers.size() < 5) {
			try {
				numbers.add(scnr.nextDouble());
			}
			//Inform user of bad inputs and clear input buffer
			catch(Exception e) {
				System.out.println("Invalid Input: " + scnr.next());
			}
		}
		//Close scanner when user input is complete
		scnr.close(); 
		
		//Print the result for the user
		System.out.print("The product of ");
		for(double num : numbers) {
			System.out.print(num + " ");
		}
		
		//Call method to multiply inputed numbers
		double finalProduct = multiply(numbers);
		

		System.out.print("is: " + finalProduct);
		
	}
	
	

}
