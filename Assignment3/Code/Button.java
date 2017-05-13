package Code;
/**
 * Created by VinothPandianSermuga on 12-05-2017.
 */
public class Button extends GraphicObject {

    public Label label;

    public Button(double startX, double startY, double endX, double endY, String label) {
        super(startX, startY, endX, endY);
        this.label = new Label((startX+endX)/2-0.005, (startY+endY)/2+0.005, label);
    }
}
