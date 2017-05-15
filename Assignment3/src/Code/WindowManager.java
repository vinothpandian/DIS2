package Code;

import java.awt.*;
import java.util.Iterator;

/**
 * Created by VinothPandianSermuga on 10-05-2017.
 */
public class WindowManager {
    private static WindowManager windowManager;

    private static WindowSystem windowSystem = WindowSystem.getInstance();
    DecoratedWindow activeWindow;
    Dimension activeWindowPosition;
    Dimension initialMousePosition;

    public static WindowManager getInstance(){
        if(windowManager == null){
            windowManager = new WindowManager();
        }
        return windowManager;
    }

    public boolean isBounded(Dimension point){
        if((0 <= point.getDoubleX()
                && 1.0 >= point.getDoubleX())
                && (0 <= point.getDoubleY()
                && 1.0 >= point.getDoubleY())){
            return true;
        }
        return false;
    }
    

    public void handleMouseDrag(Dimension drag) {
        if (isBounded(drag)){
            if (activeWindow != null && activeWindowPosition!= null && initialMousePosition != null){
                activeWindow.simpleWindow.start.setIntX(activeWindowPosition.getIntX()+drag.getIntX()-initialMousePosition
                        .getIntX());
                activeWindow.simpleWindow.start.setIntY(activeWindowPosition.getIntY()+drag.getIntY()-initialMousePosition
                        .getIntY());
                activeWindow.simpleWindow.start.convertToDouble(windowSystem.winDim);
                activeWindow.simpleWindow.start.setDoubleY(activeWindow.simpleWindow.start.getDoubleY()
                        +activeWindow.windowDecoration.titlebarSize);
                activeWindow.simpleWindow.calculateDimensions(windowSystem.winDim);
                activeWindow.simpleWindow.start.convertToInt(windowSystem.winDim);
                activeWindow.simpleWindow.end.convertToDouble(windowSystem.winDim);
                activeWindow.simpleWindow.end.convertToInt(windowSystem.winDim);
                activeWindow.windowDecoration = new WindowDecoration(activeWindow.simpleWindow);

                windowSystem.requestRepaint();
            }
        }
    }


    public WindowDecoration createDecoratedWindow(SimpleWindow simpleWindow) {
        return new WindowDecoration(simpleWindow);
    }

    public void handleTitleBarClick(DecoratedWindow decoratedWindow, Dimension click) {

        if (activeWindow == null){
            initializeActiveWindow(decoratedWindow,click);
        }
    }

    private void initializeActiveWindow(DecoratedWindow decoratedWindow, Dimension click) {
        activeWindow = decoratedWindow;
        activeWindowPosition = activeWindow.windowDecoration.border.start;
        initialMousePosition = click;
        windowSystem.requestRepaint();
    }

    protected void bringToFront(DecoratedWindow decoratedWindow) {
        windowSystem.decoratedWindows.remove(decoratedWindow);
        windowSystem.decoratedWindows.addLast(decoratedWindow);
        windowSystem.requestRepaint();
    }

    protected void handleCloseButtonClick(DecoratedWindow decoratedWindow, Dimension click) {
        windowSystem.remove(decoratedWindow);
    }

    public void handleMouseRelease(Dimension click) {
        activeWindow = null;
        activeWindowPosition = null;
        initialMousePosition = null;
    }
}
