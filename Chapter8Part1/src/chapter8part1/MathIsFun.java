package chapter8part1;

public class MathIsFun {

    public static final double PI_APROX = 3.14159;
    
    public static int mathCounter = 0;
    
    public static double calculateCircumference(double radius)
    {
        mathCounter++;
        return PI_APROX * radius * 2;
    }
}
