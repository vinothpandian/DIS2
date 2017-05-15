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

}
