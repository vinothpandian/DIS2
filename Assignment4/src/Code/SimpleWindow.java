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
	//	Sets a default color of simple window
	public Color color = Color.lightGray;
	public String title;
	public LinkedList<SimpleWindow> children = new LinkedList<>();

	public SimpleWindow(double doubleX, double doubleY, double doubleX1, double doubleY1) {
		this(doubleX, doubleY, doubleX1, doubleY1, "Window:"+windowID);
	}

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

	public void recalculateDimensions() {
		this.start.convertToInt();
		this.end.setIntX(this.start.getIntX()+this.size.getIntX());
		this.end.setIntY(this.start.getIntY()+this.size.getIntY());
		this.end.convertToDouble();
	}

	public void move(double startX, double startY){
		this.start.setDoubleX(startX);
		this.start.setDoubleY(startY);
		this.recalculateDimensions();
		this.start.convertToInt();
	}

	public void setSize(double x, double y, double x1, double y1) {
		this.start.setDoubleX(x);
		this.start.setDoubleY(y);
		this.end.setDoubleX(x1);
		this.end.setDoubleY(y1);
		this.start.convertToInt();
		this.end.convertToInt();
	}
}
