package Code;

import java.util.LinkedList;

/**
 * Created by VinothPandianSermuga on 10-05-2017.
 */
public class WindowManager {


    private static WindowManager windowManager;
    private LinkedList<WindowDecoration> windowDecorationList = new LinkedList<>();
    private static WindowSystem windowSystem = WindowSystem.getInstance();

    public static WindowManager getInstance(){
        if(windowManager == null){
            windowManager = new WindowManager();
        }
        return windowManager;
    }


    public WindowDecoration decorate(SimpleWindow simpleWindow) {
        return new WindowDecoration(simpleWindow);
    }
}
