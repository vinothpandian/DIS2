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

import sun.java2d.pipe.SpanShapeRenderer;

import java.awt.Color;

public class MyApp {

	public static void main(String args[]) {

		//	Get the window system object
		WindowSystem windowSystem = WindowSystem.getInstance();

		// Create simple window A and add it to window system
//		windowSystem.createSimpleWindow(0.1,0.1,0.3,0.3, "Window A");
//
//		// Create simple window B and add it to window system
//		windowSystem.createSimpleWindow(0.2,0.2,0.4,0.4, "Window B");

		// Create simple window C and add it to window system
		SimpleWindow sw = windowSystem.createSimpleWindow(0.3,0.3,0.6,0.6, "Window C");

		sw.addListener(new RATmouseListener() {

			@Override
			public void mouseClicked(Dimension click, RATmouseEvent event) {
				System.out.println("AWESOME");
			}

			@Override
			public void mousePressed(Dimension click, RATmouseEvent event) {

			}

			@Override
			public void mouseReleased(Dimension click, RATmouseEvent event) {

			}

			@Override
			public void mouseMoved(Dimension click, RATmouseEvent event) {

			}

			@Override
			public void mouseDragged(Dimension click, RATmouseEvent event) {

			}
		});

	}
}
