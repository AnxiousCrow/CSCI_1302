//---------------------------------------------------------------------
//	SquaresPanel.java
//	by Caleb Phillips
//	CSCI 1302
//	Chapter 9, Lab #2
//	9/13/18 - 9/20/18
//---------------------------------------------------------------------

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SquaresPanel extends JPanel {

	private int SIZE = 10; // radius of each dot

	Random gen = new Random();

	private final int WIDTH = 500, HEIGHT = 500; // Screen size
	private final int ARRAY_SIZE = 10000; // Number of squares you can draw

	private int delay = 10;

	int x, y; // x-axis and y-axis speeds
	int max = 5, min = 5; // max and min speeds for the squares
							// min will become a negative number (so 5 == -5)

	private Timer timer;

	private ArrayList<Point> pointList;

	int axis = 2;
	int[][] randomXY = new int[ARRAY_SIZE][axis]; // 2D array for x & y directions

	int colorRange = 4; // 2D array filled with RGB values
	int[][] randomRGB = new int[ARRAY_SIZE][colorRange];// '4' because R, G, B, and Transparency

	private JPanel dotSpeedPanel;
	private JSlider dotSpeedSlider;
	private JLabel dotSpeedLabel;

	
	
	// -----------------------------------------------------------------
	// Constructor: Sets up this panel to listen for mouse events.
	// -----------------------------------------------------------------
	public SquaresPanel() {

		timer = new Timer(10, new SquaresListener());

		this.setLayout(new BorderLayout());

		// -----------------------------------------------------------------
		// Fills the arrays with a number from -min to max, but
		// not including 0
		// -----------------------------------------------------------------
		for (int i = 0; i < ARRAY_SIZE; i++) {

			for (int ii = 0; ii < axis; ii++) {

				randomXY[i][ii] = gen.nextInt(max + 1 + min) - min;

				while (randomXY[i][ii] == 0)
					randomXY[i][ii] = gen.nextInt(max + 1 + min) - min;
			}

			for (int ii = 0; ii < colorRange; ii++) { // fills the 2D array with random values

				randomRGB[i][ii] = gen.nextInt(256); // for RGB values
			}
		}

		pointList = new ArrayList<Point>();

		addMouseListener(new SquaresListener());
		addMouseMotionListener(new SquaresListener());
		addMouseWheelListener(new SquaresListener());

		dotSpeedSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
		dotSpeedSlider.setMajorTickSpacing(1);
		dotSpeedSlider.setPaintTicks(true);
		dotSpeedSlider.setPaintLabels(true);
		dotSpeedSlider.setSnapToTicks(true);

		SlideListener listener = new SlideListener();
		dotSpeedSlider.addChangeListener(listener);

		dotSpeedLabel = new JLabel("Speed Of Dots: " + 0);
		dotSpeedLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

		dotSpeedPanel = new JPanel();
		dotSpeedPanel.add(dotSpeedSlider);
		dotSpeedPanel.add(dotSpeedLabel);

		add(dotSpeedPanel, BorderLayout.SOUTH);

		setBackground(Color.black);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		timer.start();
	}

	
	
	// -----------------------------------------------------------------
	// Draws all of the squares stored in the list.
	// -----------------------------------------------------------------
	public void paintComponent(Graphics page) {

		super.paintComponent(page);

		for (Point spot : pointList) { // Keeps the squares the same color

			page.setColor(new Color(randomRGB[pointList.indexOf(spot)][0], randomRGB[pointList.indexOf(spot)][1],
					randomRGB[pointList.indexOf(spot)][2], randomRGB[pointList.indexOf(spot)][3]));

			page.fillOval(spot.x - SIZE, spot.y - SIZE, SIZE * 2, SIZE * 2);
		}

		page.setColor(Color.GREEN);
		page.drawString("Count: " + pointList.size(), 5, 15);
	}

	
	// -----------------------------------------------------------------
	//	0<->10 | 1<->9 | 2<->8 | 3<->7 | etc...
	// -----------------------------------------------------------------
	public int numberInverter(int num) {

		int inv = 10 - num;
		return inv;
	}
	
	
	// -----------------------------------------------------------------
	//	0<->10 | 1<->9 | 2<->8 | 3<->7 | etc...
	// -----------------------------------------------------------------
	public class SlideListener implements ChangeListener {

		private int timerDelay;

		public void stateChanged(ChangeEvent event) {
			
			if(dotSpeedSlider.getValue() == 0) {
				
				timerDelay = 10;
				timer.setDelay(timerDelay);
				dotSpeedLabel.setText("Speed Of Dots: " + dotSpeedSlider.getValue());
				
			} else {
				
				timerDelay = numberInverter(dotSpeedSlider.getValue());
				timer.setDelay(timerDelay);
				dotSpeedLabel.setText("Speed Of Dots: " + dotSpeedSlider.getValue());
			}
		}
	}

	
	
	// --------------------------------------------------------------
	// Represents the listener for mouse events.
	// --------------------------------------------------------------
	private class SquaresListener implements ActionListener, MouseListener, MouseMotionListener, MouseWheelListener {

		// --------------------------------------------------------------
		// Adds the current point to the list of points and redraws
		// the panel whenever the mouse button is pressed.
		// --------------------------------------------------------------
		public void actionPerformed(ActionEvent event) {

			for (Point spot : pointList) { // assigns a random X&Y values

				spot.x += randomXY[pointList.indexOf(spot)][0];
				spot.y += randomXY[pointList.indexOf(spot)][1];

				if (spot.x <= 0 + SIZE || spot.x >= WIDTH - SIZE)
					randomXY[pointList.indexOf(spot)][0] *= -1; // Boundary Checker

				if (spot.y <= 0 + SIZE || spot.y >= HEIGHT - (SIZE + dotSpeedPanel.getHeight()))
					randomXY[pointList.indexOf(spot)][1] *= -1;
				
				/*
				 * 
				 * if(spot.x > WIDTH || spot.y > HEIGHT || spot.x < -5 || spot.y < -5)
				 * spot.setLocation(HEIGHT/2, WIDTH/2);
				 * 
				 */


				repaint();
			}
		}

		public void mouseWheelMoved(MouseWheelEvent event) {

			int notches = event.getWheelRotation();

			if (SIZE > 0) {

				if (notches > 0)
					SIZE += 1;
				else
					SIZE -= 1;
			}
			
			if(SIZE <= 0)
				SIZE = 1;
		}

		public void mousePressed(MouseEvent event) {

			if (event.getButton() == MouseEvent.BUTTON3) {

				for (int i = 0; i < pointList.size(); i++) {

					x = event.getX();
					y = event.getY();

					repaint();
				}
			} else {

				pointList.add(event.getPoint());
				repaint();
			}

		}

		public void mouseDragged(MouseEvent event) {

			pointList.add(event.getPoint());
			repaint();
		}


		public void mouseClicked(MouseEvent event) {

			if(event.getButton() == MouseEvent.BUTTON3) {

				for(Point spot: pointList) {

					spot.x = event.getX(); spot.y = event.getY();

					repaint(); 
				}
			}
		}

		
		// --------------------------------------------------------------
		// Provide empty definitions for unused event methods.
		// --------------------------------------------------------------

		public void mouseReleased(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		public void mouseMoved(MouseEvent event) {}

	}
}