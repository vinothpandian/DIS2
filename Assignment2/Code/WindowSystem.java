import de.rwth.hci.Graphics.GraphicsEventSystem;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by VinothPandianSermuga on 03-05-2017.
 */
public class WindowSystem extends GraphicsEventSystem {

    int width, height;

    LinkedList<SimpleWindow> simpleWindows = new LinkedList<SimpleWindow>();
    LinkedList<Line> lines = new LinkedList<Line>();

    public WindowSystem(int width, int height) {
        super(width, height);

        this.width = width;
        this.height = height;
    }

    public WindowSystem() {
        this(600,400);
    }

    private int convertWidth(double coordX) {
        return (int) (coordX * width);
    }

    private int convertHeight(double coordY) {
        return (int) (coordY * height);
    }

    public void drawLine(float StartX, float StartY, float EndX, float EndY) {
        int inStartX = convertWidth(StartX);
        int inStartY = convertHeight(StartY);
        int inEndX = convertWidth(EndX);
        int inEndY = convertHeight(EndY);
        lines.add(new Line(inStartX, inStartY, inEndX, inEndY));

    }

    @Override
    protected void handlePaint() {
        setColor(Color.black);
        for (Line line : lines) {
            line.draw();
        }

    }

    class Line{
        int startX, startY, endX, endY;

        public Line(int startX, int startY, int endX, int endY){
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        public void draw(){
            drawLine(startX,startY,endX,endY);
        }
    }

}
