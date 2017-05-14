package Code;

import java.awt.*;

/**
 * Created by VinothPandianSermuga on 12-05-2017.
 */
public class Label extends Object {

    String text;
    public Color color;

    public Label(double startX, double startY, String text) {
        super(startX, startY);
        this.color = Color.white;
        this.text = text;
    }
}
