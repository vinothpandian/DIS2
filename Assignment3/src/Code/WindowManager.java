package Code;

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


    public void handleMouseClick(Dimension click) {

    }

    public void handleMouseDrag(Dimension drag) {
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


    public WindowDecoration createDecoratedWindow(SimpleWindow simpleWindow) {
        return new WindowDecoration(simpleWindow);
    }

    public void handleTitleBarClick(DecoratedWindow decoratedWindow, Dimension click) {
        activeWindow = decoratedWindow;
        activeWindowPosition = activeWindow.windowDecoration.border.start;
        initialMousePosition = click;
    }
}
