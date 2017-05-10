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
 * A WindowSystem which handles drawing in a resolution-independent way, and
 * performs a draw line method.
 *
 */

import de.rwth.hci.Graphics.GraphicsEventSystem;

import java.awt.*;
import java.util.LinkedList;

/* Create a Window System class extending the GES jar file */
public class WindowSystem extends GraphicsEventSystem {

    // Create Linked list for handling simple windows
    LinkedList<SimpleWindow> simpleWindows = new LinkedList<SimpleWindow>();
    WindowManager windowManager;
    //  Create a Linked list for handling the lines from drawLine method
    // Set width and height values for the window initiation
    private int width, height;

    // Constructor for the Windows System with width and height parameter
    public WindowSystem(int width, int height) {
        super(width, height);

        this.width = width;
        this.height = height;
    }

    //  Empty constructor will call the parameterised constructor and set width 600 and height 400
    public WindowSystem() {
        this(600, 400);
    }

    //  Convert the width value from the abstract coordinate system to window coordinate system
    private int convertWidth(double coordX) {
        return (int) (coordX * width);
    }

    private double getWidth(double coordX) {
        return coordX / width;
    }

    //  Convert the height value from the abstract coordinate system to window coordinate system
    private int convertHeight(double coordY) {
        return (int) (coordY * height);
    }

    private double getHeight(double coordY) {
        return coordY / height;
    }

    public void addWindow(SimpleWindow simpleWindow) {
        simpleWindows.add(simpleWindow);
    }

    //  Handle paint method which handles the draw operations of window system
    @Override
    protected void handlePaint() {
        //  set the color of the line
        setColor(Color.gray);
        //  loop through all the lines from line linked list and draw the lines on windowsystem
        for (SimpleWindow simpleWindow : simpleWindows) {
            drawWindow(simpleWindow);
        }

    }

    private void drawWindow(SimpleWindow simpleWindow) {
        setColor(Color.white);

        if (simpleWindow.positionX <= 0 || simpleWindow.positionY <= 0.02) {
            simpleWindow.positionX = 0;
            simpleWindow.positionY = 0.02;
        }

        if (simpleWindow.positionX == 1.0f || simpleWindow.positionY == 1.0f) {
            simpleWindow.positionX -= 0.1f;
            simpleWindow.positionY -= 0.1f;
        }


        double startX = simpleWindow.positionX;
        double startY = simpleWindow.positionY;
        double endX = startX + getWidth(simpleWindow.width);
        double endY = startY + getHeight(simpleWindow.height);


        windowManager = new WindowManager(startX, startY, endX, endY);

        setColor(Color.red);
        fillRect(convertWidth(windowManager.container.startX), convertHeight(windowManager.container.startY), convertWidth(windowManager.container.endX), convertHeight(windowManager.container.endY));

        setColor(Color.white);
        drawString(simpleWindow.title,convertWidth(windowManager.title.startX),convertHeight(windowManager.title.startY));

        setColor(Color.blue);
        fillRect(convertWidth(windowManager.closeButton.startX), convertHeight(windowManager.closeButton.startY), convertWidth(windowManager.closeButton.endX), convertHeight(windowManager.closeButton.endY));

        setColor(Color.white);
        drawString("X",convertWidth(windowManager.closeMark.startX),convertHeight(windowManager.closeMark.startY));

        setColor(Color.black);
        fillRect(convertWidth(startX), convertHeight(startY), convertWidth(endX), convertHeight(endY));
    }

    @Override
    public void handleMouseClicked(int i, int i1) {
        super.handleMouseClicked(i, i1);
        simpleWindows.get(1).move(getWidth(i), getHeight(i1));
        requestRepaint();
    }

}
