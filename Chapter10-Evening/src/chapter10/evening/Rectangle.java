package chapter10.evening;

public class Rectangle extends Polygon {
    // with inheritance, the super class constructor gets called automatically

    public Rectangle() {
        // call to superclass construtor must be the first thing you do in a subclass constuctor
        super(4); // calls the Polygon constructor
    }

    public void setWidth(int width) {
        super.setSideLength(1, width);
        super.setSideLength(3, width);
    }

    public void setLength(int length) {
        super.setSideLength(0, length);
        super.setSideLength(2, length);
    }

    @Override
    public void setSideLength(int index, int length) {
        if (index == 0 || index == 2) {
            setLength(length);
        } else {
            setWidth(length);
        }
    }

    public int getArea() {
        return getSideLength(0) * getSideLength(1);
    }

}
