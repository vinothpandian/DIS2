/*
 * DIS2 - Assignment 02
 * Desktop and Windows
 *
 * Group 12:
 *    Arijit Gupta
 *    Vincentius Renaldi
 *    Vinoth Pandian Sermuga Pandian
 *
 * A WindowSystem which handles drawing in a resolution-independent way, and
 * performs a draw line method.
 *
 */
import de.rwth.hci.Graphics.GraphicsEventSystem;

import java.awt.Color;
import java.util.LinkedList;

/* Create a Window System class extending the GES jar file */
public class WindowSystem extends GraphicsEventSystem {

    // Set width and height values for the window initiation
    private int width, height;

    // Create Linked list for handling simple windows
    LinkedList<SimpleWindow> simpleWindows = new LinkedList<SimpleWindow>();
    //  Create a Linked list for handling the lines from drawLine method
    LinkedList<Line> lines = new LinkedList<Line>();

    // Constructor for the Windows System with width and height parameter
    public WindowSystem(int width, int height) {
        super(width, height);

        this.width = width;
        this.height = height;
    }

    //  Empty constructor will call the parameterised constructor and set width 600 and height 400
    public WindowSystem() {
        this(600,400);
    }

    //  Convert the width value from the abstract coordinate system to window coordinate system
    private int convertWidth(double coordX) {
        return (int) (coordX * width);
    }

    //  Convert the height value from the abstract coordinate system to window coordinate system
    private int convertHeight(double coordY) {
        return (int) (coordY * height);
    }

    //  Draw the line function using float parameters
    public void drawLine(float StartX, float StartY, float EndX, float EndY) {
        int inStartX = convertWidth(StartX);
        int inStartY = convertHeight(StartY);
        int inEndX = convertWidth(EndX);
        int inEndY = convertHeight(EndY);
        lines.add(new Line(inStartX, inStartY, inEndX, inEndY));

    }

    //  Handle paint method which handles the draw operations of window system
    @Override
    protected void handlePaint() {
        //  set the color of the line
        setColor(Color.black);
        //  loop through all the lines from line linked list and draw the lines on windowsystem
        for (Line line : lines) {
            line.draw();
        }

    }

    //  Line class for storing the converted line coordinates
    class Line{
        //  Points for drawing line
        int startX, startY, endX, endY;

        //  Constructor for line class which adds the points to instance
        public Line(int startX, int startY, int endX, int endY){
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        //  Call the draw line of GES class
        public void draw(){
            drawLine(startX,startY,endX,endY);
        }
    }

}
