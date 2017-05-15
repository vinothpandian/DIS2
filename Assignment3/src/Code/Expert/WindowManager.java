

/**
 *  WindowManager class which adds a titlebar and a close button to all windows.
 *  Shows a titlebar and close button for each window.
 *  Allows the user to move a window by dragging it around.
 *  Allows the user to close a window by clicking on the close button.
 *
 */

import java.awt.Color;

public class WindowManager {

    //  Instance of window manager class
    private static WindowManager windowManager;

    //  Instance of window system class
    private static WindowSystem windowSystem = WindowSystem.getInstance();

    //  Active window object stores the simplewindow and the window decoration of the top most window
    DecoratedWindow activeWindow;
    //  Stores the position of the active window
    Dimension activeWindowPosition;
    //  Stores the position of the mouse click
    Dimension initialMousePosition;

    //  Allows to create only one instance of the window manager class
    public static WindowManager getInstance(){
        if(windowManager == null){
            windowManager = new WindowManager();
        }
        return windowManager;
    }

    //  Checks whether the mouse drag moves out of the window system
    public boolean isBounded(Dimension point){
        if((0 <= point.getDoubleX()
                && 1.0 >= point.getDoubleX())
                && (0 <= point.getDoubleY()
                && 1.0 >= point.getDoubleY())){
            return true;
        }
        return false;
    }


    //  Mouse handler for mouse drag event (Currently handles moving a window)
    public void handleMouseDrag(Dimension drag) {
        //  Checks whether the mouse pointer is inside the window system
        if (isBounded(drag)){
            //  Calls to move the window
            moveWindow(drag);
        }
    }

    //  Moves the window along with its titlebar
    private void moveWindow(Dimension drag) {
        /*  Checks whether a window is active and its initial position and mouse pointer's initial position is set
        before  starting the move event*/
        if (activeWindow != null && activeWindowPosition!= null && initialMousePosition != null){
            /*  Gets the current mouse position and subtracts initial mouse position, then adds the result to
                the initial window position to get realtime movement of window*/
            activeWindow.simpleWindow.start.setIntX(activeWindowPosition.getIntX()+drag.getIntX()-initialMousePosition
                    .getIntX());
            activeWindow.simpleWindow.start.setIntY(activeWindowPosition.getIntY()+drag.getIntY()-initialMousePosition
                    .getIntY());

            //  Converts the newly calculated window position to abstract coordinates
            activeWindow.simpleWindow.start.convertToDouble();
            //  Adds the title bar size to the simple window so the mouse pointer stays at current position
            activeWindow.simpleWindow.start.setDoubleY(activeWindow.simpleWindow.start.getDoubleY()
                    +activeWindow.windowDecoration.titlebarSize);
            //  Recalculates the end point of moving window
            activeWindow.simpleWindow.recalculateDimensions();
            //  Converts all the coordinates to pixels and abstract coordinates for display
            activeWindow.simpleWindow.start.convertToInt();
            activeWindow.simpleWindow.end.convertToDouble();
            activeWindow.simpleWindow.end.convertToInt();
            //  Creates a new window decoration and adds it to the simplewindow
            activeWindow.windowDecoration = new WindowDecoration(activeWindow.simpleWindow);
            //  Sets a color for the active and dragged window
            activeWindow.windowDecoration.titleBar.color = Color.gray;
            activeWindow.windowDecoration.border.color = Color.gray;

            //  calls window system for repainting the window system
            windowSystem.requestRepaint();
        }
    }

    //  Calls the window decoration class to create a new titlebar and close button
    public WindowDecoration createDecoratedWindow(SimpleWindow simpleWindow) {
        return new WindowDecoration(simpleWindow);
    }

    //  Handles the click event on the title bar
    public void handleTitleBarClick(DecoratedWindow decoratedWindow, Dimension click) {

        if (activeWindow == null){
            //  calls the function to set the active window as the selected simple window
            initializeActiveWindow(decoratedWindow,click);
        }
    }

    //  Assigns the simple window from parameter and assigns it as active also stores the mouse click for mouse drag
    private void initializeActiveWindow(DecoratedWindow decoratedWindow, Dimension click) {
        //  assigns the active window
        activeWindow = decoratedWindow;
        //  Sets color to the active window and its border
        activeWindow.windowDecoration.titleBar.color = Color.gray;
        activeWindow.windowDecoration.border.color = Color.gray;
        //  sets the current active window position for calculations in mouse drag
        activeWindowPosition = activeWindow.windowDecoration.border.start;
        //  sets the initial mouse position for calculations in mouse drag
        initialMousePosition = click;
        //  calls window system for repainting the window system
        windowSystem.requestRepaint();
    }

    /*  Brings the selected window to the top of the linked list by removing it from current position and pushing it to
        last*/
    protected void bringToFront(DecoratedWindow decoratedWindow) {
        //  Remove the window from the linked list
        windowSystem.decoratedWindows.remove(decoratedWindow);
        //  Add the selected window as the last element of linked list
        windowSystem.decoratedWindows.addLast(decoratedWindow);
        //  calls window system for repainting the window system
        windowSystem.requestRepaint();
    }

    //  Handles the button click event for close button
    protected void handleCloseButtonClick(DecoratedWindow decoratedWindow, Dimension click) {
        //  Calls the window system to remove the selected simple window
        windowSystem.remove(decoratedWindow);
    }

    //  Handles the mouse release button by resetting all the values
    public void handleMouseRelease(Dimension click) {
        //  Resets the color of deactive window
        if (activeWindow != null){
            activeWindow.windowDecoration.titleBar.color = Color.darkGray;
        }
        //  resets the color
        activeWindow = null;
        activeWindowPosition = null;
        initialMousePosition = null;
    }
}
