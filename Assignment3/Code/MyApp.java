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
		WindowSystem ws = new WindowSystem(1024, 768);
		SimpleWindow windowA = new SimpleWindow(200,200,"Window A");
        ws.addWindow(windowA);
        SimpleWindow windowB = new SimpleWindow(0.4f, 0.4f,200,200,"Window B");
        ws.addWindow(windowB);
        SimpleWindow windowC = new SimpleWindow(0.8f,0.8f,300,300,"Window C");
        ws.addWindow(windowC);
	}
}
