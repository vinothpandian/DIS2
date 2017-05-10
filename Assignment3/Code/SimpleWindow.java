package Code;

import static javafx.scene.input.KeyCode.Y;

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

    public double positionX;
    public double positionY;
    public int width;
    public int height;
    public String title;

    public SimpleWindow(double positionX, double positionY, int width, int height, String title) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.width= width;
        this.height = height;
        this.title = title;
    }

    public SimpleWindow(int width, int height, String title) {
        this(0, 0, width, height, title);
    }

    public SimpleWindow(String title) {
        this(0,0,200,200,title);
    }

    public void move(double posX, double posY){
        this.positionX = (double) posX;
        this.positionY = (double) posY;
    }

}
