

/*
 * DIS2 - Assignment 02
 * Desktop and Windows
 *
 * Group 12:
 *    Arijit Gupta
 *    Vincentius Renaldi
 *    Vinoth Pandian Sermuga Pandian
 *
 * A WindowSystem which handles drawing in a resolution-independent way,
 * Applications can make use of your window system class, and the windows are displayed on
 * the screen.
 *
 */

import de.rwth.hci.Graphics.GraphicsEventSystem;

import java.util.Iterator;
import java.util.LinkedList;

/* Create a Window System class extending the GES jar file */
public class WindowSystem extends GraphicsEventSystem {

    //  Creates an instance of window system
    private static WindowSystem windowSystem;
    //  Creates an instance of window manager
    private static WindowManager windowManager = WindowManager.getInstance();

    // Set width and height values for the window initiation
    int width;
    int height;
    public Dimension winDim;

    // Create Linked list for handling simple windows
    protected LinkedList<DecoratedWindow> decoratedWindows = new LinkedList<>();

    // Constructor for the Windows System with width and height parameter
    private WindowSystem(int width, int height) {
        super(width, height);
        this.width = width;
        this.height = height;
    }

    //  Allows to create only one instance of the window manager class
    public static WindowSystem getInstance() {
        if (windowSystem == null) {
            windowSystem = new WindowSystem(1024, 768);
            windowSystem.winDim = new Dimension(windowSystem.width, windowSystem.height);
        }
        return windowSystem;
    }


    //  Handle paint method which handles the draw operations of window system
    @Override
    protected void handlePaint() {

        //  loop through all the decorated windows from the linked list and draw the them on window system
        for (DecoratedWindow decoratedWindow : decoratedWindows) {

            SimpleWindow simpleWindow = decoratedWindow.simpleWindow;
            WindowDecoration windowDecoration = decoratedWindow.windowDecoration;

            //  Draw titlebar
            windowSystem.setColor(windowDecoration.titleBar.color);
            windowSystem.fillRect(windowDecoration.titleBar.start.getIntX(), windowDecoration.titleBar.start.getIntY(),
                    windowDecoration.titleBar.end.getIntX(), windowDecoration.titleBar.end.getIntY());

            //  Draw Title bar text (window name)
            windowSystem.setColor(windowDecoration.titleText.color);
            windowSystem.drawString(windowDecoration.titleText.text, windowDecoration.titleText.start.getIntX(),
                    windowDecoration.titleText.start.getIntY());

            //  Draw close button rectangle and its label (in this case X)
            windowSystem.setColor(windowDecoration.closeButton.color);
            windowSystem.fillRect(windowDecoration.closeButton.start.getIntX(), windowDecoration.closeButton.start.getIntY(),
                    windowDecoration.closeButton.end.getIntX(), windowDecoration.closeButton.end.getIntY());
            windowSystem.setColor(windowDecoration.closeButton.label.color);
            windowSystem.drawString(windowDecoration.closeButton.label.text, windowDecoration.closeButton.label.start.getIntX(),
                    windowDecoration.closeButton.label.start.getIntY());

            //  Draw simple window
            windowSystem.setColor(simpleWindow.color);
            windowSystem.fillRect(simpleWindow.start.getIntX(), simpleWindow.start.getIntY(), simpleWindow.end.getIntX(),
                    simpleWindow.end.getIntY());

            //  Draw border for window
            windowSystem.setColor(windowDecoration.border.color);
            windowSystem.drawRect(windowDecoration.border.start.getIntX(), windowDecoration.border.start.getIntY(),
                    windowDecoration.border.end.getIntX(), windowDecoration.border.end.getIntY());

        }
    }


    /* Sends a simple window to window manager and gets back the window decoration.
        Stores both the simple window and the window decoration in the decorated window data structure*/
    public void add(SimpleWindow simpleWindow) {
        simpleWindow.recalculateDimensions();
        decoratedWindows.add(new DecoratedWindow(simpleWindow, windowManager.createDecoratedWindow(simpleWindow)));
    }

    //  Removes the decorated window from the linked list
    public void remove(DecoratedWindow decoratedWindow) {
        decoratedWindows.remove(decoratedWindow);
        windowSystem.requestRepaint();
    }

    /*  Override mouse click handler from Graphic Event Library and find which application is being affected by the
        event. Send the mouse handler event to the application*/
    @Override
    public void handleMouseClicked(int i, int i1) {
        super.handleMouseClicked(i, i1);
        Dimension click = new Dimension(i, i1);
        click.convertToDouble();

        DecoratedWindow decoratedWindow;

        Iterator<DecoratedWindow> it = decoratedWindows.descendingIterator();
        // Loop through all decorated windows to find which window has been affected
        while (it.hasNext()) {
            decoratedWindow = it.next();

            //  If close button is being clicked then ask window manager to verify and remove window
            if (decoratedWindow.windowDecoration.closeButton.contains(click)) {
                windowManager.handleCloseButtonClick(decoratedWindow, click);
                break;
            }
        }
    }


    /*  Override mouse release handler from Graphic Event Library and find which application is being affected by the
        event. Send the mouse handler event to the application*/
    @Override
    public void handleMouseReleased(int i, int i1) {
        super.handleMousePressed(i, i1);
        Dimension click = new Dimension(i, i1);
        click.convertToDouble();
        //  Forward the mouse release event to window manager
        windowManager.handleMouseRelease(click);
    }


    /*  Override mouse drag handler from Graphic Event Library and find which application is being affected by the
        event. Send the mouse handler event to the application*/
    @Override
    public void handleMouseDragged(int i, int i1) {
        super.handleMouseDragged(i, i1);
        Dimension click = new Dimension(i, i1);
        click.convertToDouble();
        //  forward the mouse dragged event to window manager
        windowManager.handleMouseDrag(click);
    }

    /*  Override mouse moved handler from Graphic Event Library and find which application is being affected by the
        event. Send the mouse handler event to the application*/
    @Override
    public void handleMouseMoved(int i, int i1) {
        super.handleMouseMoved(i, i1);
    }

    /*  Override mouse pressed handler from Graphic Event Library and find which application is being affected by the
        event. Send the mouse handler event to the application*/
    @Override
    public void handleMousePressed(int i, int i1) {
        super.handleMousePressed(i, i1);
        Dimension click = new Dimension(i, i1);
        click.convertToDouble();

        DecoratedWindow decoratedWindow;

        Iterator<DecoratedWindow> it = decoratedWindows.descendingIterator();

        // Loop through all decorated windows to find which window has been affected
        while (it.hasNext()) {
            decoratedWindow = it.next();

            //  If a certain window is clicked within its border, call window manager to bring it as active window
            if (decoratedWindow.windowDecoration.border.contains(click)) {
                windowManager.bringToFront(decoratedWindow);
                /*  if the close button is being pressed then do nothing as it is handled by mouse click and not
                    mouse pressed*/
                if (decoratedWindow.windowDecoration.closeButton.contains(click)) {
                    break;
                }
                //  if the border edge is being clicked then call window manager to resize the window
                if (decoratedWindow.windowDecoration.border.onEdge(click)){
                    // RESIZE WINDOW NOT IMPLEMENTED YET
                }
                //  If window titlebar is being clicked then call window manager to handle the event
                if (decoratedWindow.windowDecoration.titleBar.contains(click)) {
                    windowManager.handleTitleBarClick(decoratedWindow, click);
                    break;
                }
                break;
            }
        }


    }


}
