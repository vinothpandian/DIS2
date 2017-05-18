package Code;

/**
 * Window decoration class which creates and stores the title bar, title bar text, close button and border of the
 * window. This is creates and called by the window manager.
 *
 */

import java.awt.Color;

public class WindowDecoration {

    private static WindowSystem windowSystem = WindowSystem.getInstance();

    public final double titlebarSize;
    private final Color titleBarColor;
    private final Color closeButtonColor;
    private final Color borderColor;
    private final Color maxButtonColor;


    //  Creates variable to store titlebar, close button and the title bar text along with their colors
    public SimpleWindow titlebar;
    public SimpleWindow closeButton;
    public SimpleWindow maxButton;
    public SimpleWindow border;

    //  Constructor for window decoration
    public WindowDecoration(double doubleX, double doubleY, double doubleX1, double doubleY1, String title) {
        //  Initialises the color and titlebar size
        titlebarSize = 0.05;
        titleBarColor = Color.darkGray;

        closeButtonColor = Color.red;
        maxButtonColor = Color.green;
        borderColor = Color.gray;

        titlebar = windowSystem.createSimpleWindow(doubleX, doubleY-titlebarSize, doubleX1, doubleY, false,
                "Titlebar");
        titlebar.color = titleBarColor;

        closeButton = windowSystem.createSimpleWindow(titlebar.end.getDoubleX()-0.03, titlebar.end.getDoubleY()
                        -0.04, titlebar.end.getDoubleX()-0.01,
                titlebar.end.getDoubleY()-0.01,
                false, "Close button");
        closeButton.color = closeButtonColor;

        maxButton = windowSystem.createSimpleWindow(closeButton.start.getDoubleX()-0.03, closeButton.start.getDoubleY()
                        , closeButton.start.getDoubleX()-0.01,
                closeButton.end.getDoubleY(),
                false, "Max button");
        maxButton.color = maxButtonColor;

    }

    public void draw() {

        if (this.border != null){
            windowSystem.setColor(this.borderColor);
            windowSystem.fillRect(this.border.start.getIntX(),
                    this.border.start.getIntY(),
                    this.border.end.getIntX(),
                    this.border.end.getIntY());
        }

        windowSystem.setColor(this.titlebar.color);
        windowSystem.fillRect(this.titlebar.start.getIntX(),
                this.titlebar.start.getIntY(),
                this.titlebar.end.getIntX(),
                this.titlebar.end.getIntY());

        windowSystem.setColor(this.closeButtonColor);
        windowSystem.fillRect(this.closeButton.start.getIntX(),
                this.closeButton.start.getIntY(),
                this.closeButton.end.getIntX(),
                this.closeButton.end.getIntY());

        windowSystem.setColor(this.maxButtonColor);
        windowSystem.fillRect(this.maxButton.start.getIntX(),
                this.maxButton.start.getIntY(),
                this.maxButton.end.getIntX(),
                this.maxButton.end.getIntY());
    }

    public void reposition(double i, double i1) {
        this.titlebar.move(i,i1-titlebarSize);
        this.closeButton.move(titlebar.end.getDoubleX()-0.03,titlebar.end.getDoubleY()-0.04);
        this.maxButton.move(closeButton.start.getDoubleX()-0.03,closeButton.start.getDoubleY());

        if (this.border!=null){
            this.border.move(i-0.002, i1-titlebarSize-0.002);
        }
    }

    public void reset() {
        this.titlebar.color = titleBarColor;
    }

    public void addBorder(Dimension start, Dimension end) {
        border = new SimpleWindow(start.getDoubleX()-0.002, start.getDoubleY()-titlebarSize-0.002,
                end.getDoubleX()+0.002, end.getDoubleY()+0.002);
    }

    public void removeBorder() {
        this.border = null;
    }

    public void maximise() {
        this.titlebar.setSize(0,0,1,titlebarSize);
        this.closeButton.setSize(titlebar.end.getDoubleX()-0.03, titlebar.end.getDoubleY()
                        -0.04, titlebar.end.getDoubleX()-0.01,
                titlebar.end.getDoubleY()-0.01);
        this.maxButton.setSize(closeButton.start.getDoubleX()-0.03, closeButton.start.getDoubleY()
                , closeButton.start.getDoubleX()-0.01,
                closeButton.end.getDoubleY());
    }
}
