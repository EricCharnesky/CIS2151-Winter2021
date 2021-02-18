package chapter10;

public class Square extends Rectangle {
    
    
    public Square(int sideLength)
    {
        // you don't need to do this explicitly, it happens automatically with a no-arg constructor
        super();
        setSideLength(0, sideLength);
        
    }
    
    @Override
    public void setSideLength(int sideIndex, int sideLength)
    {
        super.setSideLength(0, sideLength);
        super.setSideLength(1, sideLength);
    }
    
    // can't have this  because it's marked as final
//    @Override 
//    public int getArea()
//    {
//     return 10;   
//    }
}
