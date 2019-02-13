//---------------------------------------------------------------------
//	Squares.java
//	by Caleb Phillips
//	CSCI 1302
//	Chapter 9, Lab #2
//	9/13/18 - 9/15/18
//---------------------------------------------------------------------
import javax.swing.JFrame;

public class Squares
{
   //-----------------------------------------------------------------
   //  Creates and displays the application frame.
   //-----------------------------------------------------------------
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Squares");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(new SquaresPanel());

      frame.pack();
      frame.setVisible(true);
   }
}
