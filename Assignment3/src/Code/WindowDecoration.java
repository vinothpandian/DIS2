package Code;

import java.awt.*;

/**
 * Created by vinot on 5/14/2017.
 */
public class WindowDecoration {
    public Color borderColor;
    public Color closeButtonColor;
    public Rectangle titleBar;
    public Button closeButton;
    public double titlebarSize;
    public Label titleText;
    public Color titleBarColor;
    public Rectangle border;

    public WindowDecoration(SimpleWindow simpleWindow) {
        titlebarSize = 0.05;
        titleBarColor = Color.darkGray;
        closeButtonColor = Color.red;
        borderColor = Color.black;
        titleBar = createTitlebar(simpleWindow.start, simpleWindow.end, titleBarColor);
        titleText = createTitle(simpleWindow.title,0.03);
        closeButton = createCloseButton("X", closeButtonColor);
        border = createBorder(titleBar, simpleWindow, borderColor);
    }
    private Label createTitle(String title, double place) {
        return new Label(titleBar.start.getDoubleX()+place, titleBar.start.getDoubleY()+place, title);
    }

    private Rectangle createTitlebar(Dimension start, Dimension end, Color titleBarColor) {
        Rectangle titleBar = new Rectangle(start.getDoubleX(), start.getDoubleY()-titlebarSize, end.getDoubleX(),start
                .getDoubleY());
        titleBar.color = titleBarColor;
        return titleBar;
    }

    private Button createCloseButton(String label, Color closeButtonColor) {
        Button closeButton = new Button(titleBar.end.getDoubleX()-0.03, titleBar.end.getDoubleY()-0.04,
                titleBar.end.getDoubleX()-0.01,titleBar.end.getDoubleY()-0.01, label);
        closeButton.color = closeButtonColor;
        return closeButton;
    }

    private Rectangle createBorder(Rectangle titleBar, SimpleWindow simpleWindow, Color borderColor) {

        border = new Rectangle(titleBar.start.getDoubleX(), titleBar.start.getDoubleY(),
                simpleWindow.end.getDoubleX(),simpleWindow.end.getDoubleY());
        border.color = borderColor;
        return border;

    }

}
