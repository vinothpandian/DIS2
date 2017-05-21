package Code;

/**
 * Decorated window data structure which contains a simple window along with its decoration (titlebar, close button)
 */

public class DecoratedWindow {

    SimpleWindow simpleWindow;
    WindowDecoration windowDecoration;

    //  Constructor for Decorated window class
    public DecoratedWindow(SimpleWindow simpleWindow, WindowDecoration windowDecoration) {
        this.simpleWindow = simpleWindow;
        this.windowDecoration = windowDecoration;
    }
}
