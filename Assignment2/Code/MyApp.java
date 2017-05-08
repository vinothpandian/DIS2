/*
 * DIS2 - Assignment 02
 * Desktop and Windows
 *
 * Group 12:
 *    Arijit Gupta
 *    Vincentius Renaldi
 *    Vinoth Pandian Sermuga Pandian
 *
 * A program that calls WindowsSystem and draws a line
 */

public class MyApp {

	public static void main(String args[]) {
		// calls WindowsSystem class and specify the window's size
		WindowSystem ws = new WindowSystem(800, 600);

		// draw a line start from (0.2, 0.3) and end at (0.8, 07)
		ws.drawLine(0.2f, 0.3f, 0.8f, 0.7f);
	}
}
