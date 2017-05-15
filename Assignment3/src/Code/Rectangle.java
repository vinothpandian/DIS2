package Code;

import java.awt.*;

/**
 * Created by VinothPandianSermuga on 12-05-2017.
 */
public class Rectangle extends Object {

    public Color color = Color.red;

    public Rectangle(double startX, double startY, double endX, double endY) {
        super(startX, startY, endX, endY);
        this.color = color;

    }

    public Boolean contains(Dimension mouse){
        if((mouse.getDoubleX() >= this.start.getDoubleX() && mouse.getDoubleX() <= this.end.getDoubleX())
                && (mouse.getDoubleY() >= this.start.getDoubleY() && mouse.getDoubleY() <= this.end
                .getDoubleY())){
            return true;
        }
        return false;
    }

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
