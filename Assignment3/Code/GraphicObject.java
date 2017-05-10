package Code;

/**
 * Created by VinothPandianSermuga on 10-05-2017.
 */
public class GraphicObject {

    public  double startX;
    public  double startY;
    public  double endX;
    public  double endY;

    public GraphicObject(double startX, double startY, double endX, double endY){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public GraphicObject(double startX, double startY){
        this.startX = startX;
        this.startY = startY;
    }


}
