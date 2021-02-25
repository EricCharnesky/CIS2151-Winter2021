package chapter10.evening;

import java.util.ArrayList;

public class Chapter10Evening {

    public static void main(String[] args) {
        Polygon shape = new Polygon(5);
        shape.setSideLength(0, 1);
        shape.setSideLength(1, 2);
        shape.setSideLength(2, 3);
        shape.setSideLength(3, 4);
        shape.setSideLength(4, 5);

        System.out.println("Your shape's perimeter is: " + shape.getPerimeter());

        Rectangle rectangle = new Rectangle();

        rectangle.setWidth(5);
        rectangle.setLength(10);

        System.out.println("Your rectangle's perimeter is: " + rectangle.getPerimeter());
        System.out.println("Your rectangle's area is: " + rectangle.getArea());
        
        
        
        ArrayList<Polygon> shapes = new ArrayList<Polygon>();
        shapes.add(shape);
        shapes.add(rectangle);
        shapes.add( new Square(7));
        
        shapes.get(0).setSideLength(0, 5);
        shapes.get(1).setSideLength(0, 5);
        shapes.get(2).setSideLength(0, 5);
        
        for( Polygon polygon : shapes)
        {
            System.out.println("perimeter of shape " + polygon.getPerimeter());
        }
        
        
        Dog dog = new Dog("Fido", "brown", 20);
        System.out.println(dog.walk());
        
        // you can still use polymorphism with interfaces and classes that implement them
        ArrayList<Moveable> dogWalkerSchedule = new ArrayList<Moveable>();
        
        dogWalkerSchedule.add(dog);
        
        // can't create instances of Animal diretly - it's abstract
        
        
        Addition addition = new Addition();
        addition.funWithNumbers(1, 2);
        
        // lambda notation for annoymous inner class
        SomeMath subtraction = (a, b) -> a - b;
        
        
        // can't do with with interfaces with more than one method
        // Moveable cat = () -> "meow";
        
        
        subtraction.funWithNumbers(2, 4);
    }
    
    static class Addition implements SomeMath
    {
        @Override
        public int funWithNumbers(int a, int b) {
            return a + b;
        }
    }

}
