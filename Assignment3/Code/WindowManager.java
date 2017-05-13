package Code;

/**
 * Created by VinothPandianSermuga on 10-05-2017.
 */
public class WindowManager {

    public Rectangle titleBar;
    public Button closeButton;
    public double titlebarSize;
    public Label titleText;




    public WindowManager(SimpleWindow simpleWindow, Dimension winDim){

        titlebarSize = 0.05;

        Dimension appStart = new Dimension(simpleWindow.positionX, simpleWindow.positionY);
        Dimension appEnd = new Dimension(simpleWindow.width, simpleWindow.height);
        appEnd.convertAbstract(winDim);
        appEnd.setAbstractX(appStart.getAbstractX()+appEnd.getAbstractX());
        appEnd.setAbstractY(appStart.getAbstractY()+appEnd.getAbstractY());


        titleBar = createTitlebar(appStart, appEnd);
        titleText = createTitle(simpleWindow.title,0.03);
        closeButton = createCloseButton("X");
//        createBorder();
    }

    private Label createTitle(String title, double place) {
        return new Label(titleBar.startX+place, titleBar.startY+place, title);
    }

    private Rectangle createTitlebar(Dimension appStart, Dimension appEnd) {
        return new Rectangle(appStart.getAbstractX(), appStart.getAbstractY()-titlebarSize, appEnd.getAbstractX(),appStart.getAbstractY());
    }

    private Button createCloseButton(String label) {
        return new Button(titleBar.endX-0.03, titleBar.endY-0.04, titleBar.endX-0.01,titleBar.endY-0.01, label);
    }

    private void createBorder() {
    }
}
