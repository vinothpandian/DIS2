package Code;

/**
 * Created by VinothPandianSermuga on 10-05-2017.
 */
public class Object {

    public Dimension start;
    public Dimension end;
    public Dimension size;
    private static WindowSystem windowSystem = WindowSystem.getInstance();

    public Object(double startX, double startY, double endX, double endY){
        start = new Dimension(startX,startY);
        end = new Dimension(endX,endY);
        size = new Dimension(this.end.getDoubleX()-this.start.getDoubleX(),this.end.getDoubleY()-this.start
                .getDoubleY() );
        start.convertToInt(windowSystem.winDim);
        end.convertToInt(windowSystem.winDim);
        size.convertToInt(windowSystem.winDim);

    }

    public Object(double startX, double startY){
        start = new Dimension(startX,startY);
        start.convertToInt(windowSystem.winDim);
    }
}
