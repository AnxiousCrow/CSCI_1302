
public class studentRecords {

	public static void main(String[] args) {

		final int NUM_RECORDS = 2;
		final int NUM_STUDENTS = 25;
		
		String[][] studentRecord = new String[NUM_STUDENTS][NUM_RECORDS];
		
		for(int i = 0; i < NUM_STUDENTS; i++)
		{
			for(int ii = NUM_RECORDS; ii < 2; ii++)
			{
				studentRecord[i][ii] = "Jim\t";
			}
		}
		
		for(int row = 0; row < studentRecord.length; row++) {
			for(int col = 0; col < studentRecord[row].length; col++)		// Prints the 2D-array
				System.out.print(studentRecord[row][col] + " ");
			System.out.println();
		}		
	}

}
