package Code;

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
		WindowSystem ws = new WindowSystem(1366, 768);
		SimpleWindow windowA = new SimpleWindow(100,100,"Window A");
        ws.addWindow(windowA);
        SimpleWindow windowB = new SimpleWindow(0.4f, 0.4f,200,200,"Window B");
        ws.addWindow(windowB);
        SimpleWindow windowC = new SimpleWindow(0.8f,0.8f,50,50,"Window C");
        ws.addWindow(windowC);

	}
}
