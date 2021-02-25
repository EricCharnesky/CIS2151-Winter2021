package chapter10;

// extends indicates inheritance
public class Rectangle extends Polygon {

    public Rectangle() {
        // calls the Polygon Constructor
        // super must be the FIRST thing you do in a sub class constructor
        // rectangles have 4 sides - yay
        super(4);
    }
    
    // constructor overload
    public Rectangle(int length, int width)
    {
        super(4);
        setSideLength(0, length);
        setSideLength(1, width);
    }

    @Override
    public void setSideLength(int sideIndex, int length) {
        if (sideIndex == 0 || sideIndex == 2) {
            super.setSideLength(0, length);
            super.setSideLength(2, length);
            // with protected access, you can access it directly
            sideLengths.set(0, length);
        } else if (sideIndex == 1 || sideIndex == 3) {
            super.setSideLength(1, length);
            super.setSideLength(3, length);
        }
    }

    // the final keywords prevents overrides
    public final int getArea() {
        return getSideLength(0) * getSideLength(1);
    }

}
