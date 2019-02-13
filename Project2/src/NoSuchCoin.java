//******************************************************************
//	NoSuchCoin.java
//	Caleb Phillips
//	Project 2
//	11/03/18 - 11/10/18
//******************************************************************

// Exception Class
public class NoSuchCoin extends Exception {
	
	static NoSuchCoin notValidCmd = new NoSuchCoin("Not a valid command. Type 'MENU' to view commands.");
	static NoSuchCoin notValidCoin = new NoSuchCoin("Not a valid coin. Type 'MENU' to view coins.");
	
	NoSuchCoin(String str) {
		super(str);
	}
}