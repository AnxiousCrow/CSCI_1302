//******************************************************************
//	PocketMain.java
//	Caleb Phillips
//	Project 2
//	11/03/18 - 11/10/18
//******************************************************************

import java.util.*;

public class PocketMain {
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		Pocket pocket = new Pocket();

		boolean exit = false;
		String input;

		System.out.println(pocket.menu());	// prints the menu of commands

		while (!exit) {
			try {
				System.out.print(">");

				input = scan.nextLine();
				input = input.toUpperCase(); // Immediately converts user input to upperCase 

				
				// throws exception if input is not a valid command
				if (!pocket.isValidCmd(input)) {
					throw NoSuchCoin.notValidCmd;
				}

				
				// ******************************************
				// Adding coins
				// ******************************************
				if (input.contentEquals("ADD")) {
					Coin coin;

					System.out.println(" Add - Please enter the type of coin.");
					System.out.println("");
					System.out.print(">");

					input = scan.nextLine();
					input = input.toUpperCase();

					// throws exception if input is not a valid coin
					if (!pocket.isValidCoinCmd(input)) {
						throw NoSuchCoin.notValidCoin;
					}

					// determines the coin type based off of the String input
					coin = pocket.determineCoin(input);
					pocket.addCoin(coin);

					System.out.println(" " + coin + " was added.");
					System.out.println("");
				}

				
				// ******************************************
				// Removing coins
				// ******************************************
				if (input.contentEquals("REMOVE")) {

					Coin coin;

					System.out.println(" Remove - Please enter the type of coin.");
					System.out.println("");
					System.out.print(">");

					input = scan.nextLine();
					input = input.toUpperCase();

					// throws exception if input is not a valid coin
					if (!pocket.isValidCoinCmd(input)) {
						throw NoSuchCoin.notValidCoin;
					}

					// determines the coin type based off of the String input
					coin = pocket.determineCoin(input);

					// If the coins isn't already present in the pocket 
					// then you are unable to remove it
					if (pocket.isPresentInPocket(coin)) {
						pocket.removeCoin(coin);
						System.out.println(coin.getCoinName() + " was removed.");
						System.out.println("");
					} else {
						System.out.println(coin.getCoinName() + " is not present in the pocket.");
						System.out.println("");
					}
				}

				
				// ******************************************
				// Prints total value in pocket
				// ******************************************
				if (input.contentEquals("VALUE")) {
					System.out.println("Total Value: " + pocket.totalValue());
					System.out.println("");
				}

				
				// ******************************************
				// Prints the number of coins
				// ******************************************
				if (input.contentEquals("COUNT")) {
					System.out.println(pocket.countCoins());
					System.out.println("");
				}

				
				// ******************************************
				// Prints the command menu
				// ******************************************
				if (input.contentEquals("MENU")) {
					System.out.println(pocket.menu());
					System.out.println("");
				}

				
				// ******************************************
				// Exits Main Prompt
				// ******************************************
				if (input.contentEquals("EXIT")) {
					exit = true;
					System.out.println("Terminated");
				}

				
			} catch (NoSuchCoin e) {
				System.out.println(e.getMessage());
				System.out.println("");
			}
			
		}
		
	}
	
}
