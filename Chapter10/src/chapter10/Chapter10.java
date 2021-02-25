package chapter10;

import java.util.ArrayList;

public class Chapter10 {

    public static void main(String[] args) {
        Rectangle myRectangle = new Rectangle();

        myRectangle.setSideLength(0, 5);
        myRectangle.setSideLength(1, 10);

        System.out.println(String.format("Rectangle perimeter: %d - Rectangle area: %d",
                myRectangle.getPerimeter(), myRectangle.getArea()));

        ArrayList<Polygon> shapes = new ArrayList<Polygon>();

        shapes.add(new Polygon(4));
        shapes.add(new Rectangle());
        shapes.add(new Square(10));

        shapes.get(0).setSideLength(0, 4);
        shapes.get(0).setSideLength(1, 2);
        shapes.get(0).setSideLength(2, 7);
        shapes.get(0).setSideLength(3, 5);

        shapes.get(1).setSideLength(0, 7);
        shapes.get(1).setSideLength(1, 4);

        shapes.get(2).setSideLength(0, 9);

        for (Polygon shape : shapes) {
            System.out.println(shape.getPerimeter());
        }
        
        
        Animal dog = new Dog("Fido", "Golden", 20);
        System.out.println(dog.makeNoise());
        
        Dog otherDog = new Dog("Bingo", "black and white", 50);
        
        Sleep quietSleeper = () -> "zzzzzzz";
        
        SomeMath multiply = ( first, second) -> first * second;
        
        multiply.math(5, 20);
        
        // can't use lambda on an interface with more than the 1 method
        // it's not a 'functional' interface
        // Pet angryPet = () -> 
        
        System.out.println(quietSleeper.sleep());

    }
    
    
    class Snore implements Sleep
    {

        @Override
        public String sleep() {
            return "aaaaaarrrrrrggggggg";
        }
        
    }

}
