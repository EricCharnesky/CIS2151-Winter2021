package project2;

import java.util.ArrayList;
import java.util.Collections;

public class PokerHand {

    private ArrayList<Card> cards;

    public PokerHand(ArrayList<Card> cards) {
        for (Card card : cards) {
            this.cards.add(new Card(card));
        }

        Collections.sort(this.cards);
    }

    enum Rank {
        HIGH_CARD, PAIR, TWO_PAIR, THREE_OF_A_KIND,
        STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH
    };

    enum Result {
        WIN, DRAW, LOSE
    };

    public Result call(PokerHand otherHand) {
        if (getHandRank().ordinal() > otherHand.getHandRank().ordinal()) {
            return Result.WIN;
        }

        if (getHandRank().ordinal() < otherHand.getHandRank().ordinal()) {
            return Result.LOSE;
        }

        // TIE BREAK!!! - figure out which rank and tie break
        return Result.LOSE;
    }

    public Rank getHandRank() {
        if (isStraightFlush()) {
            return Rank.STRAIGHT_FLUSH;
        }
        if (isFourOfAKind()) {
            return Rank.FOUR_OF_A_KIND;
        }
        if (isFullHouse()) {
            return Rank.FULL_HOUSE;
        }

        /*
        ....
        ....
         */
        return Rank.HIGH_CARD;
    }

    private boolean isStraightFlush() {
        return false;
    }

    private boolean isFourOfAKind() {
        return false;
    }

    private boolean isFullHouse() {
        return false;
    }

    private boolean isFlush() {
        return cards.get(0).getSuit() == cards.get(1).getSuit();
    }
}
