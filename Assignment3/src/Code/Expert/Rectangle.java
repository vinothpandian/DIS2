

/**
 * Creates a rectangle by inheriting Object class. Checks whether a point is inside the rectangle
 * or on the border
 */
import java.awt.Color;

public class Rectangle extends Object {

    //  Sets the color of the rectangle
    public Color color = Color.red;

    //  Constructor for the rectangle class
    public Rectangle(double startX, double startY, double endX, double endY) {
        super(startX, startY, endX, endY);
        this.color = color;

    }

    //  Checks whether the rectangle contains a given point
    public Boolean contains(Dimension point){
        if((point.getDoubleX() >= this.start.getDoubleX() && point.getDoubleX() <= this.end.getDoubleX())
                && (point.getDoubleY() >= this.start.getDoubleY() && point.getDoubleY() <= this.end
                .getDoubleY())){
            return true;
        }
        return false;
    }

    //  Checks whether the rectangle border is being clicked on
    public Boolean onEdge(Dimension point){
        double distance = 0.05;   // constant distance
        if ( ( point.getDoubleX() < this.start.getDoubleX() && point.getDoubleX() > this.start.getDoubleX() -
                distance ) ||
                ( point.getDoubleX() > this.end.getDoubleX() && point.getDoubleX() < this.end.getDoubleX() + distance ) ||
                ( point.getDoubleY() < this.end.getDoubleY() && point.getDoubleY() > this.end.getDoubleY() - distance ) ||
                ( point.getDoubleY() > this.start.getDoubleY() && point.getDoubleY() < this.start.getDoubleY() + distance ) )  {

            return true;
        }

        return false;
    }
}
