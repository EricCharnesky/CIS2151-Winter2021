package project2;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;
    private Random random;
    
    public Deck() {
        cards = new ArrayList<Card>(52);
        
        // loops to create all the cards from enums
        
        random  = new Random();
    }

    public Card getRandomCard() {
        // gives number between 0 and the last index
        int randomIndex = random.nextInt(cards.size());
        return cards.remove(randomIndex);
    }
}
