public class Rectangle {

    private double width;
    private double length;
    
    public Rectangle(double w, double l) {
        width = w;
        length = l;
    }

    //Getters

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getArea() {
        return length*width;
    }

    //Setters

    public void setWidth(double w) {
        width = w;
    }

    public void setLength(double l) {
        length = l;
    }
    
}
