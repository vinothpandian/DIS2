package Code;

import java.awt.*;

/**
 * Created by VinothPandianSermuga on 12-05-2017.
 */
public class Button extends Rectangle {

    public Label label;
    public Color color;

    public Button(double startX, double startY, double endX, double endY, String label) {
        super(startX, startY, endX, endY);
        this.color = color;
        this.label = new Label((startX+endX)/2-0.005, (startY+endY)/2+0.005, label);
    }
}
