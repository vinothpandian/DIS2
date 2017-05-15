

/**
 * Data structure to store dimensions such as width, height or coordinates x,y
 * Manages both integers and floating points
 */

public class Dimension {

    //	Get the window system object
    private static WindowSystem windowSystem = WindowSystem.getInstance();

    //  integer dimensions x and y
    private int intX;
    private int intY;

    //  floating points x and y
    private double doubleX;
    private double doubleY;

    //  converts abstract coordinates to pixels for width
    private int pixelX(double x, int width) {
        return (int) (x * width);
    }

    //  converts pixels to abstract coordinates
    private double abstractX(double x, int width) {
        return x / width;
    }

    //  converts abstract coordinates to pixels for height
    private int pixelY(double y, int height) {
        return (int) (y * height);
    }

    //  converts pixels to abstract coordinates for height
    private double abstractY(double y, int height) {
        return y / height;
    }

    //  Constructor for integer x and y
    public Dimension(int x, int y){
        this.intX = x;
        this.intY = y;
    }

    //  Constructor for double x and y
    public Dimension(double x, double y){
        this.doubleX = x;
        this.doubleY = y;
    }

    //  Converts pixel coordinates to abstract coordinates
    public void convertToDouble(){
        this.doubleX = abstractX(this.intX,windowSystem.winDim.intX);
        this.doubleY = abstractY(this.intY,windowSystem.winDim.intY);
    }

    //  Converts abstract coordinates to pixel coordinates
    public void convertToInt(){
        this.intX = pixelX(this.doubleX,windowSystem.winDim.intX);
        this.intY = pixelY(this.doubleY,windowSystem.winDim.intY);
    }

    //  Getter for integer x
    public int getIntX() {
        return intX;
    }

    //  Setter for integer x
    public void setIntX(int intX) {
        this.intX = intX;
    }

    //  Getter for integer y
    public int getIntY() {
        return intY;
    }

    //  Setter for integer y
    public void setIntY(int intY) {
        this.intY = intY;
    }

    //  Getter for floating point x
    public double getDoubleX() {
        return doubleX;
    }

    //  Setter for floating point x
    public void setDoubleX(double doubleX) {
        this.doubleX = doubleX;
    }

    //  Getter for floating point y
    public double getDoubleY() {
        return doubleY;
    }

    //  Setter for floating point y
    public void setDoubleY(double doubleY) {
        this.doubleY = doubleY;
    }

}
