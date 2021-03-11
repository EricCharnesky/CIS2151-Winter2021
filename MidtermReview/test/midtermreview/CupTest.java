/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermreview;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EricC
 */
public class CupTest {
    
    public CupTest() {
    }

    @Test
    public void testFill() {
        // Arrange
        int expectedOunces = 42;
        
        // Act
        Cup cup = new Cup("", expectedOunces);
        cup.fill();
        int actualOunces = cup.getCurrentVolumeInOunces();
        
        // Assert
        assertEquals(expectedOunces, actualOunces);
    }

    @Test
    public void testDrinkSuccessful() {
        // Arrange
        String expectedMessage = "You drink some delicious coffee";
        
        // Act
        Cup cup = new Cup("coffee", 10);
        cup.fill();
        String actualMessage = cup.drink(10);
        
        // Assert
        assertEquals(expectedMessage, actualMessage);
    }
    
    @Test
    public void testDrinkFail() {
        // Arrange
        String expectedMessage = "You can't drink that much!";
        
        // Act
        Cup cup = new Cup("", 10);
        String actualMessage = cup.drink(10);
        
        // Assert
        assertEquals(expectedMessage, actualMessage);
    }
    
}
