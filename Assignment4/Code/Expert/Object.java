

/**
 * Creates a base class called Object which stores a start, end and size(width,height). It should be inherited
 * to create basic shapes in the
 */
public class Object {

    //  Starting coordinates of the object
    public Dimension start;
    //  Ending coordinates of the object
    public Dimension end;
    //  Width and height of the object
    public Dimension size;

    //  Constructor of object class
    public Object(double startX, double startY, double endX, double endY){
        //  initialises the start dimension
        start = new Dimension(startX,startY);
        //  initialises the end dimension
        end = new Dimension(endX,endY);
        //  Calculates the size of the object with start and end dimension
        size = new Dimension(this.end.getDoubleX()-this.start.getDoubleX(),this.end.getDoubleY()-this.start
                .getDoubleY() );
        //  Converts the abstract coordinate of start,end and size values to pixels
        start.convertToInt();
        end.convertToInt();
        size.convertToInt();

    }

    public Object(double startX, double startY){
        start = new Dimension(startX,startY);
        start.convertToInt();
    }
}
