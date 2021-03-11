
package midtermreview;

import org.junit.Test;
import static org.junit.Assert.*;


public class PizzaPieTest {
    
    public PizzaPieTest() {
    }


    @Test
    public void testGetTotalCostNoToppings() {
        // Arrange
        double expectedCost = 7.5;
        
        
        // Act
        PizzaPie pizzaPie = new PizzaPie(expectedCost, 0);
        double actualCost = pizzaPie.getTotalCost();
        
        // Assert
        assertEquals(expectedCost, actualCost, .000001);
        
    }
    
    @Test
    public void testGetTotalCostWithToppings() {
        // Arrange
        double expectedCost = 11.5;
        
        
        // Act
        PizzaPie pizzaPie = new PizzaPie(7.5, 1);
        pizzaPie.addTopping("pepperoni");
        pizzaPie.addTopping("mushrooms");
        pizzaPie.addTopping("onions");
        pizzaPie.addTopping("green pepper");
        double actualCost = pizzaPie.getTotalCost();
        
        // Assert
        assertEquals(expectedCost, actualCost, .000001);
        
    }
    
}
