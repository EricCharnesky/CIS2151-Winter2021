package chapter11.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
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
            } catch (Exception exception) {
                System.out.println("That shouldn't have happened");
            }
        }

        System.out.println("Your number is: " + number);

        Beverage coffee = new Beverage(500);
        try {
            coffee.drink(1000);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        File someFile = new File("someFile.txt");
        try {
            Scanner fileReader = new Scanner(someFile);
        } catch (FileNotFoundException exception) {
            System.out.println(exception);
        } finally { // runs either after try or catch - so it always runs
            
        }

    }
}
