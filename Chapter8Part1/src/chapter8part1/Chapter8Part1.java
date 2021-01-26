package chapter8part1;

import java.util.Scanner;

public class Chapter8Part1 {

    public static void main(String[] args) {
        System.out.println("Happy Tuesday!");
        String again = "Y";
        
        Scanner keyboard = new Scanner(System.in);
        
        while ( again.equalsIgnoreCase("Y"))
        {
            System.out.println("Enter a radius");
            double radius = Double.parseDouble(keyboard.nextLine());
            System.out.println("The circumference of a cirlce with a radius of "
                    + radius + " is " + MathIsFun.calculateCircumference(radius));
            
            System.out.println("Do you want to caluclate another? ( Y/N )");
            again = keyboard.nextLine();
        }
        
        System.out.println("You used our amazing math function " 
                + MathIsFun.mathCounter + " times");
    }
    
}
