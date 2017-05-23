

/**
 * WindowManager class which adds a titlebar and a close button to all windows.
 * Shows a titlebar and close button for each window.
 * Allows the user to move a window by dragging it around.
 * Allows the user to close a window by clicking on the close button.
 */

import java.awt.Color;

public class WindowManager {

    //  Instance of window manager class
    private static WindowManager windowManager;

    //  Instance of window system class
    private static WindowSystem windowSystem = WindowSystem.getInstance();

    //  Active window object stores the simplewindow and the window decoration of the top most window
    DecoratedWindow activeWindow;

    //  Stores the position of the mouse click
    Dimension initialMousePosition;

    Dimension beforeMax;

    //  Allows to create only one instance of the window manager class
    public static WindowManager getInstance() {
        if (windowManager == null) {
            windowManager = new WindowManager();
        }
        return windowManager;
    }

    //  Checks whether the mouse drag moves out of the window system
    public boolean isBounded(Dimension point) {
        if ((0 <= point.getDoubleX()
                && 1.0 >= point.getDoubleX())
                && (0 <= point.getDoubleY()
                && 1.0 >= point.getDoubleY())) {
            return true;
        }
        return false;
    }


    //  Mouse handler for mouse drag event (Currently handles moving a window)
    public void handleMouseDrag(Dimension drag) {
        //  Checks whether the mouse pointer is inside the window system
        if (isBounded(drag)) {
            //  Calls to move the window
            moveWindow(drag);
        }
    }

    //  Moves the window along with its titlebar
    private void moveWindow(Dimension drag) {
        /*  Checks whether a window is active and its initial position and mouse pointer's initial position is set
        before  starting the move event*/
        if (activeWindow != null && activeWindow.simpleWindow.initial != null && initialMousePosition != null) {
            /*  Gets the current mouse position and subtracts initial mouse position, then adds the result to
                the initial window position to get realtime movement of window*/

            activeWindow.simpleWindow.moveBox(
                    drag.getDoubleX() - initialMousePosition.getDoubleX(),
                    drag.getDoubleY() - initialMousePosition.getDoubleY());

            activeWindow.windowDecoration.reposition(activeWindow.simpleWindow.initial.getDoubleX() + drag.getDoubleX() - initialMousePosition.getDoubleX(),
                    activeWindow.simpleWindow.initial.getDoubleY() + drag.getDoubleY() - initialMousePosition.getDoubleY());

            //  calls window system for repainting the window system
            windowSystem.requestRepaint();
        }
    }


    //  Handles the click event on the title bar
    public void handleTitleBarPress(DecoratedWindow decoratedWindow, Dimension click) {
        windowManager.bringToFront(decoratedWindow);
        initializeActiveWindow(decoratedWindow, click);
    }

    //  Assigns the simple window from parameter and assigns it as active also stores the mouse click for mouse drag
    private void initializeActiveWindow(DecoratedWindow decoratedWindow, Dimension click) {

        //  assigns the active window
        activeWindow = decoratedWindow;
        //  sets the current active window position for calculations in mouse drag
        activeWindow.simpleWindow.setInitialPosition();
        //  sets the initial mouse position for calculations in mouse drag
        initialMousePosition = click;
    }

    //  Decorates the active window
    protected void decorateActiveWindow(DecoratedWindow activeWindow) {
        activeWindow.windowDecoration.titlebar.color = Color.gray;
        activeWindow.windowDecoration.addBorder(activeWindow.simpleWindow.start, activeWindow.simpleWindow.end);
    }

    /*  Brings the selected window to the top of the linked list by removing it from current position and pushing it to
        last*/
    protected void bringToFront(DecoratedWindow decoratedWindow) {
        //  Remove the window from the linked list
        removeActiveWindowDecoration(decoratedWindow);
        windowSystem.decoratedWindows.remove(decoratedWindow);
        //  Add the selected window as the last element of linked list
        windowSystem.decoratedWindows.addLast(decoratedWindow);
        //  calls window system for repainting the window system
        windowSystem.requestRepaint();
    }

    //  Handles the mouse release button by resetting all the values
    public void handleMouseRelease(Dimension click) {
        //  resets the color
        if (activeWindow != null){
            activeWindow.simpleWindow.setInitialPosition();
            removeActiveWindowDecoration(activeWindow);
        }
        activeWindow = null;

        initialMousePosition = null;

    }

    //  Removes the window decoration of active window
    protected void removeActiveWindowDecoration(DecoratedWindow activeWindow) {
        activeWindow.windowDecoration.removeBorder();
        activeWindow.windowDecoration.reset();
    }

    //  Creates a decorated window
    public void createDecoratedWindow(SimpleWindow simpleWindow) {
        windowSystem.decoratedWindows.add(new DecoratedWindow(simpleWindow, new WindowDecoration(
                simpleWindow.start.getDoubleX(), simpleWindow.start.getDoubleY(),
                simpleWindow.end.getDoubleX(), simpleWindow.end.getDoubleY(), simpleWindow.title)));
    }

//      //  Handles the window maximise button /*NOT IMPLEMENTED YET*/
//    public void handleMaximise(DecoratedWindow decoratedWindow){
//        bringToFront(decoratedWindow);
//        SimpleWindow sw = decoratedWindow.simpleWindow;
//        WindowDecoration wd = decoratedWindow.windowDecoration;
//
//        if (sw.end.getDoubleX() - sw.start.getDoubleX() != 1.0) {
//            beforeMax = new Dimension(sw.start.getDoubleX(), sw.start.getDoubleY());
//            sw.resizeBox(0, wd.titlebarSize, 1, 1);
//            wd.maximise();
//        } else {
//            sw.move(beforeMax.getDoubleX(),beforeMax.getDoubleY());
//            sw.recalculateDimensions();
//            wd.reposition(sw.start.getDoubleX(), sw.start.getDoubleY());
//        }
//
//        windowSystem.requestRepaint();
//    }
}
