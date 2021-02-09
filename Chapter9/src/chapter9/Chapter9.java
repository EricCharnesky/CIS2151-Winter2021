package chapter9;

import java.util.Arrays;
import java.util.Scanner;

public class Chapter9 {
    
    enum moods { HAPPY, SAD, GRUMPY, TIRED };

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        Card[] cards = { new Card(4), new Card(7), new Card(2) };
        
        // only works if you implement Comparable and have the compareTo(..) method
        Arrays.sort(cards);
        
        int[] values = { 3, 5, 8, 1, 10 };
        for(int value : values)
        {
            System.out.print(value + " ");
        }
        System.out.println("");
        Arrays.sort(values);
        for(int value : values)
        {
            System.out.print(value + " ");
        }
        System.out.println("");
        
        
        for ( moods mood : moods.values() )
        {
            System.out.println(mood + " : " + mood.ordinal());
        }
        
        System.out.println("moods.GRUMPY > moods.SAD : " + 
                (moods.GRUMPY.ordinal() > moods.SAD.ordinal()));
        
        System.out.println("Enter a number");
        /*
        int number = keyboard.nextInt();
        keyboard.nextLine(); // takes the enter key pressed after giving a number
        */
        
        // I prefer this way
        int number = Integer.parseInt(keyboard.nextLine());
        
        System.out.println("Enter your name");
        String name = keyboard.nextLine();
        
        System.out.printf("Hi %s, your favorite number is %d\n", name, number);
        System.out.println(String.format("Hi %s, your favorite number is %d", name, number));
        
        
        for ( int value = 0; value < 256; value++)
        {
            System.out.println(value + ": " + Integer.toBinaryString(value));
        }
        
        
    }
    
}
