package Code.Expert;

/*
 * DIS2 - Assignment 02
 * Desktop and Windows - Expert Question
 *
 * Group 12:
 *    Arijit Gupta
 *    Vincentius Renaldi
 *    Vinoth Pandian Sermuga Pandian
 *
 * A custom widget that extends JComponent.
 * A line will be drawn and its length can be modified by dragging the mouse up - to make it longer,
 * or dragging the mouse down - to make it shorter.
 *
 * Based on oracle documentation (Performing Custom Painting)
 * http://docs.oracle.com/javase/tutorial/uiswing/painting/index.html
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExtraCreditApp extends JComponent {

	public static void main(String[] args) {
		// construct GUI on EDT (Event Dispatch Thread)
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {

		// create frame and set close attribute
		JFrame f = new JFrame("Task 3");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// add panel as a custom area to draw
		f.add(new MyPanel());
		f.pack();

		// set frame as visible
		f.setVisible(true);
	}
}

class MyPanel extends JPanel {
	// panel class

	// starting coordinates of the line
	private int lineStartX = 50;
	private int lineStartY = 175;

	// ending coordinates of the line
	private int lineEndX = 200;
	private int lineEndY = 175;

	// ending x coordinate of the line after finish dragging the mouse
	private int oldEndX = 200;

	// detect mouse movement (vertically)
	private int pressedY = 0;
	private int draggedY = 0;

	public MyPanel() {
		// set border color of the panel
		setBorder(BorderFactory.createLineBorder(Color.black));

		// mouse listener (mouse button pressed)
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// starting y coordinate of the mouse before it is
				// dragged
				pressedY = e.getY();
			}
		});

		// mouse listener (mouse button released)
		addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				// reset vertical movement
				pressedY = 0;
				draggedY = 0;

				// save current ending x coordinate of the line
				oldEndX = lineEndX;
			}
		});

		// mouse listener (mouse dragged)
		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				// get y coordinate of the mouse (while dragging)
				draggedY = e.getY();

				// calculate ending x coordinate of the line
				lineEndX = oldEndX + pressedY - draggedY;

				// repaint the panel (drawing area)
				repaint();
			}
		});
	}

	public Dimension getPreferredSize() {
		// set the dimension of the panel
		return new Dimension(350, 350);
	}

	public void paintComponent(Graphics g) {
		// pass graphics context, paint panel's background
		super.paintComponent(g);

		//validate line width (not going to left direction)
		if (lineEndX < 50) {
			lineEndX = 50;
		}

		// draw the line and set its color to red
		g.setColor(Color.RED);
		g.drawLine(lineStartX, lineStartY, lineEndX, lineEndY);
	}
}
