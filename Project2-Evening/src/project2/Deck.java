package project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;
    private Random random;
    
    public Deck() {
        cards = new ArrayList<Card>(52);
        
        for ( Card.Face face : Card.Face.values())
        {
            for ( Card.Suit suit : Card.Suit.values() )
            {
                cards.add( new Card( face, suit));
            }
        }
        
        // some people found shuffle
        // Collections.shuffle(cards);
        
        random  = new Random();
    }

    public Card getRandomCard() {
        // gives number between 0 and the last index
        int randomIndex = random.nextInt(cards.size());
        return cards.remove(randomIndex);
    }
}
