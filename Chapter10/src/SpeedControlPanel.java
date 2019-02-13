// ******************************************************************
//	SpeedControlPanel.java
//	Caleb Phillips
//	Chapter 10, Lab #2
//	10/1/18 - 10/4/18
//
//	The panel for the bouncing ball. Similar to
// 	ReboundPanel.java in Listing 8.16 in the text, except a circle
// 	rather than a happy face is rebounding off the edges of the
// 	window.
// ******************************************************************


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class SpeedControlPanel extends JPanel {
	
	private final int WIDTH = 600;
	private final int HEIGHT = 400;
	private final int BALL_SIZE = 50;
	private final int INITIAL_DELAY = 30;
	private int moveX, moveY; // increment to move each time
	private Circle bouncingBall; // the object that moves
	private Timer timer;
	private JPanel sliderPanel;
	private JLabel timerDelayLabel;
	private JSlider speedSlider;
	
	
	// --------------------------------------------
	// Sets up the panel, including the timer
	// for the animation
	// --------------------------------------------
	public SpeedControlPanel() {
		
		timer = new Timer(INITIAL_DELAY, new ReboundListener());
		
		this.setLayout(new BorderLayout());
		
		bouncingBall = new Circle(BALL_SIZE);
		moveX = moveY = 5;
		
		speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 200, INITIAL_DELAY);
		speedSlider.setMajorTickSpacing(40);
		speedSlider.setMinorTickSpacing(10);
		speedSlider.setPaintTicks(true);
		speedSlider.setPaintLabels(true);
		speedSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

		SlideListener listener = new SlideListener();
		speedSlider.addChangeListener(listener);

		timerDelayLabel = new JLabel("Timer Delay: " + INITIAL_DELAY);
		timerDelayLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

		sliderPanel = new JPanel();
		BorderLayout layout = new BorderLayout();
		sliderPanel.add(speedSlider);
		sliderPanel.add(timerDelayLabel);

		add(sliderPanel, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.black);
		
		timer.start();
	}

	
	// ---------------------
	// Draw the ball
	// ---------------------
	public void paintComponent(Graphics page) {
		
		super.paintComponent(page);
		bouncingBall.draw(page);
	}

	
	// ***************************************************
	// An action listener for the timer
	// ***************************************************
	public class ReboundListener implements ActionListener {
		
		// ----------------------------------------------------
		// actionPerformed is called by the timer -- it updates
		// the position of the bouncing ball
		// ----------------------------------------------------
		public void actionPerformed(ActionEvent action) {
			
			int slidePanelHt = sliderPanel.getSize().height;
			
			bouncingBall.move(moveX, moveY);
			
			int x = bouncingBall.getX();
			int y = bouncingBall.getY();
			
			// change direction if ball hits a side
			if (x < 0 || x >= WIDTH - BALL_SIZE)
				moveX = moveX * -1;
			if (y <= 0 || y >= HEIGHT - (BALL_SIZE + slidePanelHt))
				moveY = moveY * -1;
			
			repaint();
		}
	}

	
	// ***************************************************
	// A change listener for the slider.
	// ***************************************************
	private class SlideListener implements ChangeListener {
		
		private int timerDelay;
		
		// ------------------------------------------------
		// Called when the state of the slider has changed;
		// resets the delay on the timer.
		// ------------------------------------------------
		public void stateChanged(ChangeEvent event) {
			
			timerDelay = speedSlider.getValue();
			timer.setDelay(timerDelay);
			timerDelayLabel.setText("Timer Delay: " + timerDelay);
		}
	}
}