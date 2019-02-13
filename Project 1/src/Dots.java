//---------------------------------------------------------------------
//	Dots.java
//	by Caleb Phillips
//	CSCI 1302
//	Project 1
//	9/13/18 - 9/20/18
//---------------------------------------------------------------------

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Dots{

   //-----------------------------------------------------------------
   //  Creates and displays the application frame.
   //-----------------------------------------------------------------
   public static void main(String[] args){

      JFrame frame = new JFrame("Dots");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(new DotsPanel());

      frame.pack();
      frame.setVisible(true);
   }
}