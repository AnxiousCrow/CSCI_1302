//******************************************************************
//	Quarter.java
//	Caleb Phillips
//	Project 2
//	11/03/18 - 11/10/18
//******************************************************************

// Creates a quarter based off of the Coin class
public class Quarter extends Coin {

	private double coinValue = 0.25;

	Quarter(String coinName) {
		super(coinName);
	}

	String getCoinName() {
		return coinName;
	}

	double getCoinValue() {
		return coinValue;
	}

	public String toString() {
		return coinName;
	}
}