//------------------------------------------------------------------------------
//	AllStarRoster.java
//	by Caleb Phillips
//	CSCI 1302
//	Chapter 9 Lab #2
//	9/12/18 - 9/14/18
//------------------------------------------------------------------------------

public class AllStarRoster {
	
	public static void main(String args[]){
		
		final int NUM_PLAYERS = 6;
		
		HockeyPlayer[] HockeyPlayer = new HockeyPlayer[NUM_PLAYERS];
		
		HockeyPlayer[0] = new HockeyPlayer("Sidney Crosby", "Penguins", 950000);
		HockeyPlayer[1] = new HockeyPlayer("Jaromir Jagr", "Penguins", 950000);
		HockeyPlayer[2] = new HockeyPlayer("Wayne Gretzky", "Kings", 1970300);
		HockeyPlayer[3] = new HockeyPlayer("Bobby Orr", "Bruins", 215896);
		HockeyPlayer[4] = new HockeyPlayer("Doug Glatt", "Flyers", 15896);
		HockeyPlayer[5] = new HockeyPlayer("Mario Lemieux", "Penguins", 50000);

		for(int i = 0; i < NUM_PLAYERS; i++)
			System.out.println(HockeyPlayer[i].hockeyPlayerInfo());
	}	
}