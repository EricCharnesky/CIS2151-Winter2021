package project2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Project2 {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner keyboard = new Scanner(System.in);

        int playerMoney = 100;
        int computerMoney = 100;

        while (playerMoney > 0 && computerMoney > 0) {
            ArrayList<Card> playerCards = new ArrayList<Card>();
            ArrayList<Card> computerCards = new ArrayList<Card>();
            Deck deck = new Deck();
            for (int cardNumber = 0; cardNumber < 5; cardNumber++) {
                playerCards.add(deck.getRandomCard());
                computerCards.add(deck.getRandomCard());
            }
            PokerHand playerHand = new PokerHand(playerCards);
            PokerHand computerHand = new PokerHand(computerCards);

            playerMoney--;
            computerMoney--;
            int pot = 2;
            
            System.out.println("Player Money: $" + playerMoney);
            System.out.println("Computer Money: $" + computerMoney);

            System.out.println("Your hand: " + playerHand);

            System.out.println("Do you want to call or raise $1?");
            String choice = keyboard.nextLine();

            if (choice.equalsIgnoreCase("raise")) {
                playerMoney--;
                pot++;

                if (random.nextInt(2) == 0) {
                    System.out.println("Computer folds!");
                    playerMoney += pot;
                    continue;
                }
                System.out.println("Computer calls your raise!");
                computerMoney--;
                pot++;
            }

            System.out.println("Computer Hand: " + computerHand);

            if (playerHand.call(computerHand) == PokerHand.Result.WIN) {
                System.out.println("Player wins!");
                playerMoney += pot;
            } else if (playerHand.call(computerHand) == PokerHand.Result.LOSE) {
                System.out.println("Player loses!");
                computerMoney += pot;
            } else {
                System.out.println("Draw!");
                computerMoney += pot / 2;
                playerMoney += pot / 2;
            }

        }
    }

}
