
//******************************************************************
//	Pocket.java
//	Caleb Phillips
//	Project 2
//	11/03/18 - 11/10/18
//******************************************************************

import java.util.*;
import java.text.*;

public class Pocket {
	
	static Coin penny = new Penny("Penny");
	static Coin nickel = new Nickel("Nickel");
	static Coin dime = new Dime("Dime");
	static Coin quarter = new Quarter("Quarter");
	
	static String[] validCmd = { "ADD", "REMOVE", "COUNT", "VALUE", "MENU", "EXIT" };
	static String[] validCoinCmd = { "PENNY", "NICKEL", "DIME", "QUARTER" };
	
	ArrayList<Coin> coins = new ArrayList<Coin>();
	
	// formats the values of coins as $0.00
	NumberFormat nf = NumberFormat.getCurrencyInstance();

	
	// ****************************************************************
	// Adds a specified coin to the pocket
	// ****************************************************************
	protected void addCoin(Coin coin) {
		coins.add(coin);
	}
	
	
	// ****************************************************************
	// Determines if a specific coin is present in the pocket
	//
	// Works along with 'removeCoin' to keep from a
	// non-existent coin being removed
	// ****************************************************************
	protected boolean isPresentInPocket(Coin coin) {
		if (coins.contains(coin))
			return true;
		else
			return false;
	}

	
	// ****************************************************************
	// Finds and removes the first instance of the specified coin
	//
	// Works along with 'isPresentInPocket' to keep from a
	// non-existent coin being removed
	// ****************************************************************
	protected void removeCoin(Coin coin) {
		int index = coins.indexOf(coin); // returns -1 if not present
		if (index >= 0)
			coins.remove(index);
		else
			coins.remove(null);
	}

	
	// ****************************************************************
	// Counts all the coins in the pocket and prints them in a list
	//
	// Not the best solution, but seems to work...
	// Had a hard time condensing this down due to visibility of the 
	// 'counter' variables combined with the return statements. 
	// ****************************************************************
	protected int countPenny() {
		int numP = 0;
		for (Coin c : coins) {
			if (c.getCoinName().contentEquals("Penny")) {
				numP++;
			}
		}
		return numP;
	}

	protected int countNickel() {
		int numN = 0;
		for (Coin c : coins) {
			if (c.getCoinName().contentEquals("Nickel")) {
				numN++;
			}
		}
		return numN;
	}

	protected int countDime() {
		int numD = 0;
		for (Coin c : coins) {
			if (c.getCoinName().contentEquals("Dime")) {
				numD++;
			}
		}
		return numD;
	}

	protected int countQuarter() {
		int numQ = 0;
		for (Coin c : coins) {
			if (c.getCoinName().contentEquals("Quarter")) {
				numQ++;
			}
		}
		return numQ;
	}

	
	// **********************************************************
	// Separate method to print the list of coins
	// Had to use separate method due to visibility problems
	// and trouble with the return statements
	// **********************************************************
	protected String countCoins() {
		
		int total = countPenny() + countNickel() + countDime() + countQuarter();
		String str;

		str =    " -----------------";
		str += "\n| Pennies:\t" + countPenny() + " |";
		str += "\n| Nickels:\t" + countNickel() + " |";
		str += "\n| Dimes:\t" + countDime() + " |";
		str += "\n| Quarters:\t" + countQuarter() + " |";
		str += "\n|-----------------|";
		str += "\n| Total:\t" + total + " |";
		str += "\n -----------------";

		return str;
	}

	
	// ****************************************************************
	// Prints the list of valid commands at the start of the program
	// and prints whenever the USER calls for it
	// ****************************************************************
	protected String menu() {
		String menu;
		menu = 	" ------------------------------------------- \n";
		menu += "|                  COMMANDS                 |\n";
		menu += "|ADD       Adds a coin specified by USER    |\n";
		menu += "|COUNT     Displays a count of all coins    |\n";
		menu += "|EXIT      Exits the program                |\n";
		menu += "|MENU      Displays this menu               |\n";
		menu += "|REMOVE    Removes a coin sepcified by USER |\n";
		menu += "|VALUE     Displays total value in pocket   |\n";
		menu += "|-------------------------------------------|\n";
		menu += "|                VALID COINS                |\n";
		menu += "|   PENNY  |  NICKEL  |  DIME  |  QUARTER   |\n";
		menu += "|-------------------------------------------|\n";
		menu += "|              EXAMPLE COMMAND              |\n";
		menu += "|>add                                       |\n";
		menu += "| Add - Please enter the type of coin.      |\n";
		menu += "|                                           |\n";
		menu += "|>penny                                     |\n";
		menu += "| Penny was added.                          |\n";
		menu += " ------------------------------------------- \n";

		return menu;
	}
	
	
	// ****************************************************************
	// Determines the type of coin that the USER wants to add or
	// remove based on the String they input.
	//
	// Translates the string to the corresponding coin type
	// ****************************************************************
	protected Coin determineCoin(String input) {
		Coin coin;

		if (input.contentEquals("PENNY")) {
			coin = penny;
		} else if (input.contentEquals("NICKEL")) {
			coin = nickel;
		} else if (input.contentEquals("DIME")) {
			coin = dime;
		} else if (input.contentEquals("QUARTER")) {
			coin = quarter;
		} else {
			coin = null;
		}

		return coin;
	}

	
	// ****************************************************************
	// Determines if the command the USER inputs is valid or not
	//
	// Compares the input with the contents of the 'validCmd' array
	// ****************************************************************
	public boolean isValidCmd(String input) {
		if (!Arrays.asList(validCmd).contains(input)) {
			return false;
		} else
			return true;

	}

	
	// ****************************************************************
	// Determines if the type of coin the USER inputs is valid or not
	//
	// Compares the input with the contents of the 'validCoinCmd' array
	// ****************************************************************
	public boolean isValidCoinCmd(String input) {
		if (!Arrays.asList(validCoinCmd).contains(input)) {
			return false;
		} else
			return true;
	}
	
	
	// ****************************************************************
	// Calculates the total value of coins present in the pocket
	//
	// Uses the currency formatter to keep the price to a max
	// of two decimal places, $0.00, so no remainders are present
	// ****************************************************************
	protected String totalValue() {
		double totalAmount = 0;
		for (Coin coin : coins) {
			totalAmount += coin.getCoinValue();
		}
		return nf.format(totalAmount);
	}
	
	
	// ****************************************************************
	// Prints the contents of the 'coins' ArrayList
	// only used for testing
	// ****************************************************************
	public String toString() {
		return "\n" + Arrays.toString(coins.toArray()) + "\n";
	}

}
