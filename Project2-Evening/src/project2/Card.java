package project2;

public class Card implements Comparable<Card> {

    enum Face {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
        JACK, QUEEN, KING, ACE
    };

    enum Suit {
        CLUBS, HEARTS, SPADES, DIAMONDS
    };

    Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    Card(Card card) {
        face = card.face;
        suit = card.suit;
    }

    private Suit suit;
    private Face face;

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card o) {
        return face.ordinal() - o.face.ordinal();
    }
    
    @Override
    public String toString()
    {
        return face.toString() + " of " + suit.toString();
    }

}
