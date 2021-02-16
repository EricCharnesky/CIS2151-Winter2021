package chapter10;

import java.util.ArrayList;

public class Polygon {

    private final int numberOfSides;
    private final ArrayList<Integer> sideLengths;

    public Polygon(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        sideLengths = new ArrayList<Integer>(numberOfSides);
        // add default lenghts of 0
        for (int index = 0; index < numberOfSides; index++) {
            sideLengths.add(0);
        }
    }

    public void setSideLength(int sideIndex, int length) {
        if (sideIndex < 0 || sideIndex >= sideLengths.size()) {
            throw new IndexOutOfBoundsException();
        }
        sideLengths.set(sideIndex, length);
    }

    public int getSideLength(int sideIndex) {
        if (sideIndex < 0 || sideIndex >= sideLengths.size()) {
            throw new IndexOutOfBoundsException();
        }
        return sideLengths.get(sideIndex);
    }

    public int getPerimeter() {
        int perimeter = 0;
        for (int sideLength : sideLengths) {
            perimeter += sideLength;
        }
        return perimeter;
    }
}
