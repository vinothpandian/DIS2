package Code;

/**
 * Created by VinothPandianSermuga on 12-05-2017.
 */
public class Dimension {
    private int intX;


    private int intY;
    private double doubleX;
    private double doubleY;

    private int pixelX(double coordX, int width) {
        return (int) (coordX * width);
    }
    private double abstractX(double coordX, int width) {
        return coordX / width;
    }

    private int pixelY(double coordY, int height) {
        return (int) (coordY * height);
    }
    private double abstractY(double coordY, int height) {
        return coordY / height;
    }

    public Dimension(int width, int height){
        this.intX = width;
        this.intY = height;
    }

    public Dimension(double width, double height){
        this.doubleX = width;
        this.doubleY = height;
    }

    public void convertAbstract(Dimension winDim){
        this.doubleX = abstractX(this.intX,winDim.intX);
        this.doubleY = abstractY(this.intY,winDim.intY);
    }

    public void convertPixels(Dimension winDim){
        this.intX = pixelX(this.doubleX,winDim.intX);
        this.intY = pixelY(this.doubleY,winDim.intY);
    }


    public int getPixelX() {
        return intX;
    }

    public int getPixelY() {
        return intY;
    }
    
    public double getAbstractX() {
        return doubleX;
    }

    public double getAbstractY() {
        return doubleY;
    }

    public void setPixelX(int intX) {
        this.intX = intX;
    }

    public void setPixelY(int intY) {
        this.intY = intY;
    }

    public void setAbstractX(double doubleX) {
        this.doubleX = doubleX;
    }

    public void setAbstractY(double doubleY) {
        this.doubleY = doubleY;
    }
    
    

}
