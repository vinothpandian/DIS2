package Code;

import java.awt.*;

/**
 * Created by Arijit on 20-May-17.
 */
public class RATbutton extends RATlabel {

    int textPosition;
    Dimension start;
    Color buttonColor;


    public RATbutton(double doubleX, double doubleY, double doubleX1, double doubleY1, String text) {
        super(doubleX, doubleY, doubleX1, doubleY1, text);
        this.start = new Dimension(doubleX, doubleY);
        start.convertToInt();
        this.end = new Dimension(doubleX1, doubleY1);
        end.convertToInt();
        this.recalculateDimensions();
        this.textPosition = text.length();
        this.buttonColor = Color.white;
    }
}
