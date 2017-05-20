package Code;

/**
 * Created by vinot on 5/18/2017.
 */
public interface RATmouseListener {

    public void mouseClicked(Dimension click, RATmouseEvent event);

    public void mousePressed(Dimension click, RATmouseEvent event);

    public void mouseReleased(Dimension click, RATmouseEvent event);

    public void mouseMoved(Dimension click, RATmouseEvent event);

    public void mouseDragged(Dimension click, RATmouseEvent event);

}

