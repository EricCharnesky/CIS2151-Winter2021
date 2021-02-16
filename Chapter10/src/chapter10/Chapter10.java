package chapter10;

public class Chapter10 {
    
    public static void main(String[] args) {
        Rectangle myRectangle = new Rectangle();
        
        myRectangle.setSideLength(0, 5);
        myRectangle.setSideLength(1, 10);
        
        System.out.println(String.format("Rectangle perimeter: %d - Rectangle area: %d", 
                myRectangle.getPerimeter(), myRectangle.getArea()));
        
    }
    
}
