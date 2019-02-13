
//******************************************************************
//	SayMyLongNumber.java
//	Caleb Phillips
//	Chapter 12, Lab #2
//	11/15/18 - 11/20/18
//******************************************************************

import java.util.InputMismatchException;
import java.util.Scanner;

public class SayMyLargeNumber {
	public static void main(String args[]) {

		try (Scanner scan = new Scanner(System.in)) {

			long input;

			System.out.println("Please enter a positive integer.");
			input = scan.nextLong();
			System.out.println(say(input));

		} catch (ArithmeticException e) {
			System.out.println("Error: ArithmeticException");
			System.out.println("Please enter a valid number.");
		} catch (InputMismatchException e) {
			System.out.println("Error: InputMismatchException");
			System.out.println("Please enter a valid number.");
		}
	}

	static String[] numbers = {	"", "one", "two", "three", "four", "five",
								"six", "seven", "eight", "nine", "ten", "eleven",
								"twelve", "thirteen", "fourteen", "fifteen",
								"sixteen", "seventeen", "eighteen", "ninteen", "twenty"};

	static String[] tens = {"twenty ", "thirty ", "forty ", "fifty ",
							"sixty ", "seventy ", "eighty ", "ninety "};

	// ***************************************************************
	// Recursively spells out any number between 1 and .
	// ***************************************************************
	private static String say(long n) {

		long mill = (long) Math.pow(10, 6);
		long bill = (long) Math.pow(10, 9);
		long tril = (long) Math.pow(10, 12);
		long quad = (long) Math.pow(10, 15);
		long quin = (long) Math.pow(10, 18);
		long sext = (long) Math.pow(10, 21);

//		if (n == 0)
//			return "zero";

		if (n < 0)
			return "negative " + say(Math.abs(n));

		if (n <= 20)
			return numbers[(int) n];

		if (n < 100) // 99 max
			return tens[(int) ((n / 10) - 2)] + say(n % 10);

		if (n < 1000) // 999 max
			return say(n / 100) + " hundred " + say(n % 100);

		if (n < mill) // 999_999 max
			return say(n / 1000) + " thousand " + say(n % 1000);

		if (n < bill) // 999_999_999 max
			return say(n / mill) + " million " + say(n % mill);

		if (n < tril) // 999_999_999_999 max
			return say(n / bill) + " billion " + say(n % bill);

		if (n < quad) // 999_999_999_999_999 max
			return say(n / tril) + " trillion " + say(n % tril);

		if (n <= quin) // 999_999_999_999_999 max
			return say(n / quad) + " quadrillion " + say(n % quad);

		if (n < sext) // 999_999_999_999_999_999 max or 9.2 quintillion?
			return say(n / quin) + " quintillion " + say(n % quin);

		else
			throw new ArithmeticException();

	}
}