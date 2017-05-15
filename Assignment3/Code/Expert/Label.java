

/**
 * Creates a label which inherits the Object class and adds text
 */

import java.awt.Color;

public class Label extends Object {

    //  Text of the label
    String text;
    //  Color of the text
    public Color color = Color.white;

    //  Constructor for label class
    public Label(double startX, double startY, String text, Color labelColor) {
        super(startX, startY);
        this.color = labelColor;
        this.text = text;
    }
}
