package chapter9;

import java.util.Arrays;
import java.util.Scanner;

public class Chapter9 {

    enum moods {
        HAPPY, SAD, GRUMPY, TIRED
    };

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        Card[] cards = {new Card(4), new Card(7), new Card(2)};

        // only works if you implement Comparable and have the compareTo(..) method
        Arrays.sort(cards);

        int[] values = {3, 5, 8, 1, 10};
        for (int value : values) {
            System.out.print(value + " ");
        }
        System.out.println("");
        Arrays.sort(values);
        for (int value : values) {
            System.out.print(value + " ");
        }
        System.out.println("");

        for (moods mood : moods.values()) {
            System.out.println(mood + " : " + mood.ordinal());
        }

        System.out.println("moods.GRUMPY > moods.SAD : "
                + (moods.GRUMPY.ordinal() > moods.SAD.ordinal()));

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

        for (int value = 0; value < 256; value++) {
            System.out.println(value + ": " + Integer.toBinaryString(value));
        }

        System.out.println("What's the weather like?");
        String weather = keyboard.nextLine();

        // indexOf tells us the starting index or -1 if it's missing
        if (weather.toLowerCase().indexOf("sunny") >= 0) {
            System.out.println("Don't forget your sunscreen");
        }

//        
//        // this is very memory inefficient - it keeps making new copies to chagne it
//        String result = "";
//        
//        for ( number = 0; number < 10; number++)
//        {
//            System.out.println("enter a value");
//            result += keyboard.nextLine() + " ";
//        }
//        
//        System.out.println(result);
//        
//        
//        // string builder is memory efficient and doesn't have to make copies every change
//        StringBuilder builder = new StringBuilder();
//        
//        for ( number = 0; number < 10; number++)
//        {
//            System.out.println("enter a value");
//            builder.append(keyboard.nextLine());
//            builder.append(" ");
//        }
//        
//        System.out.println(builder);
//        
        System.out.println("Enter a word for us to turn into a secret message");
        String originalMessage = keyboard.nextLine();
        
        String secretMessage = scramble(originalMessage);
        System.out.println(secretMessage);
        System.out.println(secretMessage.length());

        
        String newMessage = unscrable(secretMessage);
        System.out.println(newMessage);
        
        
        StringBuilder scrambledWords = new StringBuilder();
        String[] words = newMessage.split(" ");
        for ( String word : words )
        {
            scrambledWords.append(scramble(word));
            scrambledWords.append(" ");

        }
        
        System.out.println(scramble(scrambledWords.toString()));

    }
    
    
    public static String scramble(String toScramble)
    {
        StringBuilder secretMessage = new StringBuilder();

        for (int evenIndex = 0; evenIndex < toScramble.length(); evenIndex += 2) {
            secretMessage.append(toScramble.substring(evenIndex, evenIndex + 1));
        }
        for (int oddIndex = 1; oddIndex < toScramble.length(); oddIndex += 2) {
            secretMessage.append(toScramble.substring(oddIndex, oddIndex + 1));
        }
        
        return secretMessage.toString();

    }
    
    public static String unscrable(String toUnscrable)
    {
        StringBuilder newMessage = new StringBuilder();
        int evenIndexStart = 0;
        int oddIndexStart = toUnscrable.length() - toUnscrable.length() / 2;

        while (evenIndexStart * 2 < toUnscrable.length()) {
            newMessage.append(toUnscrable.substring(evenIndexStart, evenIndexStart + 1));
            if (oddIndexStart < toUnscrable.length()) {
                newMessage.append(toUnscrable.substring(oddIndexStart, oddIndexStart + 1));
            }
            evenIndexStart++;
            oddIndexStart++;
        }
        
        return newMessage.toString();
    }

}
