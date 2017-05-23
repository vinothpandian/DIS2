

/*
 * Really Awesome Mouse adaptor for Really Awesome Mouse listeners
 *
 * Implements the Mouse listener
 *
 * Stores the button that uses the mouse listener.
 *
 */
public class RATmouseAdaptor implements RATmouseListener {

    private RATbutton button;

    public RATbutton getButton() {
        return button;
    }

    public void setButton(RATbutton button) {
        this.button = button;
    }

    public RATmouseAdaptor(RATbutton raTbutton) {
        this.button = raTbutton;
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
