package Code;

/**
 * Created by VinothPandianSermuga on 12-05-2017.
 */
public class Dimension {
    private int intX;


    private int intY;
    private double doubleX;
    private double doubleY;

    private int pixelX(double x, int width) {
        return (int) (x * width);
    }
    private double abstractX(double x, int width) {
        return x / width;
    }

    private int pixelY(double y, int height) {
        return (int) (y * height);
    }
    private double abstractY(double y, int height) {
        return y / height;
    }

    public Dimension(int x, int y){
        this.intX = x;
        this.intY = y;
    }

    public Dimension(double x, double y){
        this.doubleX = x;
        this.doubleY = y;
    }

    public void convertToDouble(Dimension winDim){
        this.doubleX = abstractX(this.intX,winDim.intX);
        this.doubleY = abstractY(this.intY,winDim.intY);
    }

    public void convertToInt(Dimension winDim){
        this.intX = pixelX(this.doubleX,winDim.intX);
        this.intY = pixelY(this.doubleY,winDim.intY);
    }

    public int getIntX() {
        return intX;
    }

    public void setIntX(int intX) {
        this.intX = intX;
    }

    public int getIntY() {
        return intY;
    }

    public void setIntY(int intY) {
        this.intY = intY;
    }

    public double getDoubleX() {
        return doubleX;
    }

    public void setDoubleX(double doubleX) {
        this.doubleX = doubleX;
    }

    public double getDoubleY() {
        return doubleY;
    }

    public void setDoubleY(double doubleY) {
        this.doubleY = doubleY;
    }
}
