

/**
 * Window decoration class which creates and stores the title bar, title bar text, close button and border of the
 * window. This is creates and called by the window manager.
 *
 */

import java.awt.Color;

public class WindowDecoration {

    public double textPosition;
    //  Creates variable to store titlebar, close button and the title bar text along with their colors
    public Rectangle border;
    public Rectangle titleBar;
    public Button closeButton;
    public double titlebarSize;
    public Label titleText;
    public Color borderColor;
    public Color closeButtonColor;
    public Color titleBarColor;
    public Color titleLabelColor;

    //  Constructor for window decoration
    public WindowDecoration(SimpleWindow simpleWindow) {
        //  Initialises the color and titlebar size
        titlebarSize = 0.05;
        textPosition = 0.03;
        titleBarColor = Color.darkGray;
        closeButtonColor = Color.red;
        borderColor = Color.black;
        titleLabelColor = Color.white;
        //  Creates the title bar
        titleBar = createTitlebar(simpleWindow.start, simpleWindow.end, titleBarColor);
        //  Creates the title text
        titleText = createTitle(simpleWindow.title,textPosition, titleLabelColor);
        //  Creates close button
        closeButton = createCloseButton("X", closeButtonColor);
        //  Creates border of the window
        border = createBorder(titleBar, simpleWindow, borderColor);

    }

    //  Create a title string for the titlebar as a label
    private Label createTitle(String title, double place, Color labelColor) {
        return new Label(titleBar.start.getDoubleX()+place, titleBar.start.getDoubleY()+place, title, labelColor);
    }

    //  Create a title bar as a rectangle
    private Rectangle createTitlebar(Dimension start, Dimension end, Color titleBarColor) {
        Rectangle titleBar = new Rectangle(start.getDoubleX(), start.getDoubleY()-titlebarSize, end.getDoubleX(),start
                .getDoubleY());
        titleBar.color = titleBarColor;
        return titleBar;
    }

    //  Create a close button as a button object (with label and a rectangle)
    private Button createCloseButton(String label, Color closeButtonColor) {
        Button closeButton = new Button(titleBar.end.getDoubleX()-0.03, titleBar.end.getDoubleY()-0.04,
                titleBar.end.getDoubleX()-0.01,titleBar.end.getDoubleY()-0.01, label, 0.005);
        closeButton.color = closeButtonColor;
        return closeButton;
    }

    //  Create a border for the window as a rectangle
    private Rectangle createBorder(Rectangle titleBar, SimpleWindow simpleWindow, Color borderColor) {

        border = new Rectangle(titleBar.start.getDoubleX(), titleBar.start.getDoubleY(),
                simpleWindow.end.getDoubleX(),simpleWindow.end.getDoubleY());
        border.color = borderColor;
        return border;
    }

}
