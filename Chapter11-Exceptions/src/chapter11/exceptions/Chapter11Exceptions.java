package chapter11.exceptions;

import java.util.Scanner;

public class Chapter11Exceptions {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int number = -1;

        boolean failed = true;
        
        while (failed) {
            System.out.println("Enter a number");

            try {
                number = Integer.parseInt(keyboard.nextLine());
                failed = false;
                
            } catch (NumberFormatException exception) {
                System.out.println("That isn't a number!");
            }
        }
        
        System.out.println("Your number is: " + number);
        
        
        Beverage coffee = new Beverage(500);
        coffee.drink(1000);
    }
}
