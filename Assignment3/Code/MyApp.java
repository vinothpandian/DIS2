package Code;/*
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

import java.awt.*;

public class MyApp {

	public static void main(String args[]) {

		WindowSystem windowSystem = WindowSystem.getInstance();

		SimpleWindow simpleWindowA = new SimpleWindow(0.1,0.1,200,200,"Window A");
		simpleWindowA.color = Color.red;
		windowSystem.add(simpleWindowA);

		SimpleWindow simpleWindowB = new SimpleWindow(0.2,0.2,300,200,"Window B");
		simpleWindowB.color = Color.green;
		windowSystem.add(simpleWindowB);

		SimpleWindow simpleWindowC = new SimpleWindow(0.3,0.3,200,300,"Window C");
		simpleWindowC.color = Color.blue;
		windowSystem.add(simpleWindowC);
	}
}
