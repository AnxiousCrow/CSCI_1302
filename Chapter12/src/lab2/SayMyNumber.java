package lab2;

//******************************************************************
//	SayMyNumber.java
//	Caleb Phillips
//	Chapter 12, Lab #2
//	11/3/18 - 11/6/18
//******************************************************************

import java.util.Scanner;

public class SayMyNumber {
	public static void main(String args[]) {

		// TODO: add try and catch | close Scanner

		Scanner scan = new Scanner(System.in);
		int input;

		System.out.println("Please enter a positive integer.");
		input = scan.nextInt();
		System.out.println(say(input));
	}

	static String[] numbers = {	"", "one", "two", "three", "four", "five",
								"six", "seven", "eight", "nine", "ten", "eleven",
								"twelve", "thirteen", "fourteen", "fifteen",
								"sixteen", "seventeen", "eighteen", "ninteen", "twenty"};

	static String[] tens = {"twenty ", "thirty ", "forty ", "fifty ",
							"sixty ", "seventy ", "eighty ", "ninety "};

	// ***************************************************************
	// Recursively spells out any number between 1 and 2.1 billion.
	// ***************************************************************
	private static String say(int n) {

		if (n <= 20)
			return numbers[n];

		if (n < 100) // 99
			return tens[(n / 10) - 2] + say(n % 10);

		if (n < 1000) // 999 max
			return say(n / 100) + " hundred " + say(n % 100);

		if (n < 1000_000) // 999_999 max
			return say(n / 1000) + " thousand " + say(n % 1000);

		if (n < 1000_000_000) // 999_999_999 max
			return say(n / 1000_000) + " million " + say(n % 1000_000);

		if (n <= 2147_483_647) // 2147_483_647 max integer value
			return say(n / 1000_000_000) + " billion " + say(n % 1000_000_000);

		else
			return "error";
	}
}