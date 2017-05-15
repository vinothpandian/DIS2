

/**
 * Creates a Button by extending rectangle class and adds a label
 */

import java.awt.Color;

public class Button extends Rectangle {

    public Color labelColor = Color.white;
    //  Label of the button
    public Label label;
    //  Color of the button
    public Color color = Color.red;

    //  Constructor for button class
    public Button(double startX, double startY, double endX, double endY, String label, double textPosition) {
        super(startX, startY, endX, endY);
        this.color = color;
        //  Puts the label in the center of the button and adjusts the text as per text position
        this.label = new Label((startX+endX)/2-textPosition, (startY+endY)/2+textPosition, label, labelColor);
    }
}
