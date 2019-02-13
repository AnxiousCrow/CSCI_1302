//------------------------------------------------------------------------------
//	HockeyPlayer.java
//	by Caleb Phillips
//	CSCI 1302
//	Chapter 9 Lab #2
//	9/12/18 - 9/14/18
//------------------------------------------------------------------------------

public class HockeyPlayer extends ProPlayer
{
	private String teamName;
	private int bonusPay;
	
	//	Creates the Hockey Player by taking in their name, team
	//	name and their bonus pay
	public HockeyPlayer(String playerName, String teamName, int bonusPay){
		super(playerName);
		this.teamName = teamName;
		this.bonusPay = bonusPay;
	}
	
	//	Outputs the sum of the base salary and bonus pay of the player
	public int calculatePay() {
		int calculatedPay = getBaseSalary() + bonusPay;
		return calculatedPay;
	}
	
	public String hockeyPlayerInfo(){
		return getName() + " plays for the " 
				+ teamName + " and makes $"+ calculatePay() + " a year.";
	}
}