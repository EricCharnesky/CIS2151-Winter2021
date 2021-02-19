package project2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Project2 {

    public static void main(String[] args) {
        int playerMoney = 100;
        int computerMoney = 100;
        Random random = new Random();
        ArrayList<Card> playerCards;
        ArrayList<Card> computerCards;
        Deck deck;
        PokerHand playerHand;
        PokerHand computerHand;
        Scanner keyboard = new Scanner(System.in);

        while (playerMoney > 0 && computerMoney > 0) {
            deck = new Deck();

            int pot = 2;
            playerMoney--;
            computerMoney--;

            playerCards = new ArrayList<Card>(5);
            computerCards = new ArrayList<Card>(5);
            for (int cardNumber = 0; cardNumber < 5; cardNumber++) {
                playerCards.add(deck.getRandomCard());
                computerCards.add(deck.getRandomCard());
            }

            playerHand = new PokerHand(playerCards);
            computerHand = new PokerHand(computerCards);

            System.out.println("Player has $" + playerMoney);
            System.out.println("Computer has $" + computerMoney);
            
            System.out.println("PlayerHand: " + playerHand);

            System.out.println("Do you want raise or call?");
            String choice = keyboard.nextLine();

            if (choice.equalsIgnoreCase("raise")) {
                pot++;
                playerMoney--;

                if (random.nextInt(2) == 0) {
                    System.out.println("Computer folds!");
                    playerMoney += pot;
                    continue; // goes back to the top of the loop
                } else {
                    System.out.println("Computer calls!");
                    computerMoney--;
                    pot++;

                }

            }

            System.out.println("Computer Hand: " + computerHand);

            PokerHand.Result result = playerHand.call(computerHand);
            if (result == PokerHand.Result.WIN) {
                System.out.println("You win!");
                playerMoney += pot;
            } else if (result == PokerHand.Result.LOSE) {
                System.out.println("You lose!");
                computerMoney += pot;
            } else {
                System.out.println("You draw!");
                computerMoney += pot / 2;
                playerMoney += pot / 2;
            }

        }

    }
}


