package Code;

/**
 * Created by vinot on 5/14/2017.
 */
public class DecoratedWindow {
    SimpleWindow simpleWindow;
    WindowDecoration windowDecoration;

    public DecoratedWindow(SimpleWindow simpleWindow, WindowDecoration windowDecoration) {
        this.simpleWindow = simpleWindow;
        this.windowDecoration = windowDecoration;
    }

    public void draw(WindowSystem windowSystem) {

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
    }
}
