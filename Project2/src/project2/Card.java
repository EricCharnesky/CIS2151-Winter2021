
package project2;


public class Card implements Comparable<Card> {

    Card(Card card) {
        // do the copy constructor thing
    }

    enum Suit { CLUBS, HEARTS, SPADES, DIAMONDS }
    
    private Suit suit;

    public Suit getSuit() {
        return suit;
    }
    
    
    
    @Override
    public int compareTo(Card o) {
        // should look at face values!
        return 0;
    }
    
}
