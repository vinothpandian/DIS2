package Code;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by VinothPandianSermuga on 10-05-2017.
 */
public class WindowManager {
    private static WindowManager windowManager;
    private LinkedList<DecoratedWindow> decoratedWindows = new LinkedList<>();
    private static WindowSystem windowSystem = WindowSystem.getInstance();

    public static WindowManager getInstance(){
        if(windowManager == null){
            windowManager = new WindowManager();
        }
        return windowManager;
    }

    public void add(SimpleWindow simpleWindow) {
        decoratedWindows.add(new DecoratedWindow(simpleWindow, new WindowDecoration(simpleWindow)));
    }

    public void draw() {
        for (DecoratedWindow decoratedWindow: decoratedWindows) {

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

    public Boolean contains(Dimension mouse, Rectangle rectangle){
        if((mouse.getDoubleX() >= rectangle.start.getDoubleX() && mouse.getDoubleX() <= rectangle.end.getDoubleX())
                && (mouse.getDoubleY() >= rectangle.start.getDoubleY() && mouse.getDoubleY() <= rectangle.end
                .getDoubleY())){
            return true;
        }
        return false;
    }

    public void handleMouseClick(Dimension click) {

        DecoratedWindow decoratedWindow;

        Iterator<DecoratedWindow> it = decoratedWindows.descendingIterator();

        while (it.hasNext()){
            decoratedWindow = it.next();

            if(contains(click,decoratedWindow.windowDecoration.closeButton)){
                removeDecoratedWindow(decoratedWindow);
                break;
            }

            if(contains(click, decoratedWindow.windowDecoration.border)){
                bringToFront(decoratedWindow);
                break;
            }
        }
    }

    private void bringToFront(DecoratedWindow decoratedWindow) {
        decoratedWindows.remove(decoratedWindow);
        decoratedWindows.addLast(decoratedWindow);
        windowSystem.requestRepaint();
    }

    private void removeDecoratedWindow(DecoratedWindow decoratedWindow){
        decoratedWindows.remove(decoratedWindow);
        System.out.print("CLOSE CLICKED");
        windowSystem.requestRepaint();
    }

    /*
    public void handleMousePress(Dimension click) {

        System.out.println("mouse pressed");
    }*/

    /*
    public void handleMouseRelease(Dimension click) {

        System.out.println("mouse released");
    }*/


    /*Handler for mouse drag event*/
    public void handleMouseDrag(Dimension click) {

        DecoratedWindow decoratedWindow;

        Iterator<DecoratedWindow> it = decoratedWindows.descendingIterator();

        while (it.hasNext()){
            decoratedWindow = it.next();

            if(contains(click,decoratedWindow.windowDecoration.titleBar)){
                dragDecoratedWindow(click,decoratedWindow);
                break;
            }
        }

    }

    private void dragDecoratedWindow(Dimension click, DecoratedWindow decoratedWindow){
        //System.out.println("Dragged: Window" + decoratedWindow.windowDecoration.titleText.text);

        SimpleWindow simpleWindow = decoratedWindow.simpleWindow;
        //WindowDecoration windowDecoration = decoratedWindow.windowDecoration;

        //moves the SimpleWindow
        simpleWindow.start.setDoubleX(click.getDoubleX());
        simpleWindow.start.setDoubleY(click.getDoubleY());
        simpleWindow.calculateDimensions(windowSystem.winDim);

        //moves the windowDecoration (title, border) relatie to the simpleWindow
        decoratedWindow.windowDecoration = new WindowDecoration(simpleWindow);

//      windowDecoration.titleBar = windowDecoration.createTitlebar(simpleWindow.start, simpleWindow.end, java.awt.Color.BLUE);
//      windowDecoration.border = windowDecoration.createBorder(windowDecoration.titleBar, simpleWindow);

        //repaint all windows
        windowSystem.requestRepaint();
    }
}
