package lab2;

// ******************************************************************
// CirclePanel.java
// Caleb Phillips
// Chapter 11, Lab #2
// 10/19/18 - 10/20/18
//
// A panel with a circle drawn in the center and buttons on the
// bottom that move the circle.
// ******************************************************************

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CirclePanel extends JPanel {
	private final int CIRCLE_SIZE = 50;
	private int x, y, h;
	private Color c;

	JButton right, left, up, down;
	JPanel buttonPanel;

	// ---------------------------------------------------------------
	// Set up circle and buttons to move it.
	// ---------------------------------------------------------------
	public CirclePanel(int width, int height) {
		// Set coordinates so circle starts in middle
		x = (width / 2) - (CIRCLE_SIZE / 2);
		y = (height / 2) - (CIRCLE_SIZE / 2);
		c = Color.green;

		// Need a border layout to get the buttons on the bottom
		this.setLayout(new BorderLayout());

		// Create buttons to move the circle
		left = new JButton("Left");
		right = new JButton("Right");
		up = new JButton("Up");
		down = new JButton("Down");

		left.setMnemonic('l');
		right.setMnemonic('r');
		up.setMnemonic('u');
		down.setMnemonic('d');

		left.setToolTipText("Move Circle Left (alt + l)");
		right.setToolTipText("Move Circle Right (alt + r)");
		up.setToolTipText("Move Circle Up (alt + u)");
		down.setToolTipText("Move Circle Down (alt + d)");

		// Add listeners to the buttons || x > (0 + CIRCLE_SIZE/2)
		left.addActionListener(new MoveListener(-25, 0));
		right.addActionListener(new MoveListener(25, 0));
		up.addActionListener(new MoveListener(0, -25));
		down.addActionListener(new MoveListener(0, 25));

		// Need a panel to put the buttons on or they'll be on
		// top of each other.
		buttonPanel = new JPanel();
		buttonPanel.add(up);
		buttonPanel.add(down);
		buttonPanel.add(left);
		buttonPanel.add(right);

		// Add the button panel to the bottom of the main panel
		this.add(buttonPanel, "South");
		
		h = height;
	}

	// ----------------------------------------------------------------
	// Draw circle on CirclePanel
	// ----------------------------------------------------------------
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		page.setColor(c);
		page.fillOval(x, y, CIRCLE_SIZE, CIRCLE_SIZE);

		if (x <= 0) {
			left.setEnabled(false);
		} else {
			left.setEnabled(true);
		}

		if (x >= 400 - CIRCLE_SIZE) {
			right.setEnabled(false);
		} else {
			right.setEnabled(true);
		}

		if (y >= h - (buttonPanel.getHeight() + CIRCLE_SIZE)) {
			down.setEnabled(false);
		} else {
			down.setEnabled(true);
		}

		if (y <= 0) {
			up.setEnabled(false);
		} else {
			up.setEnabled(true);
		}

	}

	// ----------------------------------------------------------------
	// Class to listen for button clicks that move circle.
	// ----------------------------------------------------------------
	private class MoveListener implements ActionListener {
		private int dx;
		private int dy;

		// ----------------------------------------------------------------
		// Parameters tell how to move circle at click.
		// ----------------------------------------------------------------
		public MoveListener(int dx, int dy) {
			this.dx = dx;
			this.dy = dy;
		}

		// ----------------------------------------------------------------
		// Change x and y coordinates and repaint.
		// ----------------------------------------------------------------
		public void actionPerformed(ActionEvent e) {
			x += dx;
			y += dy;

			repaint();
		}
	}
}