
// ****************************************************************
// CountLetters.java
//
// Reads a words from the standard input and prints the number of
// occurrences of each letter in that word.
//
// ****************************************************************

import java.util.ArrayList;
import java.util.Scanner;

public class CountLetters {
	public static void main(String[] args) {

		int[] counts = new int[26];
		char err = 'Z';

		ArrayList<String> list = new ArrayList<>();

		Scanner scan = new Scanner(System.in);
		try {
			// get word from user
			System.out.print("Enter a single word (letters only, please): ");
			String word = scan.nextLine();

			// convert to all upper case
			word = word.toUpperCase();

			// count frequency of each letter in string
			for (int i = 0; i < word.length(); i++) {
				counts[word.charAt(i) - 'A']++;

				if (!Character.isLetter(word.charAt(i)))
					;
				list.add(word.charAt(i + 1), word);
			}

			System.out.println();

			for (int i = 0; i < counts.length; i++) {
				if (counts[i] != 0)
					System.out.println((char) (i + 'A') + ": " + counts[i]);
			}

		} catch (Exception exception) {

			System.out.println("Please only enter letters");
			
				System.out.println(err);


		}
	}
}