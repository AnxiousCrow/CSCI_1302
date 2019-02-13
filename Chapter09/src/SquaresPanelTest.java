//---------------------------------------------------------------------
//	SquaresPanel.java
//	by Caleb Phillips
//	CSCI 1302
//	Chapter 9, Lab #2
//	9/13/18 - 9/15/18
//---------------------------------------------------------------------

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SquaresPanelTest extends JPanel
{	
	private final int SIZE = 15;  // radius of each dot

	Random gen = new Random();

	private final int WIDTH = 1440, HEIGHT = 855;	// Screen size
	private final int DELAY = 20;
	private final int ARRAY_SIZE = 10000;	//	number of squares you can draw

	int x, y;	//	x-axis and y-axis speeds
	int max = 5, min = 5;	//	max and min speeds for the squares
							//	min will become a negative number (so 5 == -5)
	private Timer timer;

	private ArrayList<Point> pointList;

	int[][] randomXY = new int[ARRAY_SIZE][2];	//	2D array for x & y directions

	int[][] randomRGB = new int[ARRAY_SIZE][3];	//	2D array filled with RGB values
												//	'3' because R, G, and B
	//-----------------------------------------------------------------
	//  Constructor: Sets up this panel to listen for mouse events.
	//-----------------------------------------------------------------
	public SquaresPanelTest()
	{
		timer = new Timer(DELAY, new SquaresListener());

		//-----------------------------------------------------------------
		//  Fills the arrays with a number from -min to max, but 
		//	not including 0
		//-----------------------------------------------------------------
		for(int i = 0; i < ARRAY_SIZE; i++)
		{
			for(int ii = 0; ii < 2; ii++)
			{
				randomXY[i][ii] = gen.nextInt(max + 1 + min) - min;

				while(randomXY[i][ii] == 0)
					randomXY[i][ii] = gen.nextInt(max + 1 + min) - min;
			}
		}

		for(int i = 0; i < ARRAY_SIZE; i++)
			for(int ii = 0; ii < 3; ii++)	//	fills the 2D array with random values
				randomRGB[i][ii] = gen.nextInt(256); //	for RGB values

		pointList = new ArrayList<Point>();

		addMouseListener (new SquaresListener());
		addMouseMotionListener(new SquaresListener());

		setBackground(Color.black);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		timer.start();
	}

	//-----------------------------------------------------------------
	//  Draws all of the squares stored in the list.
	//-----------------------------------------------------------------
	public void paintComponent(Graphics page)
	{		
		super.paintComponent(page);

		for (Point spot : pointList)	//	Keeps the squares the same color
		{
			page.setColor(new Color(randomRGB[pointList.indexOf(spot)][0],
					randomRGB[pointList.indexOf(spot)][1], randomRGB[pointList.indexOf(spot)][2]));

			page.fillRect(spot.x-SIZE, spot.y-SIZE, SIZE*2, SIZE*2);
		}
		page.setColor(Color.green);
		page.drawString("Count: " + pointList.size(), 5, 15);
	}

	//*****************************************************************
	//  Represents the listener for mouse events.
	//*****************************************************************
	private class SquaresListener implements ActionListener, MouseListener, MouseMotionListener
	{
		//--------------------------------------------------------------
		//  Adds the current point to the list of points and redraws
		//  the panel whenever the mouse button is pressed.
		//--------------------------------------------------------------

		public void actionPerformed(ActionEvent event)
		{
			for(Point spot : pointList)	//	assigns a random X&Y values
			{
				spot.x += randomXY[pointList.indexOf(spot)][0];
				spot.y += randomXY[pointList.indexOf(spot)][1];

				if(spot.x <= 0+SIZE || spot.x >= WIDTH-SIZE)	
					randomXY[pointList.indexOf(spot)][0] *= -1;	//	Boundary
																//	Checker
				if(spot.y <= 0+SIZE || spot.y >= HEIGHT-SIZE)
					randomXY[pointList.indexOf(spot)][1] *= -1;

				repaint();
			}
		}

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




/*

//---------------------------------------------------------------------
//	SquaresPanel.java
//	by Caleb Phillips
//	CSCI 1302
//	Chapter 9, Lab #2
//	9/13/18 - 9/15/18
//---------------------------------------------------------------------

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SquaresPanel extends JPanel
{	
	private final int SIZE = 5;  // radius of each dot

	Random gen = new Random();

	private final int WIDTH = 1440, HEIGHT = 855;	// Screen size
	private final int DELAY = 20;
	private final int ARRAY_SIZE = 10000;	//	number of squares you can draw

	int x, y;	//	x-axis and y-axis speeds
	int max = 5, min = 5;	//	max and min speeds for the squares
							//	min will become a negative number (so 5 == -5)

	private Timer timer;

	private ArrayList<Point> pointList;

	int[] randomX = new int[ARRAY_SIZE];
	int[] randomY = new int[ARRAY_SIZE];
	
	int[] randomR = new int[ARRAY_SIZE];
	int[] randomG = new int[ARRAY_SIZE];	//	for assigning random color 
	int[] randomB = new int[ARRAY_SIZE];	//	 to a square
	
	
	//-----------------------------------------------------------------
	//  Constructor: Sets up this panel to listen for mouse events.
	//-----------------------------------------------------------------
	public SquaresPanel()
	{
		timer = new Timer(DELAY, new SquaresListener());

		//-----------------------------------------------------------------
		//  Fills the arrays with a number from -min to max, but 
		//	not including 0
		//-----------------------------------------------------------------
		for(int i = 0; i < ARRAY_SIZE; i++)
		{
			
			randomX[i] = gen.nextInt(max + 1 + min) - min;

			while(randomX[i] == 0)		//	So that the squares don't have a 0 speed
				randomX[i] = gen.nextInt(max + 1 + min) - min;

			randomY[i] = gen.nextInt(max + 1 + min) - min;

			while(randomY[i] == 0)
				randomY[i] = gen.nextInt(max + 1 + min) - min;

			randomR[i] = gen.nextInt(256);
			randomG[i] = gen.nextInt(256);	//	Assigns a unique color to
			randomB[i] = gen.nextInt(256);	//	each square		
		}

		pointList = new ArrayList<Point>();

		addMouseListener (new SquaresListener());
		addMouseMotionListener(new SquaresListener());

		setBackground(Color.black);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		timer.start();
	}

	//-----------------------------------------------------------------
	//  Draws all of the squares stored in the list.
	//-----------------------------------------------------------------
	public void paintComponent(Graphics page)
	{		
		super.paintComponent(page);

		for (Point spot : pointList)
		{
			page.setColor(new Color(randomR[pointList.indexOf(spot)],
					randomG[pointList.indexOf(spot)], randomB[pointList.indexOf(spot)]));
			
			page.fillRect(spot.x-SIZE, spot.y-SIZE, SIZE*2, SIZE*2);
		}

		page.setColor(Color.green);
		page.drawString("Count: " + pointList.size(), 5, 15);
	}

	//*****************************************************************
	//  Represents the listener for mouse events.
	//*****************************************************************
	private class SquaresListener implements ActionListener, MouseListener, MouseMotionListener
	{
		//--------------------------------------------------------------
		//  Adds the current point to the list of points and redraws
		//  the panel whenever the mouse button is pressed.
		//--------------------------------------------------------------

		public void actionPerformed(ActionEvent event)
		{
			for(Point spot : pointList)
			{
				spot.x += randomX[pointList.indexOf(spot)];
				spot.y += randomY[pointList.indexOf(spot)];

				if(spot.x <= 0+SIZE || spot.x >= WIDTH-SIZE)
					randomX[pointList.indexOf(spot)] *= -1;

				if(spot.y <= 0+SIZE || spot.y >= HEIGHT-SIZE)
					randomY[pointList.indexOf(spot)] *= -1;

				repaint();
			}
		}

		public void mousePressed(MouseEvent event)
		{
			pointList.add(event.getPoint());
			repaint();
		}

		public void mouseDragged(MouseEvent event){
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




*/