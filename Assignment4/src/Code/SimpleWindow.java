package Code;

/*
 * DIS2 - Assignment 02
 * Desktop and Windows
 *
 * Group 12:
 *    Arijit Gupta
 *    Vincentius Renaldi
 *    Vinoth Pandian Sermuga Pandian
 *
 * A Simple window class which is maintained by WindowSystem class
 *
 */
import java.awt.Color;
import java.util.LinkedList;

public class SimpleWindow{

	//	Start, end and size(width, height) dimensions
	private static int windowID;

	public Dimension start;
	public Dimension end;
	public Dimension size;
	public Dimension initial;
	//	Sets a default color of simple window
	public Color color = Color.lightGray;
	public String title;
	//	Simplewindow contains a list of simple window children
	public LinkedList<SimpleWindow> children = new LinkedList<>();
	//	Each simple window can be attached to a listener
	private RATmouseListener listener;

	public SimpleWindow(double doubleX, double doubleY, double doubleX1, double doubleY1) {
		this(doubleX, doubleY, doubleX1, doubleY1, "Window:"+windowID);
	}


	//	Constructor for the simple window
	public SimpleWindow(double doubleX, double doubleY, double doubleX1, double doubleY1, String title) {
		this.start = new Dimension(doubleX, doubleY);
		this.end = new Dimension(doubleX1, doubleY1);

		this.start.convertToInt();
		this.end.convertToInt();

		this.size = new Dimension(doubleX1-doubleX, doubleY1-doubleY);
		this.size.convertToInt();

		this.title = title;
	}

	//  Checks whether the simple window contains a given point
	public Boolean contains(Dimension point){
		if((point.getDoubleX() >= this.start.getDoubleX() && point.getDoubleX() <= this.end.getDoubleX())
				&& (point.getDoubleY() >= this.start.getDoubleY() && point.getDoubleY() <= this.end
				.getDoubleY())){
			return true;
		}
		return false;
	}

	//	Re calculates the end dimensions of the simple window
	public void recalculateDimensions() {
		this.start.convertToInt();
		this.end.setIntX(this.start.getIntX()+this.size.getIntX());
		this.end.setIntY(this.start.getIntY()+this.size.getIntY());
		this.end.convertToDouble();
	}

	//	Moves the simple window to the given coordinate
	public void move(double startX, double startY){
		this.start.setDoubleX(startX);
		this.start.setDoubleY(startY);
		this.recalculateDimensions();
		this.start.convertToInt();
	}

	//	Resizes the simple window as per given dimensions
	public void resize(double x, double y, double x1, double y1) {
		this.start.setDoubleX(x);
		this.start.setDoubleY(y);
		this.end.setDoubleX(x1);
		this.end.setDoubleY(y1);
		this.start.convertToInt();
		this.end.convertToInt();
	}


	//	Adds mouse listener to the simple window
	public void addListener(RATmouseListener toAdd) {
		this.listener = toAdd;
	}

	//	Manages the mouse click event
	public void mouseClicked(Dimension click, RATmouseEvent event){
		for (SimpleWindow child : children){
			if (child.contains(click) && child.listener != null){
				child.listener.mouseClicked(click,event);
			}
		}
	}

	//	Manages the mouse pressed event
	public void mousePressed(Dimension click, RATmouseEvent event){
		for (SimpleWindow child : children){
			if (child.contains(click) && child.listener != null){
				child.listener.mousePressed(click, event);
			}
		}
	}

	//	Manages the mouse released event
	public void mouseReleased(Dimension click, RATmouseEvent event){
		for (SimpleWindow child : children){
			if (child.contains(click) && child.listener != null){
				child.listener.mouseReleased(click, event);
			}
		}
	}

	//	Manages the mouse moved event
	public void mouseMoved(Dimension click, RATmouseEvent event){
		for (SimpleWindow child : children){
			if (child.contains(click) && child.listener != null){
				child.listener.mouseMoved(click, event);
			}
		}
	}

	//	Manages the mouse dragged event
	public void mouseDragged(Dimension click, RATmouseEvent event){
		for (SimpleWindow child : children){
			if (child.contains(click) && child.listener != null){
				child.listener.mouseDragged(click, event);
			}
		}
	}

	//	Adds the simplewindow child to the parent window and repositions it
	public void add(RATbutton button) {
		positionChild(button);

		children.add(button);
	}

	//	Calculates the position of child within the parent simplewindow
	private void positionChild(SimpleWindow button) {
		button.start.setDoubleX((button.start.getDoubleX()*this.size.getDoubleX())+this.start.getDoubleX());
		button.start.setDoubleY((button.start.getDoubleY()*this.size.getDoubleY())+this.start.getDoubleY());
		button.start.convertToInt();

		button.end.setDoubleX((button.end.getDoubleX()*this.size.getDoubleX())+this.start.getDoubleX());
		button.end.setDoubleY((button.end.getDoubleY()*this.size.getDoubleY())+this.start.getDoubleY());
		button.end.convertToInt();
		
		button.setSize();
	}

	//	Calculates size of a simple window from start and end points
	public void setSize() {
		this.size.setDoubleX(this.end.getDoubleX()-this.start.getDoubleX());
		this.size.setDoubleY(this.end.getDoubleY()-this.start.getDoubleY());
		this.size.convertToInt();
	}

	//	Sets the initial position of a simple window (ex. before a drag event)
	public void setInitialPosition() {
		this.initial = new Dimension(this.start.getDoubleX(), this.start.getDoubleY());
		this.initial.convertToInt();
		for (SimpleWindow child : children) {
			child.initial = new Dimension(child.start.getDoubleX(), child.start.getDoubleY());
			child.initial.convertToInt();
		}
	}

	//	Moves the whole simple window along with children
	public void moveBox(double v, double v1) {
		this.move(this.initial.getDoubleX()+v,this.initial.getDoubleY()+v1);

		for (SimpleWindow child: children){
			child.move(v+child.initial.getDoubleX(), v1+child.initial.getDoubleY());
		}
	}

	//	Adds a button as a child of simple window
	public void add(RATlabel message) {
		positionChild(message);
		children.add(message);
	}

//	//	Resizes the simple window as per the given dimension /*NOT IMPLEMENTED YET*/
//	public void resizeBox(int i, double titlebarSize, int i1, int i2) {
//		this.resize(i,titlebarSize,i1,i2 );
//		for (SimpleWindow child : children) {
//			child.start.setDoubleX((child.start.getDoubleX()*this.size.getDoubleX())+this.start.getDoubleX());
//			child.start.setDoubleY((child.start.getDoubleY()*this.size.getDoubleY())+this.start.getDoubleY());
//			child.start.convertToInt();
//		}
//	}
}
