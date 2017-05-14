package Code;

/**
 * Created by VinothPandianSermuga on 10-05-2017.
 */
public class Object {

    public Dimension start;
    public Dimension end;
    private static WindowSystem windowSystem = WindowSystem.getInstance();

    public Object(double startX, double startY, double endX, double endY){
        start = new Dimension(startX,startY);
        end = new Dimension(endX,endY);
        start.convertToInt(windowSystem.winDim);
        end.convertToInt(windowSystem.winDim);
    }

    public Object(double startX, double startY){
        start = new Dimension(startX,startY);
        start.convertToInt(windowSystem.winDim);
    }
}
