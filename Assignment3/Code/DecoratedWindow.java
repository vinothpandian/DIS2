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

}
