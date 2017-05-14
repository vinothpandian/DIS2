package Code;

import java.awt.*;

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
public class SimpleWindow{

	public Dimension start;
	public Dimension end;
	public Dimension size;
	public String title;
	public Color color;

	public SimpleWindow(double sX, double sY, int width, int height, String title){
		this.start = new Dimension(sX,sY);
		this.size = new Dimension(width,height);
		this.end = new Dimension(0,0);
		this.title = title;
		this.color = Color.gray;
	}

	public void calculateDimensions(Dimension winDim){
		this.start.convertToInt(winDim);
		this.end.setIntX(this.start.getIntX()+this.size.getIntX());
		this.end.setIntY(this.start.getIntY()+this.size.getIntY());
		this.end.convertToDouble(winDim);
	}
}
