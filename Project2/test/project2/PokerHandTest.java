package project2;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;


public class PokerHandTest {
    
    public PokerHandTest() {
    }
    
    @Test
    public void testCallStraightFlush() {
        // Arrange
        ArrayList<Card> playerCards = new ArrayList<Card>();
        playerCards.add(new Card(Card.Face.NINE, Card.Suit.SPADES));
        playerCards.add(new Card(Card.Face.TEN, Card.Suit.SPADES));
        playerCards.add(new Card(Card.Face.JACK, Card.Suit.SPADES));
        playerCards.add(new Card(Card.Face.QUEEN, Card.Suit.SPADES));
        playerCards.add(new Card(Card.Face.KING, Card.Suit.SPADES));
        
        ArrayList<Card> otherCards = new ArrayList<Card>();
        otherCards.add(new Card(Card.Face.EIGHT, Card.Suit.HEARTS));
        otherCards.add(new Card(Card.Face.NINE, Card.Suit.HEARTS));
        otherCards.add(new Card(Card.Face.TEN, Card.Suit.HEARTS));
        otherCards.add(new Card(Card.Face.JACK, Card.Suit.HEARTS));
        otherCards.add(new Card(Card.Face.QUEEN, Card.Suit.HEARTS));
        
        PokerHand playerHand = new PokerHand(playerCards);
        PokerHand otherHand = new PokerHand(otherCards);
        
        PokerHand.Rank expectedRank = PokerHand.Rank.STRAIGHT_FLUSH;
        PokerHand.Result expectedWin = PokerHand.Result.WIN;
        PokerHand.Result expectedLose = PokerHand.Result.LOSE;
        
        // Act
        PokerHand.Rank actualRank = playerHand.getHandRank();
        PokerHand.Result actaulWin = playerHand.call(otherHand);
        PokerHand.Result actaulLose = otherHand.call(playerHand);
        
        // Assert
        
        assertEquals(expectedRank, actualRank);
        assertEquals(expectedWin, actaulWin);
        assertEquals(expectedLose, actaulLose);  
    }
    
    @Test
    public void testCallStraightFlushDraw() {
        // Arrange
        ArrayList<Card> playerCards = new ArrayList<Card>();
        playerCards.add(new Card(Card.Face.NINE, Card.Suit.SPADES));
        playerCards.add(new Card(Card.Face.TEN, Card.Suit.SPADES));
        playerCards.add(new Card(Card.Face.JACK, Card.Suit.SPADES));
        playerCards.add(new Card(Card.Face.QUEEN, Card.Suit.SPADES));
        playerCards.add(new Card(Card.Face.KING, Card.Suit.SPADES));
        
        ArrayList<Card> otherCards = new ArrayList<Card>();
        otherCards.add(new Card(Card.Face.EIGHT, Card.Suit.HEARTS));
        otherCards.add(new Card(Card.Face.NINE, Card.Suit.HEARTS));
        otherCards.add(new Card(Card.Face.TEN, Card.Suit.HEARTS));
        otherCards.add(new Card(Card.Face.JACK, Card.Suit.HEARTS));
        otherCards.add(new Card(Card.Face.QUEEN, Card.Suit.HEARTS));
        
        PokerHand playerHand = new PokerHand(playerCards);
        PokerHand otherHand = new PokerHand(otherCards);
        
        PokerHand.Rank expectedRank = PokerHand.Rank.STRAIGHT_FLUSH;
        PokerHand.Result expectedWin = PokerHand.Result.WIN;
        PokerHand.Result expectedLose = PokerHand.Result.LOSE;
        
        // Act
        PokerHand.Rank actualRank = playerHand.getHandRank();
        PokerHand.Result actaulWin = playerHand.call(otherHand);
        PokerHand.Result actaulLose = otherHand.call(playerHand);
        
        // Assert
        
        assertEquals(expectedRank, actualRank);
        assertEquals(expectedWin, actaulWin);
        assertEquals(expectedLose, actaulLose);  
    }

    @Test
    public void testCallFourOfAKind() {
       // Arrange
        ArrayList<Card> playerCards = new ArrayList<Card>();
        playerCards.add(new Card(Card.Face.NINE, Card.Suit.SPADES));
        playerCards.add(new Card(Card.Face.TEN, Card.Suit.SPADES));
        playerCards.add(new Card(Card.Face.JACK, Card.Suit.SPADES));
        playerCards.add(new Card(Card.Face.QUEEN, Card.Suit.SPADES));
        playerCards.add(new Card(Card.Face.KING, Card.Suit.SPADES));
        
        ArrayList<Card> otherCards = new ArrayList<Card>();
        otherCards.add(new Card(Card.Face.KING, Card.Suit.HEARTS));
        otherCards.add(new Card(Card.Face.NINE, Card.Suit.HEARTS));
        otherCards.add(new Card(Card.Face.TEN, Card.Suit.HEARTS));
        otherCards.add(new Card(Card.Face.JACK, Card.Suit.HEARTS));
        otherCards.add(new Card(Card.Face.QUEEN, Card.Suit.HEARTS));
        
        PokerHand playerHand = new PokerHand(playerCards);
        PokerHand otherHand = new PokerHand(otherCards);
        
        PokerHand.Rank expectedRank = PokerHand.Rank.STRAIGHT_FLUSH;
        PokerHand.Result expectedDraw = PokerHand.Result.DRAW;
        
        // Act
        PokerHand.Rank actualRank = playerHand.getHandRank();
        PokerHand.Result actualDraw = playerHand.call(otherHand);
        
        // Assert
        
        assertEquals(expectedRank, actualRank);
        assertEquals(expectedDraw, actualDraw);
    }
    
    @Test
    public void testCallFourOfAKindBeatsFullHouse() {
       // Arrange
        ArrayList<Card> playerCards = new ArrayList<Card>();
        playerCards.add(new Card(Card.Face.NINE, Card.Suit.SPADES));
        playerCards.add(new Card(Card.Face.NINE, Card.Suit.HEARTS));
        playerCards.add(new Card(Card.Face.NINE, Card.Suit.CLUBS));
        playerCards.add(new Card(Card.Face.NINE, Card.Suit.DIAMONDS));
        playerCards.add(new Card(Card.Face.KING, Card.Suit.SPADES));
        
        ArrayList<Card> otherCards = new ArrayList<Card>();
        otherCards.add(new Card(Card.Face.KING, Card.Suit.DIAMONDS));
        otherCards.add(new Card(Card.Face.KING, Card.Suit.HEARTS));
        otherCards.add(new Card(Card.Face.KING, Card.Suit.CLUBS));
        otherCards.add(new Card(Card.Face.QUEEN, Card.Suit.HEARTS));
        otherCards.add(new Card(Card.Face.QUEEN, Card.Suit.DIAMONDS));
        
        PokerHand playerHand = new PokerHand(playerCards);
        PokerHand otherHand = new PokerHand(otherCards);
        
        PokerHand.Result expectedWin = PokerHand.Result.WIN;
        PokerHand.Result expectedLose = PokerHand.Result.LOSE;
        
        // Act
        PokerHand.Result actualWin = playerHand.call(otherHand);
        PokerHand.Result actaulLose = otherHand.call(playerHand);
        
        // Assert
        assertEquals(expectedWin, actualWin);
        assertEquals(expectedLose, actaulLose);  
    }
    
}
