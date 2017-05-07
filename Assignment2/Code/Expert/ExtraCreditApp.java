import java.awt.*;
import java.awt.event.*;
import java.io.Console;

import javax.swing.*;

/**
 * Created by VinothPandianSermuga on 04-05-2017.
 */
public class ExtraCreditApp extends JComponent {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		
		//generate frame
		JFrame f = new JFrame("Task 3");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add panel as a custom area to draw
		f.add(new MyPanel());
		f.pack();
		f.setVisible(true);
	}
}

class MyPanel extends JPanel {
	//custom panel class
	
	//starting coordinate of the line and its width (no height in this case, or 0)
	private int lineStartX = 175;
	private int lineStartY = 175;
	private int width = 20;
	private int height = 0;

	//to detect the mouse movement (vertically)
	private int pressedY = 0;
	private int draggedY = 0;

	public MyPanel() {
		setBorder(BorderFactory.createLineBorder(Color.black));

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				pressedY = e.getY();
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				draggedY = e.getY();
				repaintLine(e.getX(), e.getY());
			}
		});
	}

	private void repaintLine(int x, int y) {

		//repaint(lineStartX, lineStartY, lineStartX + width, height);

		// update line if mouse moved vertically
		width = pressedY - draggedY;

		//repaint(lineStartX, lineStartY, lineStartX + width, height);
		repaint();
	}

	public Dimension getPreferredSize() {
		//set the dimension of the panel
		return new Dimension(350, 350);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//draw the line and set its color to red
		g.setColor(Color.RED);
		g.drawLine(lineStartX, lineStartY, lineStartX + width, lineStartY
				+ height);
	}
}
