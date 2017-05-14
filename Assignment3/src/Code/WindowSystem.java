package Code;/*
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

    private static WindowSystem windowSystem;
    private static WindowManager windowManager = WindowManager.getInstance();

    // Set width and height values for the window initiation
    public Dimension winDim;

    // Create Linked list for handling simple windows
    LinkedList<SimpleWindow> simpleWindows = new LinkedList<SimpleWindow>();

    // Constructor for the Windows System with width and height parameter
    private WindowSystem(int width, int height) {
        super(width, height);
        winDim = new Dimension(width,height);
    }

    public static WindowSystem getInstance(){
        if(windowSystem == null){
            windowSystem = new WindowSystem(1024,768);
        }
        return windowSystem;
    }



    //  Handle paint method which handles the draw operations of window system
    @Override
    protected void handlePaint() {
        //  loop through all the lines from line linked list and draw the lines on windowsystem
        windowManager.draw();
    }


    public void add(SimpleWindow simpleWindow) {
        simpleWindow.calculateDimensions(winDim);
        simpleWindows.add(simpleWindow);
        windowManager.add(simpleWindow);
    }

    @Override
    public void handleMouseClicked(int i, int i1) {
        super.handleMouseClicked(i, i1);
        Dimension click = new Dimension(i,i1);
        click.convertToDouble(winDim);
        windowManager.handleMouseClick(click);
    }


    @Override
    public void handleMouseDragged(int i, int i1) {
        super.handleMouseDragged(i, i1);
        Dimension click = new Dimension(i,i1);
        click.convertToDouble(winDim);
        windowManager.handleMouseDrag(click);
    }
}
