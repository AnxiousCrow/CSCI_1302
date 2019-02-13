//*********************************************************************
//  DotsPanel.java
//
//  Represents the primary panel for the Dots program.
//*********************************************************************

import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class DotsPanel extends JPanel
{
	private final int SIZE = 10;  // radius of each dot

	Random gen = new Random();
	int R = gen.nextInt(255);
	int G = gen.nextInt(255);
	int B = gen.nextInt(255);

	private ArrayList<Point> pointList;

	//-----------------------------------------------------------------
	//  Constructor: Sets up this panel to listen for mouse events.
	//-----------------------------------------------------------------
	
	public DotsPanel()
	{
		pointList = new ArrayList<Point>();

		addMouseListener (new DotsListener());
		addMouseMotionListener(new DotsListener());

		setBackground(Color.black);
		setPreferredSize(new Dimension(700, 700));
	}

	//-----------------------------------------------------------------
	//  Draws all of the dots stored in the list.
	//-----------------------------------------------------------------
	
	public void paintComponent(Graphics page)
	{     
		
		//page.setColor(Color.green);
		
		super.paintComponent(page);

		for (Point spot : pointList) 
		{ 
			R = gen.nextInt(255);
			G = gen.nextInt(255);
			B = gen.nextInt(255);
			
			page.setColor(new Color(R, G, B));

			page.fillOval(spot.x-SIZE, spot.y-SIZE, SIZE*2, SIZE*2);
		}

		page.setColor(Color.green);
		page.drawString("Count: " + pointList.size(), 5, 15);
	}

	//*****************************************************************
	//  Represents the listener for mouse events.
	//*****************************************************************

	private class DotsListener implements MouseListener, MouseMotionListener
	{

		//--------------------------------------------------------------
		//  Adds the current point to the list of points and redraws
		//  the panel whenever the mouse button is pressed.
		//--------------------------------------------------------------

		public void mousePressed(MouseEvent event)
		{
			pointList.add(event.getPoint());
			repaint();
		}

		public void mouseDragged(MouseEvent event) 
		{
			pointList.add(event.getPoint());
			repaint();
		}
		

		//--------------------------------------------------------------
		//  Provide empty definitions for unused event methods.
		//--------------------------------------------------------------

		public void mouseClicked(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		public void mouseMoved(MouseEvent event) {}

	}


}
