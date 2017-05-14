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
            if(contains(click, decoratedWindow.windowDecoration.border)){
                if(contains(click,decoratedWindow.windowDecoration.closeButton)){
                    System.out.println("CLOSE "+ decoratedWindow.simpleWindow.title);
                    removeDecoratedWindow(decoratedWindow);
                    break;
                }
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
        windowSystem.requestRepaint();
    }


    public void handleMouseDrag(Dimension click) {


    }
}
