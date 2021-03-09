package midtermreview;

import org.junit.Test;
import static org.junit.Assert.*;

public class PizzaTest {
    
    public PizzaTest() {
    }

    @Test
    public void testGetTotalCostNoToppings() {
        // Arrange
        double expectedTotalCost = 8.5;
        
        // Act
        Pizza pizza = new Pizza(0, expectedTotalCost, 0);
        double actualCost = pizza.getTotalCost();
        
        // Assert
        assertEquals(expectedTotalCost, actualCost, .00001);
        
    }
    
    @Test
    public void testGetTotalCostLotsOToppings() {
        // Arrange
        double baseCost = 8.5;
        double expectedTotalCost = 11.50;
        double costPerTopping = 1;
        
        // Act
        Pizza pizza = new Pizza(0, baseCost, costPerTopping);
        pizza.addTopping("green peppers");
        pizza.addTopping("black olives");
        pizza.addTopping("onions");
        double actualCost = pizza.getTotalCost();
        
        // Assert
        assertEquals(expectedTotalCost, actualCost, .00001);
        
    }

}
