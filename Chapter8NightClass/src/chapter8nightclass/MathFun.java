package chapter8nightclass;

public class MathFun {
    public static final double PI_APROX = 3.14159;
    public static int counter = 0;
    
    public static double calculateAreaOfCircle(double radius)
    {
        counter++;
        return PI_APROX * radius * radius;
    }
}
