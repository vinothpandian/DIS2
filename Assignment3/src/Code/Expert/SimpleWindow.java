

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

public class SimpleWindow{

	//	Start, end and size(width, height) dimensions
	public Dimension start;
	public Dimension end;
	public Dimension size;
	//	Title string
	public String title;
	//	Sets a default color of simple window
	public Color color = Color.lightGray;

	//	Simple window constructor which gets abstract coordinates with width, height and the title string
	public SimpleWindow(double sX, double sY, int width, int height, String title){

		//	Sets the start and the size dimensions
		this.start = new Dimension(sX,sY);
		this.size = new Dimension(width,height);
		//	Converts start coordinates from abstract to pixels
		this.start.convertToInt();
		//	Calculates the end coordinates from start and size dimensions
		this.end = new Dimension(this.start.getIntX()+this.size.getIntX(),this.start.getIntY()+this.size.getIntY());
		//	Converts the end and size dimensions to pixels to abstract
		this.end.convertToDouble();
		this.size.convertToDouble();
		// Sets the title and color
		this.title = title;
	}

	public void recalculateDimensions() {
		this.start.convertToInt();
		this.end.setIntX(this.start.getIntX()+this.size.getIntX());
		this.end.setIntY(this.start.getIntY()+this.size.getIntY());
		this.end.convertToDouble();
	}
}
