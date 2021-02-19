
package chapter10.evening;

import java.util.ArrayList;


public class Polygon {
    private ArrayList<Integer> sideLengths;
    
    public Polygon(int numberOfSides)
    {
        sideLengths = new ArrayList<Integer>(numberOfSides);
        for ( int index = 0; index < numberOfSides; index++ )
        {
            sideLengths.add(0);
        }
        
    }
    
    public void setSideLength(int index, int length)
    {
        sideLengths.set(index, length);
    }
    
    public int getSideLength(int index)
    {
        return sideLengths.get(index);
    }
    
    public int getPerimeter()
    {
        int perimeter = 0;
        for ( int length : sideLengths)
        {
            perimeter+= length;
        }
        return perimeter;
    }
        
}
