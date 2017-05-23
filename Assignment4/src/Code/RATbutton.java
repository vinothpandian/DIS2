package Code;



/**
 * Really Awesome Toolkit button
 */

import java.awt.Color;

public class RATbutton extends RATlabel {

    //  Text position value to adjust the button label inside the button
    int textPosition;

    //  Color of the button rectangle
    Color buttonColor;

    //  Constructor for the button
    public RATbutton(double doubleX, double doubleY, double doubleX1, double doubleY1, String text) {
        super(doubleX, doubleY, doubleX1, doubleY1, text);

        //  Sets the button start, end and size
        this.start = new Dimension(doubleX, doubleY);
        start.convertToInt();
        this.end = new Dimension(doubleX1, doubleY1);
        end.convertToInt();
        this.recalculateDimensions();

        //  Text position inside the button is calculated by the string length
        this.textPosition = text.length()*2;
        //  Default setting of the button color is white
        this.buttonColor = new Color(0.9f, 0.9f, 0.9f);
    }
}
