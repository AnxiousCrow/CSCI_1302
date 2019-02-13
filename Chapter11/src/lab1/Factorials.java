package lab1;

//******************************************************************
//	Factorials.java
//	Caleb Phillips
//	Chapter 11, Lab #1
//	10/21/18 - 10/25/18
//******************************************************************

import java.util.Scanner;

public class Factorials {
	// -------------------------------------------------------------
	// Displays the factorial of a number the user inputs
	// -------------------------------------------------------------
	public static void main(String[] args) throws myException {

		int val;
		String keepGoing = "y";
		Scanner scan = new Scanner(System.in);

		while (keepGoing.equalsIgnoreCase("y")) {

			try {
				System.out.print("Enter an integer: ");
				val = scan.nextInt();
				System.out.println("Factorial(" + val + ") = " + MathUtils.factorial(val));
				
			// Catches errors the factorial function throws
			} catch (myException e) {
				System.out.println("EXCEPTION: " + e.getMessage());
			} 
			
			System.out.print("Another factorial? (y/n) ");
			keepGoing = scan.next();
		}
		
		if(!keepGoing.equalsIgnoreCase("y")) {
			System.out.println("Closed");
			scan.close();
		}
	}
}