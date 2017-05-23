package Code;

/*
 * Really Awesome Toolkit Label
 */

import java.awt.Color;

public class RATlabel extends RATwidget {

    //  Text string of the label
    public String text;
    //  Starting coordinates of the label text
    public Dimension start;
    //  Color of the label
    public Color labelColor;

    //  Constructor for a label
    public RATlabel(double doubleX, double doubleY, String text) {
        super(doubleX, doubleY, doubleX+text.length()/100, doubleY+text.length()/100);

        this.start = new Dimension(doubleX, doubleY);
        this.text = text;
        // Default label color
        this.labelColor = Color.black;
    }

    //  Constructor for the label of a button
    public RATlabel(double doubleX, double doubleY, double doubleX1, double doubleY1, String text) {
        super(doubleX, doubleY, doubleX1, doubleY1);

        this.text = text;
        this.start = start;
        // Default label color
        this.labelColor = Color.black;
    }
}
