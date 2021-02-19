package project2;

// sourced from Eric's github, the url won't paste and I don't want to hand type it
import java.util.ArrayList;
import java.util.Collections;

public class PokerHand {

    private ArrayList<Card> cards;
    private int[] faceCounts;

    public PokerHand(ArrayList<Card> cards) {
        this.cards = new ArrayList<Card>(5);
        faceCounts = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (Card card : cards) {
            this.cards.add(new Card(card));
            faceCounts[card.getFace().ordinal()]++;
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

        if (getHandRank() == Rank.FOUR_OF_A_KIND) {
            int myFourOfAKindIndex = getIndexOfFaceCount(4);
            int theirFourOfAKindIndex = otherHand.getIndexOfFaceCount(4);

            if (myFourOfAKindIndex > theirFourOfAKindIndex) {
                return Result.WIN;
            }
            return Result.LOSE;

        }

        if (getHandRank() == Rank.STRAIGHT || getHandRank() == Rank.STRAIGHT_FLUSH) {
            if (cards.get(0).getFace().ordinal() < otherHand.cards.get(0).getFace().ordinal()) {
                return Result.LOSE;
            }
            if (cards.get(0).getFace().ordinal() > otherHand.cards.get(0).getFace().ordinal()) {
                return Result.WIN;
            }
            return Result.DRAW;
        }

        if (getHandRank() == Rank.FLUSH) {
            return checkHighToLowCard(otherHand);
        }

        if (getHandRank() == Rank.THREE_OF_A_KIND || getHandRank() == Rank.FULL_HOUSE) {
            int myThreeOfAKindIndex = getIndexOfFaceCount(3);
            int theirThreeOfAKindIndex = otherHand.getIndexOfFaceCount(3);

            if (myThreeOfAKindIndex > theirThreeOfAKindIndex) {
                return Result.WIN;
            }
            return Result.LOSE;
        }

        if (getHandRank() == Rank.TWO_PAIR) {
            int myIndexOfHighPair = getIndexOfHighPair();
            int theirIndexOfHighPair = otherHand.getIndexOfHighPair();

            if (myIndexOfHighPair > theirIndexOfHighPair) {
                return Result.WIN;
            }
            if (myIndexOfHighPair < theirIndexOfHighPair) {
                return Result.LOSE;
            }

            int myIndexOfLowPair = getIndexOfFaceCount(2);
            int theirIndexOfLowPair = otherHand.getIndexOfFaceCount(2);

            if (myIndexOfLowPair > theirIndexOfLowPair) {
                return Result.WIN;
            }
            if (myIndexOfLowPair < theirIndexOfLowPair) {
                return Result.LOSE;
            }

            return checkHighToLowCard(otherHand);

        }

        if (getHandRank() == Rank.PAIR) {
            int myThreeOfAKindIndex = getIndexOfFaceCount(2);
            int theirThreeOfAKindIndex = otherHand.getIndexOfFaceCount(2);

            if (myThreeOfAKindIndex > theirThreeOfAKindIndex) {
                return Result.WIN;
            }
            if (myThreeOfAKindIndex < theirThreeOfAKindIndex) {
                return Result.LOSE;
            }
            return checkHighToLowCard(otherHand);
        }

        // default high card
        return checkHighToLowCard(otherHand);
    }

    private Result checkHighToLowCard(PokerHand otherHand) {
        for (int index = 4; index >= 0; index--) {
            if (cards.get(index).getFace().ordinal() > otherHand.cards.get(index).getFace().ordinal()) {
                return Result.WIN;
            }
            if (cards.get(index).getFace().ordinal() < otherHand.cards.get(index).getFace().ordinal()) {
                return Result.LOSE;
            }
        }
        return Result.DRAW;
    }

    private int getIndexOfHighPair() {
        int indexOfHighPair = 0;
        for (int index = faceCounts.length; index >= 0; index--) {
            if (faceCounts[index] == 2) {
                indexOfHighPair = index;
            }
        }
        return indexOfHighPair;

    }

    private int getIndexOfFaceCount(int count) {
        int indexOfHighPair = 0;
        for (int index = 0; index < faceCounts.length; index++) {
            if (faceCounts[index] == count) {
                indexOfHighPair = index;
            }
        }
        return indexOfHighPair;
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
        return isStraight() && isFlush();
    }

    private boolean isFourOfAKind() {
        for (int faceCount : faceCounts) {
            if (faceCount == 4) {
                return true;
            }
        }
        return false;
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
        return cards.get(0).getFace().ordinal() == (cards.get(1).getFace().ordinal() - 1)
                && cards.get(1).getFace().ordinal() == (cards.get(2).getFace().ordinal() - 1)
                && cards.get(2).getFace().ordinal() == (cards.get(3).getFace().ordinal() - 1)
                && cards.get(3).getFace().ordinal() == (cards.get(4).getFace().ordinal() - 1);
    }

    private boolean isThreeOfAKind() {
        for (int faceCount : faceCounts) {
            if (faceCount == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean isTwoPair() {
        int pairCount = 0;
        for (int faceCount : faceCounts) {
            if (faceCount == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    private boolean isPair() {
        for (int faceCount : faceCounts) {
            if (faceCount == 2) {
                return true;
            }
        }
        return false;
    }

    
    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getHandRank().toString());
        stringBuilder.append(" - ");
        
        for ( Card card : cards)
        {
            stringBuilder.append(card.toString());
            stringBuilder.append(", ");
        }
        // trim the last 2 ,_ characters
        return stringBuilder.substring(0, stringBuilder.length()-2);
    }
}
