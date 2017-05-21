package Code;

/**
 * Created by Arijit on 20-May-17.
 */
public abstract class RATwidget extends  SimpleWindow {

    String type;

    public RATwidget(double doubleX, double doubleY, double doubleX1, double doubleY1) {
        super(doubleX, doubleY, doubleX1, doubleY1);
    }

    public RATwidget(double doubleX, double doubleY, double doubleX1, double doubleY1, String title) {
        super(doubleX, doubleY, doubleX1, doubleY1, title);
    }
}
