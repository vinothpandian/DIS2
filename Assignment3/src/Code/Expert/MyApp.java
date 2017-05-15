
/*
 * DIS2 - Assignment 03
 * Desktop and Windows
 *
 * Group 12:
 *    Arijit Gupta
 *    Vincentius Renaldi
 *    Vinoth Pandian Sermuga Pandian
 *
 * A program that calls WindowsSystem and creates simple window objects and
 * adds it to the Basic Window System
 *
 */

import java.awt.Color;

public class MyApp {

	public static void main(String args[]) {

		//	Get the window system object
		WindowSystem windowSystem = WindowSystem.getInstance();

		// Create simple window A and add it to window system
		SimpleWindow simpleWindowA = new SimpleWindow(0.1,0.1,200,200,"Window A");
		simpleWindowA.color = Color.lightGray;
		windowSystem.add(simpleWindowA);

		// Create simple window B and add it to window system
		SimpleWindow simpleWindowB = new SimpleWindow(0.2,0.2,300,200,"Window B");
		simpleWindowB.color = Color.lightGray;
		windowSystem.add(simpleWindowB);

		// Create simple window C and add it to window system
		SimpleWindow simpleWindowC = new SimpleWindow(0.3,0.3,200,300,"Window C");
		simpleWindowC.color = Color.lightGray;
		windowSystem.add(simpleWindowC);
	}
}
