//-----------------------------------------------------------------------------------------------------------
//	DiceSim.java
//	by Caleb Phillips
//	CSCI 1302
//	Lab #1
//	8/20/18 - 8/23/18
//-----------------------------------------------------------------------------------------------------------

//***********************************************************************************************************
//	Coin Flip Array program
//***********************************************************************************************************

import java.util.Random;

public class DiceSim {

	public static void main(String[] args) {
		
		Random gen = new Random();
		
		final int NUMDICE1 = 5;		// Number of dice in one roll
		final int NUMROLLS = 7776;	// Number of times you roll the dice
		
		int yahtzee = 0;
		
		int[] dice1 = new int[NUMDICE1];	// Creates the multiple dice
		
		for(int i = 0; i < NUMROLLS; i++) {
			
			for(int ii = 0; ii < NUMDICE1; ii++)	// Loops a set number of times and assigns a random 
				dice1[ii] = gen.nextInt(6) + 1;		// number between 1 and 6 to the index
													
			if(dice1[0] == dice1[1] && dice1[1] == dice1[2]
					&& dice1[2] == dice1[3] && dice1[3] == dice1[4]) 
				yahtzee++;
		
		}

		
		System.out.println("For " + NUMDICE1 + " dice rolled " + NUMROLLS + " times,");
		System.out.println("you got " + yahtzee + " Yahtzees.\n");
		System.out.println("-----------------------------\n");													

		
		
//***********************************************************************************************************
//	2D Array  5x5 rolls
//
//	Should work with any number as long as you keep 'ROLLS' and 'NUMDICE' the same value
//***********************************************************************************************************


		final int ROLLS = 5;		// y-axis in array	(column)
		final int NUMDICE = 5;		// x-axis in array	(row)
		
		int rowYahtzees = 0, colYahtzees = 0, diaYahtzees = 0;
		
		int[][] dice = new int[ROLLS][NUMDICE];

		for(int row = 0; row < dice.length; row++)			// Fills the 2D-array with random int 1-6
			for(int col = 0; col < dice[row].length; col++)
				dice[row][col] = gen.nextInt(6) + 1;
		
		
//-----------------------------------------------------------------------------------------------------------
//	Diagonal Yahtzee bottom left to top right 		
//-----------------------------------------------------------------------------------------------------------
		
		int j = 0;		// To keep track of same numbers next to each other.
		
		for(int row = (NUMDICE - 1); row > 0; row--) {				// Starts from the bottom left, so -1
			
			for(int col = 0; col < (NUMDICE - 1); col++) {
				
				if((col + row) == (NUMDICE - 1)) {		// ***
					
					if(dice[row][col] == dice[row-1][col+1])	
						j++;
												
					else
						j = 0;	
				}							// ***
			}								// There is a pattern for diagonal Yahtzee bottom 
											// left to top right. The index always adds up to
		}									// the length of the array - 1.
		
		if(j == (NUMDICE - 1))
			diaYahtzees++;
	
		
//-----------------------------------------------------------------------------------------------------------
//		Diagonal Yahtzee top left to bottom right	
//-----------------------------------------------------------------------------------------------------------
		
		int p = 0;		// To keep track of same numbers next to each other.
		
		for(int dia = 0; dia < NUMDICE; dia++) {
			
			if(dia < (NUMDICE - 1)) {
				
				if(dice[dia][dia] == dice[dia+1][dia+1])	// For top left to bottom right, the row
					p++;									// and column values are the same
				
				else
					p = 0;
				
			}	
		}
		
		if(p == (NUMDICE - 1))
			diaYahtzees++;
		
		
//-----------------------------------------------------------------------------------------------------------
//		Finds a Yahtzee in a Row
//-----------------------------------------------------------------------------------------------------------
		
		int tick = 0;	// To keep track of same numbers next to each other.
						
		for(int row = 0; row < NUMDICE; row++) {
			
			for(int col = 0; col < ROLLS; col++) {
				
				if(col < (ROLLS - 1)) {
					
					if(dice[row][col] == dice[row][col+1]) 	// Compares one value in the column to the
						tick++;								// value right next to it. If they are the 
															// same, 1 is added to 'tick'.
					else
						tick = 0;
				}

				if(tick == (ROLLS - 1)) {		// If 'tick' reaches 4 then that means the whole row
												// consists of the same number
					rowYahtzees++;
					tick = 0;
					
				}
				
			}
			
			tick = 0;
			
		}

		
//-----------------------------------------------------------------------------------------------------------
//		Finds a Yahtzee in a Column
//-----------------------------------------------------------------------------------------------------------
		
		int tick1 = 0;	// To keep track of same numbers next to each other.
						
		for(int col = 0; col < ROLLS; col++) {

			for(int row = 0; row < NUMDICE; row++) {

				if(row < (NUMDICE - 1)) {

					if(dice[row][col] == dice[row+1][col]) 	// Compares one value in the row to the
						tick1++;							// value right next to it. If they are the 
															// same, 1 is added to 'tick1'.
					else
						tick1 = 0;
				}

				if(tick1 == (NUMDICE - 1)) {		// If 'tick1' reaches 4 then that means the whole column
													// consists of the same number
					colYahtzees++;
					tick1 = 0;

				}

			}

			tick1 = 0;

		}
		

//-----------------------------------------------------------------------------------------------------------

		
		
		for(int row = 0; row < dice.length; row++) {
			for(int col = 0; col < dice[row].length; col++)		// Prints the 2D-array
				System.out.print(dice[row][col] + " ");
			System.out.println();
		}
		

		System.out.println("\nRow Yahtzees:\t\t" + rowYahtzees);
		System.out.println("Column Yahtzees:\t" + colYahtzees);
		System.out.println("Diagonal Yahtzees:\t" + diaYahtzees);
		
		
		
	}
}


/*
int k = 0;

dice[0][4] = k;
dice[0][3] = k;
dice[0][2] = k;				// ******	TESTING PURPOSES ONLY	******
dice[0][1] = k;
dice[0][0] = k;

dice[3][0] = k;
dice[3][1] = k;
dice[3][2] = k;				// ******	TESTING PURPOSES ONLY	******
dice[3][3] = k;
dice[3][4] = k;
*/

/*-
 *               __
 *              / _)         
 *       .-^^^-/ /          
 *    __/       /              
 *   <__.|_|-|_| 
 *   
 */


