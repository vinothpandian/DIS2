package Code;

/**
 * Window decoration class which creates and stores the title bar, title bar text, close button and border of the
 * window. This is creates and called by the window manager.
 *
 */

import java.awt.Color;

public class WindowDecoration {

    private static WindowSystem windowSystem = WindowSystem.getInstance();
    private static WindowManager windowManager = WindowManager.getInstance();

    public final double titlebarSize;
    private final Color titleBarColor;
    private final Color borderColor;


    //  Creates variable to store titlebar, close button and the title bar text along with their colors
    public SimpleWindow titlebar;
    public SimpleWindow closeButton;
//    public SimpleWindow maxButton;
    public SimpleWindow border;

    //  Constructor for window decoration
    public WindowDecoration(double doubleX, double doubleY, double doubleX1, double doubleY1, String title) {
        //  Initialises the color and titlebar size

        this.titlebarSize = 0.05;
        this.titleBarColor = Color.darkGray;
        //  Calls the function to create a titlebar
        createTitlebar(doubleX, doubleY, doubleX1, doubleY1, title);
        //  Calls the function to create a close button
        createCloseButton(doubleX, doubleY, doubleX1, doubleY1, title);
        //createMaxButton(doubleX, doubleY, doubleX1, doubleY1, title); /*NOT IMPLEMENTED YET*/

        borderColor = Color.gray;

    }

//      //  Creates a maximise button /*NOT IMPLEMENTED YET*/
//    private void createMaxButton(double doubleX, double doubleY, double doubleX1, double doubleY1, String title) {
//        maxButton = windowSystem.createSimpleWindow(closeButton.start.getDoubleX()-0.03, closeButton.start.getDoubleY()
//                , closeButton.start.getDoubleX()-0.01,
//                closeButton.end.getDoubleY(),
//                false, "Max button");
//        maxButton.color = Color.green;
//        maxButton.addListener(new RATmouseListener() {
//            @Override
//            public void mouseClicked(Dimension click, RATmouseEvent event) {
//
//            }
//
//            @Override
//            public void mousePressed(Dimension click, RATmouseEvent event) {
//                System.out.println("MAX BUTTON CLICKED AT : "+click.getIntX());
//            }
//
//            @Override
//            public void mouseReleased(Dimension click, RATmouseEvent event) {
//
//            }
//
//            @Override
//            public void mouseMoved(Dimension click, RATmouseEvent event) {
//
//            }
//
//            @Override
//            public void mouseDragged(Dimension click, RATmouseEvent event) {
//
//            }
//        });
//    }

    private void createCloseButton(double doubleX, double doubleY, double doubleX1, double doubleY1, String title) {
        closeButton = windowSystem.createSimpleWindow(titlebar.end.getDoubleX()-0.03, titlebar.end.getDoubleY()
                        -0.04, titlebar.end.getDoubleX()-0.01,
                titlebar.end.getDoubleY()-0.01,
                false, "Close button");
        closeButton.color = Color.red;
    }

    private void createTitlebar(double doubleX, double doubleY, double doubleX1, double doubleY1, String title) {

        this.titlebar = windowSystem.createSimpleWindow(doubleX, doubleY-titlebarSize, doubleX1, doubleY, false,
                "Titlebar");
        this.titlebar.color = titleBarColor;

    }

    public void draw() {

        if (this.border != null){
            windowSystem.setColor(this.borderColor);
            windowSystem.fillRect(this.border.start.getIntX(),
                    this.border.start.getIntY(),
                    this.border.end.getIntX(),
                    this.border.end.getIntY());
        }

        //  Draws the titlebar
        windowSystem.setColor(this.titlebar.color);
        windowSystem.fillRect(this.titlebar.start.getIntX(),
                this.titlebar.start.getIntY(),
                this.titlebar.end.getIntX(),
                this.titlebar.end.getIntY());

        //  Draws the close button
        windowSystem.setColor(this.closeButton.color);
        windowSystem.fillRect(this.closeButton.start.getIntX(),
                this.closeButton.start.getIntY(),
                this.closeButton.end.getIntX(),
                this.closeButton.end.getIntY());

//          //  Draws the maximise button /* NOT IMPLEMENTED YET*/
//        windowSystem.setColor(this.maxButton.color);
//        windowSystem.fillRect(this.maxButton.start.getIntX(),
//                this.maxButton.start.getIntY(),
//                this.maxButton.end.getIntX(),
//                this.maxButton.end.getIntY());
    }


    //  Repositions the window decoration as per the given position
    public void reposition(double i, double i1) {
        this.titlebar.move(i,i1-titlebarSize);
        this.closeButton.move(titlebar.end.getDoubleX()-0.03,titlebar.end.getDoubleY()-0.04);
//        this.maxButton.move(closeButton.start.getDoubleX()-0.03,closeButton.start.getDoubleY());

        if (this.border!=null){
            this.border.move(i-0.002, i1-titlebarSize-0.002);
        }
    }

    public void reset() {
        this.titlebar.color = titleBarColor;
    }

    //  Adds border to the simple window
    public void addBorder(Dimension start, Dimension end) {
        border = new SimpleWindow(start.getDoubleX()-0.002, start.getDoubleY()-titlebarSize-0.002,
                end.getDoubleX()+0.002, end.getDoubleY()+0.002);
    }

    //  Removes the border of the simple window
    public void removeBorder() {
        this.border = null;
    }

    /* //   Maximises the simple window's window decoration // NOT IMLEMENTED YET
    public void maximise() {
        this.titlebar.resize(0,0,1,titlebarSize);
        this.closeButton.resize(titlebar.end.getDoubleX()-0.03, titlebar.end.getDoubleY()
                        -0.04, titlebar.end.getDoubleX()-0.01,
                titlebar.end.getDoubleY()-0.01);
//        this.maxButton.resize(closeButton.start.getDoubleX()-0.03, closeButton.start.getDoubleY()
//                , closeButton.start.getDoubleX()-0.01,
//                closeButton.end.getDoubleY());
    }*/
}
