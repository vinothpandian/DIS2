package Code;

/**
 * Created by vinot on 5/21/2017.
 */
public class RATmouseAdaptor implements RATmouseListener {

    private RATbutton button;
    private RATlabel label;

    public RATbutton getButton() {
        return button;
    }

    public void setButton(RATbutton button) {
        this.button = button;
    }

    public RATlabel getLabel() {
        return label;
    }

    public void setLabel(RATlabel label) {
        this.label = label;
    }

    public RATmouseAdaptor(RATbutton raTbutton) {
        this.button = raTbutton;
    }

    public RATmouseAdaptor(RATlabel raTlabel){
        this.label = raTlabel;
    }

    @Override
    public void mouseClicked(Dimension click, RATmouseEvent event) {

    }

    @Override
    public void mousePressed(Dimension click, RATmouseEvent event) {

    }

    @Override
    public void mouseReleased(Dimension click, RATmouseEvent event) {

    }

    @Override
    public void mouseMoved(Dimension click, RATmouseEvent event) {

    }

    @Override
    public void mouseDragged(Dimension click, RATmouseEvent event) {

    }
}
