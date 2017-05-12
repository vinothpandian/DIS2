package Code;

/**
 * Created by VinothPandianSermuga on 12-05-2017.
 */
public class Label extends GraphicObject {

    String text;

    public Label(double startX, double startY, String text) {
        super(startX, startY);
        this.text = text;
    }
}
