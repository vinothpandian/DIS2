package Code;
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

public class MyApp {

	public static void main(String args[]) {

		//	Get the window system object
		WindowSystem windowSystem = WindowSystem.getInstance();


		// Create simple window A and add it to window system
		windowSystem.createSimpleWindow(0.1,0.1,0.3,0.3, "Window A");

		// Create simple window B and add it to window system
		windowSystem.createSimpleWindow(0.2,0.2,0.4,0.4, "Window B");

		// Create simple window C and add it to window system
		windowSystem.createSimpleWindow(0.3,0.3,0.6,0.6, "Window C");


	}
}
