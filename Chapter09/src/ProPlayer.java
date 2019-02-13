//------------------------------------------------------------------------------
//	ProPlayer.java
//	by Caleb Phillips
//	CSCI 1302
//	Chapter 9 Lab #2
//	9/12/18 - 9/14/18
//------------------------------------------------------------------------------

public abstract class ProPlayer {
	
	protected String playerName;
	protected int bonusPay;
	private int baseSalary = 300000;
		
	public ProPlayer(String playerName){
		this.playerName = playerName;
	}

	public String getName(){
		return playerName;
	}
	
	public int getBaseSalary(){
		return baseSalary;
	}
	
	//	Abstract Method to be used in child classes
	public abstract int calculatePay();	
}