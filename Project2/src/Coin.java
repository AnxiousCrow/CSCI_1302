//******************************************************************
//	Coin.java
//	Caleb Phillips
//	Project 2
//	11/03/18 - 11/10/18
//******************************************************************

// Parent class to Penny, Nickel, Dime, and Quarter
public abstract class Coin {
	protected String coinName;
	protected double coinValue;
	protected int coinCount;

	// Inherited by child classes
	Coin(String coinName) {
		this.coinName = coinName;
	}
	
	String getCoinName() {
		return coinName;
	}

	// Overridden by child classes
	abstract double getCoinValue();

}