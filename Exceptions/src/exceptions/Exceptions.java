package exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.naming.InvalidNameException;

public class Exceptions {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int number;

        while (true) {
            try {
                System.out.println("Enter a number");
                number = Integer.parseInt(keyboard.nextLine());
                break;
                // catch ( Exception (superclass) is considered bad form
            } catch (NumberFormatException exception) {
                System.out.println("That's not a number, please try again");
            } 
        }

        System.out.println("Your number is: " + number);
        
        
        Coffee cup = new Coffee(500);
        cup.drink(number);
        
        System.out.println("your coffee has " + cup.getMililiters() + " mililiters left");
        
        File someFile = new File("test.txt");
        
        
        try {
            Scanner fileReader = new Scanner(someFile);
        }
        // use the pipe to have multile exception types
        catch ( FileNotFoundException | IllegalArgumentException exception )
        {
            System.out.println(exception.getMessage());
        }
        // finally always runs after either the try or the catch
        finally{
            
        }
        
    }

}
