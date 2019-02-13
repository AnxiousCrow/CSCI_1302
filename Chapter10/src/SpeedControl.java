
// ********************************************************************
// 	SpeedControl.java
//	Caleb Phillips	
//	Chapter 10, Lab #2
//	10/1/18 - 10/4/18
//
// 	Demonstrates animation -- balls bouncing off the sides of a panel -
// 	with speed controlled by a slider.
// ********************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SpeedControl {
// ------------------------------------
// Sets up the frame for the animation.
// ------------------------------------
	public static void main(String[] args) {
		JFrame frame = new JFrame("Bouncing Balls");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new SpeedControlPanel());
		frame.pack();
		frame.setVisible(true);
	}
}