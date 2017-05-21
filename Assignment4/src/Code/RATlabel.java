package Code;

import java.awt.*;

/**
 * Created by Arijit on 20-May-17.
 */
public class RATlabel extends RATwidget {

    public String text;
    public Dimension start;
    public Color color;

    public RATlabel(double doubleX, double doubleY, String text) {
        super(doubleX, doubleY, doubleX+text.length()/100, doubleY+text.length()/100);

        this.start = new Dimension(doubleX, doubleY);
        this.text = text;
        this.color = Color.white;
    }

    public RATlabel(double doubleX, double doubleY, double doubleX1, double doubleY1, String text) {
        super(doubleX, doubleY, doubleX1, doubleY1);
        this.text = text;
        this.start = start;
        this.color = Color.white;
    }
}
