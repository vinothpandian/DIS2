package Code;
/**
 * Created by VinothPandianSermuga on 12-05-2017.
 */
public class Button extends GraphicObject {

    public Label label;

    public Button(double startX, double startY, double endX, double endY, String label) {
        super(startX, startY, endX, endY);
        this.label = new Label(startY-0.005, startX+0.005, label);
    }
}
