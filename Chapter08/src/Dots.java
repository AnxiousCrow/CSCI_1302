//---------------------------------------------------------------------
//	Dots.java
//	by Caleb Phillips
//	CSCI 1302
//	Chapter 8, Lab #2
//	9/3/18
//---------------------------------------------------------------------

import javax.swing.JFrame;

public class Dots
{
   //-----------------------------------------------------------------
   //  Creates and displays the application frame.
   //-----------------------------------------------------------------
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Dots");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(new DotsPanel());

      frame.pack();
      frame.setVisible(true);
   }
}
