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
 * A WindowSystem which handles drawing in a resolution-independent way,
 * Applications can make use of your window system class, and the windows are displayed on
 * the screen.
 *
 */

import de.rwth.hci.Graphics.GraphicsEventSystem;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

/* Create a Window System class extending the GES jar file */
public class WindowSystem extends GraphicsEventSystem {

    //  Creates an instance of window system
    private static WindowSystem windowSystem;
    //  Creates an instance of window manager
    private static WindowManager windowManager =  WindowManager.getInstance();
//    private static WindowManager windowManager =  null;

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

    protected SimpleWindow createSimpleWindow(double doubleX, double doubleY, double doubleX1, double doubleY1, boolean
            decoration, String title) {
        SimpleWindow simpleWindow = new SimpleWindow(doubleX, doubleY, doubleX1, doubleY1);

        if (windowManager != null && decoration){
            windowManager.createDecoratedWindow(simpleWindow);
        } else if (windowManager == null){
            decoratedWindows.add(new DecoratedWindow(simpleWindow, null));
        }
        return simpleWindow;
    }


    public SimpleWindow createSimpleWindow(double doubleX, double doubleY, double doubleX1, double doubleY1, String
            title) {
        return this.createSimpleWindow(doubleX, doubleY, doubleX1, doubleY1, true, title);
    }

    //  Removes the decorated window from the linked list
    public void removeWindow(DecoratedWindow decoratedWindow) {
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
            if (windowManager != null){
                if (decoratedWindow.windowDecoration.closeButton.contains(click)){
                    windowSystem.removeWindow(decoratedWindow);
                    break;
                }
//                else  if(decoratedWindow.windowDecoration.maxButton.contains(click)){
//                    windowManager.handleMaximise(decoratedWindow);
//                    break;
//                }
            }
            if (decoratedWindow.simpleWindow.contains(click)){
                decoratedWindow.simpleWindow.mouseClicked(click, RATmouseEvent.CLICKED);
                windowSystem.requestRepaint();
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

        if (windowManager!=null){
            windowManager.handleMouseRelease(click);
        }
    }


    /*  Override mouse drag handler from Graphic Event Library and find which application is being affected by the
        event. Send the mouse handler event to the application*/
    @Override
    public void handleMouseDragged(int i, int i1) {
        super.handleMouseDragged(i, i1);
        Dimension click = new Dimension(i, i1);
        click.convertToDouble();

        if (windowManager!=null){
            windowManager.handleMouseDrag(click);
        }

    }

    /*  Override mouse moved handler from Graphic Event Library and find which application is being affected by the
        event. Send the mouse handler event to the application*/
    @Override
    public void handleMouseMoved(int i, int i1) {
        super.handleMouseMoved(i, i1);
        Dimension click = new Dimension(i, i1);
        click.convertToDouble();

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

            if (windowManager != null){
                windowManager.removeActiveWindowDecoration(decoratedWindows.getLast());

                if (decoratedWindow.windowDecoration.closeButton.contains(click)){
                    break;
                }
                if (decoratedWindow.windowDecoration.titlebar.contains(click)){
                    windowManager.handleTitleBarPress(decoratedWindow, click);
                    break;
                }
            }
            if (decoratedWindow.simpleWindow.contains(click)){
                if (windowManager != null) {
                    windowManager.removeActiveWindowDecoration(decoratedWindows.getLast());
                    windowManager.bringToFront(decoratedWindow);
                }

                break;
            }
        }
    }

    //  Handle paint method which handles the draw operations of window system
    @Override
    protected void handlePaint() {

        //  loop through all the decorated windows from the linked list and draw the them on window system
        for (DecoratedWindow decoratedWindow : decoratedWindows) {

            SimpleWindow simpleWindow = decoratedWindow.simpleWindow;
            WindowDecoration windowDecoration = decoratedWindow.windowDecoration;

            if (windowManager != null) {
                windowManager.decorateActiveWindow(decoratedWindows.getLast());
                decoratedWindow.windowDecoration.draw();
            }

            //  Draw simple window
            windowSystem.setColor(simpleWindow.color);
            windowSystem.fillRect(simpleWindow.start.getIntX(), simpleWindow.start.getIntY(), simpleWindow.end.getIntX(),
                    simpleWindow.end.getIntY());
            for (SimpleWindow child: simpleWindow.children){
                if (child instanceof RATbutton){
                    windowSystem.setColor(child.color);
                    windowSystem.fillRect(child.start.getIntX(), child.start.getIntY(), child.end.getIntX(),
                            child.end.getIntY());
                    windowSystem.setColor(((RATbutton) child).labelColor);
                    windowSystem.drawString(child.title, (child.start.getIntX()+child.end.getIntX())/2-((RATbutton) child).textPosition,
                            (child.start.getIntY()+child.end.getIntY())/2-((RATbutton) child).textPosition);
                } else if (child instanceof RATlabel){
                    windowSystem.setColor(((RATlabel)child).labelColor);
                    windowSystem.drawString(child.title, child.start.getIntX(), child.start.getIntY());

                }

            }

        }
    }

}