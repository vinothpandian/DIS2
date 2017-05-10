package Code;

/**
 * Created by VinothPandianSermuga on 10-05-2017.
 */
public class WindowManager {

    public SimpleWindow simpleWindow;
    public GraphicObject container;
    public GraphicObject title;
    public GraphicObject closeButton;
    public GraphicObject closeMark;

    public WindowManager(double startX, double startY, double endX, double endY){
        this.simpleWindow = simpleWindow;
        this.container = new GraphicObject(startX-0.001, startY-0.02, endX+0.001, endY+0.001);
        this.title = new GraphicObject(startX, startY);
        this.closeButton = new GraphicObject(endX-0.02,startY-0.02,endX,startY);
        this.closeMark = new GraphicObject(endX-0.01, startY);
    }

}
