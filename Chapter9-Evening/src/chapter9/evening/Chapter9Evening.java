package chapter9.evening;

import java.util.Arrays;
import java.util.Scanner;

public class Chapter9Evening {

    public static void main(String[] args) {
        Card[] cards = new Card[]{new Card(2), new Card(5),
            new Card(7), new Card(3), new Card(3)};

        System.out.println("Cards pre-sort");
        for (Card card : cards) {
            System.out.println(card.getFace());
        }

        Arrays.sort(cards);

        System.out.println("Cards post-sort");
        for (Card card : cards) {
            System.out.println(card.getFace());
        }

        System.out.println("Numbers pre-sort");
        int[] numbers = new int[]{2, 5, 7, 3, 3};
        for (int number : numbers) {
            System.out.println(number);
        }

        Arrays.sort(numbers);

        System.out.println("Numbers post-sort");
        for (int number : numbers) {
            System.out.println(number);
        }

        int number = 42;
        double value = 3.1415926;

        Integer myNumber = 42;
        int myOtherNumber = new Integer(42);

        boolean compare = new Integer(42) == 42;

        char letter = 'A';

        boolean isTired = true;

        String name = "Eric Charnesky";
        String otherName = "Eric Charnesky";

        // == for references compared if memory address is the same
        System.out.println("name == otherName: " + name == otherName);

        String lastName = name.substring(5);
        System.out.println(lastName);

        System.out.println("Enter your name");
        Scanner keyboard = new Scanner(System.in);

        String inputName = keyboard.nextLine().trim();
        int indexOfSpace = inputName.indexOf(" ");
        String inputFirstName = "";
        String inputLastName = "";

        if (indexOfSpace > 0) {
            inputFirstName = inputName.substring(0, indexOfSpace);
            inputLastName = inputName.substring(indexOfSpace + 1);
        }
        if (inputFirstName.isEmpty() || inputLastName.isEmpty()) {
            System.out.println("Unable to determine first and last name");
        } else {
            System.out.println("First Name: " + inputFirstName);
            System.out.println("Last Name: " + inputLastName);
        }

        // terribly inefficent to repeatedly append to strings
        // creates a new string in memory every time it changes
//        String result = "";
//        for (value = 0; value < 10; value++) {
//            System.out.println("Enter something");
//            result += value + ": " + keyboard.nextLine();
//        }
//
//        System.out.println(result);
//
//        // StringBuilder doesn't have to create a new string in memory ever time it changes
//        StringBuilder stringBuilder = new StringBuilder();
//        for (value = 0; value < 10; value++) {
//            System.out.println("Enter something");
//            stringBuilder.append(value);
//            stringBuilder.append(": ");
//            stringBuilder.append(keyboard.nextLine());
//        }
//        
//        System.out.println(stringBuilder);
//        
        System.out.println("Enter a sentence and we will scramble it into a secret message");
        String message = keyboard.nextLine();

        String scrambled = scramble(message);
        System.out.println(scrambled);

        String unscrambled = unscramble(scrambled);
        
        System.out.println(unscrambled);
        
        
        String[] words = message.split(" ");
        
        StringBuilder scrambledWords = new StringBuilder();
        
        for ( String word : words )
        {
            scrambledWords.append(scramble(word));
            scrambledWords.append(" ");
        }
        
        System.out.println(scrambledWords);
        
        System.out.println(scramble(scrambledWords.toString()));
        

    }
    
    public static String scramble(String message)
    {
        StringBuilder scrambler = new StringBuilder();

        for (int index = 0; index < message.length(); index += 2) {
            scrambler.append(message.substring(index, index + 1));
        }
        for (int index = 1; index < message.length(); index += 2) {
            scrambler.append(message.substring(index, index + 1));
        }
        
        return scrambler.toString();
    }
    
    public static String unscramble(String scrambled)
    {
        int evenIndex = 0;
        int oddIndex = scrambled.length() - scrambled.length() / 2;

        StringBuilder unscrambled = new StringBuilder();

        while (evenIndex * 2 < scrambled.length()) {
            unscrambled.append(scrambled.substring(evenIndex, evenIndex + 1));
            if (oddIndex < scrambled.length()) {
                unscrambled.append(scrambled.substring(oddIndex, oddIndex + 1));
            }
            evenIndex++;
            oddIndex++;

        }
        
        return unscrambled.toString();

    }

}
