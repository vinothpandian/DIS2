package Code;

/**
 * Created by Arijit on 20-May-17.
 */
public class RATbutton extends RATlabel {

    double textPosition;

    public RATbutton(double doubleX, double doubleY, double doubleX1, double doubleY1, String title, double
            textPosition) {
        super(doubleX, doubleY, doubleX1, doubleY1, title);

        this.textPosition = textPosition;
    }
}
