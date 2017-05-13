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

import java.awt.Color;
import java.util.LinkedList;

/* Create a Window System class extending the GES jar file */
public class WindowSystem extends GraphicsEventSystem {

    // Create Linked list for handling simple windows
    LinkedList<SimpleWindow> simpleWindows = new LinkedList<SimpleWindow>();
    WindowManager windowManager;
    //  Create a Linked list for handling the lines from drawLine method
    // Set width and height values for the window initiation
    Dimension winDim;

    // Constructor for the Windows System with width and height parameter
    public WindowSystem(int width, int height) {
        super(width, height);
        winDim = new Dimension(width, height);
    }

    //  Empty constructor will call the parameterised constructor and set width 600 and height 400
    public WindowSystem() {
        this(600, 400);
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

            windowManager = new WindowManager(simpleWindow, winDim);
            checkBound(simpleWindow, windowManager.titlebarSize);

            Dimension start = new Dimension(windowManager.titleBar.startX, windowManager.titleBar.startY);
            start.convertPixels(winDim);
            Dimension end = new Dimension(windowManager.titleBar.endX, windowManager.titleBar.endY);
            end.convertPixels(winDim);

            setColor(Color.darkGray);
            fillRect(start.getPixelX(), start.getPixelY(),end.getPixelX(), end.getPixelY());

            setColor(Color.white);
            start.setAbstractX(windowManager.titleText.startX);
            start.setAbstractY(windowManager.titleText.startY);
            start.convertPixels(winDim);
            drawString(windowManager.titleText.text, start.getPixelX(), start.getPixelY());

            setColor(Color.red);
            start.setAbstractX(windowManager.closeButton.startX);
            start.setAbstractY(windowManager.closeButton.startY);
            start.convertPixels(winDim);
            end.setAbstractX(windowManager.closeButton.endX);
            end.setAbstractY(windowManager.closeButton.endY);
            end.convertPixels(winDim);
            fillRect(start.getPixelX(), start.getPixelY(),end.getPixelX(), end.getPixelY());

            start.setAbstractX(windowManager.closeButton.label.startX);
            start.setAbstractY(windowManager.closeButton.label.startY);
            start.convertPixels(winDim);
            setColor(Color.white);
            drawString(windowManager.closeButton.label.text, start.getPixelX(), start.getPixelY());

            drawSimpleWindow(simpleWindow);
        }
    }

    private void checkBound(SimpleWindow simpleWindow, double bound) {
        if (simpleWindow.positionX <= 0 || simpleWindow.positionY <= bound) {
            simpleWindow.positionX = 0;
            simpleWindow.positionY = bound;
        }

        if (simpleWindow.positionX == 1.0f || simpleWindow.positionY == 1.0f) {
            simpleWindow.positionX -= 0.1f;
            simpleWindow.positionY -= 0.1f;
        }
    }

    private void drawSimpleWindow(SimpleWindow simpleWindow) {
        Dimension appStart = new Dimension(simpleWindow.positionX, simpleWindow.positionY);

        appStart.convertPixels(winDim);
        Dimension appEnd = new Dimension(appStart.getPixelX()+simpleWindow.width, appStart.getPixelY()+simpleWindow.height);

        setColor(Color.lightGray);
            fillRect(appStart.getPixelX(), appStart.getPixelY(), appEnd.getPixelX(), appEnd.getPixelY());
    }
//
//    private void drawWindow(SimpleWindow simpleWindow) {
//        windowManager = new WindowManager(startX, startY, endX, endY);
//
//        setColor(Color.red);
//        fillRect(convertWidth(windowManager.container.startX), convertHeight(windowManager.container.startY), convertWidth(windowManager.container.endX), convertHeight(windowManager.container.endY));
//
//        setColor(Color.white);
//        drawString(simpleWindow.title,convertWidth(windowManager.title.startX),convertHeight(windowManager.title.startY));
//
//        setColor(Color.blue);
//        fillRect(convertWidth(windowManager.closeButton.startX), convertHeight(windowManager.closeButton.startY), convertWidth(windowManager.closeButton.endX), convertHeight(windowManager.closeButton.endY));
//
//        setColor(Color.white);
//        drawString("X",convertWidth(windowManager.closeMark.startX),convertHeight(windowManager.closeMark.startY));
//    }

    @Override
    public void handleMouseClicked(int i, int i1) {
        super.handleMouseClicked(i, i1);
        Dimension position = new Dimension(i,i1);
        position.convertAbstract(winDim);

        requestRepaint();
    }

}
