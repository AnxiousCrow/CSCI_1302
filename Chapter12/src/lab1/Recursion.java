package lab1;

//******************************************************************
//	Recursion.java
//	Caleb Phillips
//	Chapter 12, Lab #1
//	11/1/18 - 11/6/18
//******************************************************************

import java.util.Scanner;
import java.util.*;

public class Recursion {
	public static void main(String args[]) {

		int input;
		String ordinal;

		try (Scanner scan = new Scanner(System.in)) {

			System.out.println("Please enter a positive integer. (1 to 16)");
			input = scan.nextInt();

			if (input > 16)
				throw new ArithmeticException();

			int sum = sum(input);
			int product = product(input);
			int fibo = fibo(input);

			if (input == 1) {
				ordinal = "st";
			} else if (input == 2) {
				ordinal = "nd";
			} else if (input == 3) {
				ordinal = "rd";
			} else {
				ordinal = "th";
			}

			System.out.printf("The product of the numbers from 1 to %d (%d!) is: %d", input, input, product);
			System.out.printf("\nThe sum of the numbers from 1 to %d is: %d", input, sum);
			System.out.printf("\nThe %d%s Fibonacci number is: %d", input, ordinal, fibo);

		} catch (ArithmeticException e) {
			System.out.println("Error: ArithmeticException");
			System.out.println("Please enter a number from 1 to 16.");
		} catch (InputMismatchException e) {
			System.out.println("Error: InputMismatchException");
			System.out.println("Please enter a valid number.");
		} catch (StackOverflowError e) {
			System.out.println("Error: StackOverflowError");
			System.out.println("Please enter a positive number.");
		}
	}

	// *****************************************************
	// Finds the product from 1 to n
	// *****************************************************
	public static int product(int i) {
		if (i <= 1)
			return 1;
		else
			return product(i - 1) * i;
	}

	// *****************************************************
	// Finds the sum of the numbers from 1 to n
	// *****************************************************
	public static int sum(int i) {
		if (i == 0)
			return 0;
		else if (i == 1)
			return 1;
		else
			return i + sum(i - 1);
	}

	// *****************************************************
	// Finds the nth number in the Fibonacci sequence
	// *****************************************************
	public static int fibo(int i) {
		if (i == 0)
			return 0;
		else if (i == 1)
			return 1;
		else
			return fibo(i - 2) + fibo(i - 1);
	}
}