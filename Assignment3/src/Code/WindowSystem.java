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
import java.util.Iterator;
import java.util.LinkedList;

/* Create a Window System class extending the GES jar file */
public class WindowSystem extends GraphicsEventSystem {

    private static WindowSystem windowSystem;
    private static WindowManager windowManager = WindowManager.getInstance();

    // Set width and height values for the window initiation
    public Dimension winDim;

    // Create Linked list for handling simple windows
    protected LinkedList<DecoratedWindow> decoratedWindows = new LinkedList<>();

    // Constructor for the Windows System with width and height parameter
    private WindowSystem(int width, int height) {
        super(width, height);
        winDim = new Dimension(width, height);
    }

    public static WindowSystem getInstance() {
        if (windowSystem == null) {
            windowSystem = new WindowSystem(1024, 768);
        }
        return windowSystem;
    }


    //  Handle paint method which handles the draw operations of window system
    @Override
    protected void handlePaint() {
        //  loop through all the lines from line linked list and draw the lines on windowsystem

        for (DecoratedWindow decoratedWindow : decoratedWindows) {

            SimpleWindow simpleWindow = decoratedWindow.simpleWindow;
            WindowDecoration windowDecoration = decoratedWindow.windowDecoration;

            windowSystem.setColor(windowDecoration.titleBar.color);
            windowSystem.fillRect(windowDecoration.titleBar.start.getIntX(), windowDecoration.titleBar.start.getIntY(),
                    windowDecoration.titleBar.end.getIntX(), windowDecoration.titleBar.end.getIntY());

            windowSystem.setColor(windowDecoration.titleText.color);
            windowSystem.drawString(windowDecoration.titleText.text, windowDecoration.titleText.start.getIntX(),
                    windowDecoration.titleText.start.getIntY());

            windowSystem.setColor(windowDecoration.closeButton.color);
            windowSystem.fillRect(windowDecoration.closeButton.start.getIntX(), windowDecoration.closeButton.start.getIntY(),
                    windowDecoration.closeButton.end.getIntX(), windowDecoration.closeButton.end.getIntY());
            windowSystem.setColor(windowDecoration.closeButton.label.color);
            windowSystem.drawString(windowDecoration.closeButton.label.text, windowDecoration.closeButton.label.start.getIntX(),
                    windowDecoration.closeButton.label.start.getIntY());

            windowSystem.setColor(simpleWindow.color);
            windowSystem.fillRect(simpleWindow.start.getIntX(), simpleWindow.start.getIntY(), simpleWindow.end.getIntX(),
                    simpleWindow.end.getIntY());

            windowSystem.setColor(windowDecoration.border.color);
            windowSystem.drawRect(windowDecoration.border.start.getIntX(), windowDecoration.border.start.getIntY(),
                    windowDecoration.border.end.getIntX(), windowDecoration.border.end.getIntY());

        }
    }


    public void add(SimpleWindow simpleWindow) {
        simpleWindow.calculateDimensions(winDim);
        decoratedWindows.add(new DecoratedWindow(simpleWindow, windowManager.createDecoratedWindow(simpleWindow)));
    }

    public void remove(DecoratedWindow decoratedWindow) {
        decoratedWindows.remove(decoratedWindow);
        windowSystem.requestRepaint();
    }

    @Override
    public void handleMouseClicked(int i, int i1) {
        super.handleMouseClicked(i, i1);
        Dimension click = new Dimension(i, i1);
        click.convertToDouble(winDim);
        DecoratedWindow decoratedWindow;

        Iterator<DecoratedWindow> it = decoratedWindows.descendingIterator();

        while (it.hasNext()) {
            decoratedWindow = it.next();

            if (decoratedWindow.windowDecoration.closeButton.contains(click)) {
                windowManager.handleCloseButtonClick(decoratedWindow, click);
                break;
            }
        }
    }


    @Override
    public void handleMouseReleased(int i, int i1) {
        super.handleMousePressed(i, i1);
        Dimension click = new Dimension(i, i1);
        click.convertToDouble(winDim);
        windowManager.handleMouseRelease(click);
    }


    @Override
    public void handleMouseDragged(int i, int i1) {
        super.handleMouseDragged(i, i1);
        Dimension click = new Dimension(i, i1);
        click.convertToDouble(winDim);
        windowManager.handleMouseDrag(click);
    }

    @Override
    public void handleMouseMoved(int i, int i1) {
        super.handleMouseMoved(i, i1);
    }

    @Override
    public void handleMousePressed(int i, int i1) {
        super.handleMousePressed(i, i1);
        Dimension click = new Dimension(i, i1);
        click.convertToDouble(winDim);

        DecoratedWindow decoratedWindow;

        Iterator<DecoratedWindow> it = decoratedWindows.descendingIterator();

        while (it.hasNext()) {
            decoratedWindow = it.next();

            if (decoratedWindow.windowDecoration.border.contains(click)) {
                windowManager.bringToFront(decoratedWindow);
                if (decoratedWindow.windowDecoration.closeButton.contains(click)) {
                    break;
                }
                if (decoratedWindow.windowDecoration.border.onEdge(click)){
                    // RESIZE WINDOW NOT IMPLEMENTED YET
                }
                if (decoratedWindow.windowDecoration.titleBar.contains(click)) {
                    windowManager.handleTitleBarClick(decoratedWindow, click);
                    break;
                }
                break;
            }
        }


    }


}
