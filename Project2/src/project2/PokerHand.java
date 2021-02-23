package project2;

// sourced from Eric's github, the url won't paste and I don't want to hand type it
import java.util.ArrayList;
import java.util.Collections;

public class PokerHand {

    private ArrayList<Card> cards;

    private int[] countOfFaces;

    public PokerHand(ArrayList<Card> cards) {
        this.cards = new ArrayList<Card>(5);

        for (Card card : cards) {
            this.cards.add(new Card(card));
        }

        Collections.sort(this.cards);

        countOfFaces = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (Card card : cards) {
            countOfFaces[card.getFace().ordinal()]++;
        }
    }

    enum Rank {
        HIGH_CARD, PAIR, TWO_PAIR, THREE_OF_A_KIND,
        STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH
    };

    enum Result {
        WIN, DRAW, LOSE
    };

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getHandRank().toString());
        builder.append(" - ");
        for (Card card : cards) {
            builder.append(card.toString());
            builder.append(" ");
        }
        return builder.toString();
    }

    public Result call(PokerHand otherHand) {
        if (getHandRank().ordinal() > otherHand.getHandRank().ordinal()) {
            return Result.WIN;
        }

        if (getHandRank().ordinal() < otherHand.getHandRank().ordinal()) {
            return Result.LOSE;
        }

        // TIE BREAK!!!
        if (getHandRank() == Rank.STRAIGHT_FLUSH || getHandRank() == Rank.STRAIGHT) {
            if (cards.get(0).getFace().ordinal() > otherHand.cards.get(0).getFace().ordinal()) {
                return Result.WIN;
            }
            if (cards.get(0).getFace().ordinal() < otherHand.cards.get(0).getFace().ordinal()) {
                return Result.LOSE;
            }
            return Result.DRAW;
        }

        if (getHandRank() == Rank.FOUR_OF_A_KIND) {
            int myFourOfKindOrdinal = getIndexForFaceXTimes(4);
            int otherFourOfKindOrdinal = otherHand.getIndexForFaceXTimes(4);
            if (myFourOfKindOrdinal > otherFourOfKindOrdinal) {
                return Result.WIN;
            }
            if (myFourOfKindOrdinal < otherFourOfKindOrdinal) {
                return Result.LOSE;
            }
            return Result.DRAW;
        }

        if (getHandRank() == Rank.FLUSH) {
            return tieBreakAllFiveCards(otherHand);
        }

        if (getHandRank() == Rank.THREE_OF_A_KIND || getHandRank() == Rank.FULL_HOUSE) {
            int myThreeOfKindOrdinal = getIndexForFaceXTimes(3);
            int otherThreeOfKindOrdinal = otherHand.getIndexForFaceXTimes(3);
            if (myThreeOfKindOrdinal > otherThreeOfKindOrdinal) {
                return Result.WIN;
            }
            if (myThreeOfKindOrdinal < otherThreeOfKindOrdinal) {
                return Result.LOSE;
            }
            return Result.DRAW;
        }

        if (getHandRank() == Rank.TWO_PAIR) {
            int myLowerPairOrdinal = getIndexForFaceXTimes(2);
            int otherLowerPairOrdinal = otherHand.getIndexForFaceXTimes(2);

            int myHigherPairOrdinal = getIndexForHigherPair();
            int otherHigherPairOrdinal = otherHand.getIndexForHigherPair();

            if (myHigherPairOrdinal > otherHigherPairOrdinal) {
                return Result.WIN;
            }
            if (myHigherPairOrdinal < otherHigherPairOrdinal) {
                return Result.LOSE;
            }

            if (myLowerPairOrdinal > otherLowerPairOrdinal) {
                return Result.WIN;
            }
            if (myLowerPairOrdinal < otherLowerPairOrdinal) {
                return Result.LOSE;
            }

            return tieBreakAllFiveCards(otherHand);

        }

        if (getHandRank() == Rank.PAIR) {
            int myPairOrdinal = getIndexForFaceXTimes(2);
            int otherPairOrdinal = otherHand.getIndexForFaceXTimes(2);

            if (myPairOrdinal > otherPairOrdinal) {
                return Result.WIN;
            }
            if (myPairOrdinal < otherPairOrdinal) {
                return Result.LOSE;
            }
            return tieBreakAllFiveCards(otherHand);

        }

        // if we haven't tie breaked already, it must be high card
        return tieBreakAllFiveCards(otherHand);

    }

    private Result tieBreakAllFiveCards(PokerHand otherHand) {
        for (int index = cards.size() - 1; index >= 0; index--) {
            if (cards.get(index).getFace().ordinal() > otherHand.cards.get(index).getFace().ordinal()) {
                return Result.WIN;
            }
            if (cards.get(index).getFace().ordinal() < otherHand.cards.get(index).getFace().ordinal()) {
                return Result.LOSE;
            }
        }

        return Result.DRAW;
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
        if (isFlush()) {
            return Rank.FLUSH;
        }
        if (isStraight()) {
            return Rank.STRAIGHT;
        }
        if (isThreeOfAKind()) {
            return Rank.THREE_OF_A_KIND;
        }
        if (isTwoPair()) {
            return Rank.TWO_PAIR;
        }
        if (isPair()) {
            return Rank.PAIR;
        }

        return Rank.HIGH_CARD;
    }

    private boolean isStraightFlush() {
        return isFlush() && isStraight();
    }

    private boolean isFourOfAKind() {
        return checkForFaceXTimes(4);
    }

    private boolean isFullHouse() {
        return isThreeOfAKind() && isPair();
    }

    private boolean isFlush() {
        return cards.get(0).getSuit() == cards.get(1).getSuit()
                && cards.get(1).getSuit() == cards.get(2).getSuit()
                && cards.get(2).getSuit() == cards.get(3).getSuit()
                && cards.get(3).getSuit() == cards.get(4).getSuit();
    }

    private boolean isStraight() {
        return cards.get(0).getFace().ordinal() == cards.get(1).getFace().ordinal() - 1
                && cards.get(1).getFace().ordinal() == cards.get(2).getFace().ordinal() - 1
                && cards.get(2).getFace().ordinal() == cards.get(3).getFace().ordinal() - 1
                && cards.get(3).getFace().ordinal() == cards.get(4).getFace().ordinal() - 1;
    }

    private boolean isThreeOfAKind() {
        return checkForFaceXTimes(3);
    }

    private boolean isTwoPair() {
        int pairCount = 0;
        for (int faceCount : countOfFaces) {
            if (faceCount == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    private boolean isPair() {
        return checkForFaceXTimes(2);
    }

    private boolean checkForFaceXTimes(int times) {
        for (int faceCount : countOfFaces) {
            if (faceCount == times) {
                return true;
            }
        }
        return false;
    }

    private int getIndexForFaceXTimes(int times) {
        for (int index = 0; index < countOfFaces.length; index++) {
            if (countOfFaces[index] == times) {
                return index;
            }
        }
        return -1;
    }

    private int getIndexForHigherPair() {
        for (int index = countOfFaces.length; index >= 0; index--) {
            if (countOfFaces[index] == 2) {
                return index;
            }
        }
        return -1;
    }
}
