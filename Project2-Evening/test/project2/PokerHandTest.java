
package project2;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class PokerHandTest {
    
    public PokerHandTest() {
    }

    @Test
    public void testCallFourOfAKind() {
        // Arrange
        ArrayList<Card> player1Cards = new ArrayList<Card>();
        player1Cards.add( new Card(Card.Face.SEVEN, Card.Suit.SPADES));
        player1Cards.add( new Card(Card.Face.SEVEN, Card.Suit.HEARTS));
        player1Cards.add( new Card(Card.Face.SEVEN, Card.Suit.CLUBS));
        player1Cards.add( new Card(Card.Face.SEVEN, Card.Suit.DIAMONDS));
        player1Cards.add( new Card(Card.Face.TEN, Card.Suit.SPADES));
        
        ArrayList<Card> player2Cards = new ArrayList<Card>();
        player2Cards.add( new Card(Card.Face.FIVE, Card.Suit.SPADES));
        player2Cards.add( new Card(Card.Face.FIVE, Card.Suit.HEARTS));
        player2Cards.add( new Card(Card.Face.FIVE, Card.Suit.CLUBS));
        player2Cards.add( new Card(Card.Face.FIVE, Card.Suit.DIAMONDS));
        player2Cards.add( new Card(Card.Face.TEN, Card.Suit.SPADES));
        
        PokerHand hand1 = new PokerHand(player1Cards);
        PokerHand hand2 = new PokerHand(player2Cards);
        PokerHand.Result expectedResultWin = PokerHand.Result.WIN;
        PokerHand.Result expectedResultLose = PokerHand.Result.LOSE;
        
        PokerHand.Rank expectedRank = PokerHand.Rank.FOUR_OF_A_KIND;
        
       
        // Act
        PokerHand.Result actualResultWin = hand1.call(hand2); 
        PokerHand.Result actualResultLose = hand2.call(hand1); 
        PokerHand.Rank actualRank = hand1.getHandRank();
        
        // Assert
        assertEquals(expectedResultWin, actualResultWin);
        assertEquals(expectedResultLose, actualResultLose);
        assertEquals(expectedRank, actualRank);
        
    }
    
    @Test
    public void testCallStraightFlush() {
        // Arrange
        ArrayList<Card> player1Cards = new ArrayList<Card>();
        player1Cards.add( new Card(Card.Face.SEVEN, Card.Suit.SPADES));
        player1Cards.add( new Card(Card.Face.EIGHT, Card.Suit.SPADES));
        player1Cards.add( new Card(Card.Face.NINE, Card.Suit.SPADES));
        player1Cards.add( new Card(Card.Face.TEN, Card.Suit.SPADES));
        player1Cards.add( new Card(Card.Face.JACK, Card.Suit.SPADES));
        
        ArrayList<Card> player2Cards = new ArrayList<Card>();
        player2Cards.add( new Card(Card.Face.SEVEN, Card.Suit.HEARTS));
        player2Cards.add( new Card(Card.Face.EIGHT, Card.Suit.HEARTS));
        player2Cards.add( new Card(Card.Face.NINE, Card.Suit.HEARTS));
        player2Cards.add( new Card(Card.Face.TEN, Card.Suit.HEARTS));
        player2Cards.add( new Card(Card.Face.SIX, Card.Suit.HEARTS));
        
        PokerHand hand1 = new PokerHand(player1Cards);
        PokerHand hand2 = new PokerHand(player2Cards);
        PokerHand.Result expectedResultWin = PokerHand.Result.WIN;
        PokerHand.Result expectedResultLose = PokerHand.Result.LOSE;
       
        // Act
        PokerHand.Result actualResultWin = hand1.call(hand2); 
        PokerHand.Result actualResultLose = hand2.call(hand1); 
        
        // Assert
        assertEquals(expectedResultWin, actualResultWin);
        assertEquals(expectedResultLose, actualResultLose);
        
    }
    
    @Test
    public void testCallStraightFlushTie() {
        // Arrange
        ArrayList<Card> player1Cards = new ArrayList<Card>();
        player1Cards.add( new Card(Card.Face.SEVEN, Card.Suit.SPADES));
        player1Cards.add( new Card(Card.Face.EIGHT, Card.Suit.SPADES));
        player1Cards.add( new Card(Card.Face.NINE, Card.Suit.SPADES));
        player1Cards.add( new Card(Card.Face.TEN, Card.Suit.SPADES));
        player1Cards.add( new Card(Card.Face.JACK, Card.Suit.SPADES));
        
        ArrayList<Card> player2Cards = new ArrayList<Card>();
        player2Cards.add( new Card(Card.Face.SEVEN, Card.Suit.HEARTS));
        player2Cards.add( new Card(Card.Face.EIGHT, Card.Suit.HEARTS));
        player2Cards.add( new Card(Card.Face.NINE, Card.Suit.HEARTS));
        player2Cards.add( new Card(Card.Face.TEN, Card.Suit.HEARTS));
        player2Cards.add( new Card(Card.Face.JACK, Card.Suit.HEARTS));
        
        PokerHand hand1 = new PokerHand(player1Cards);
        PokerHand hand2 = new PokerHand(player2Cards);
        PokerHand.Result expectedResultDraw = PokerHand.Result.DRAW;
       
        // Act
        PokerHand.Result actualResultDraw = hand1.call(hand2); 
        
        // Assert
        assertEquals(expectedResultDraw, actualResultDraw);
        
    }
    
}
