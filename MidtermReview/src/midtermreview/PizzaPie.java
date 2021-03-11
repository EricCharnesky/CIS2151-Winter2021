
package midtermreview;

import java.util.ArrayList;

/**

Pizza has an ArrayList of type string to store the toppings
an integer value for number of slices
a double for base cost
a double for price per topping

a method addTopping that adds a a string value for the topping to the array list of toppings
a method getTotalCost that returns the base cost and price per topping * number of toppings

Write a unit test for getTotalCost

 */
public class PizzaPie {
    
    private ArrayList<String> toppings;
    private double baseCost;
    private double pricePerTopping;
    
    public PizzaPie(double baseCost, double pricePerTopping)
    {
        this.baseCost = baseCost;
        this.pricePerTopping= pricePerTopping;
        toppings = new ArrayList<String>();
    }
    
    public void addTopping(String topping)
    {
        toppings.add(topping);
    }
    
    public double getTotalCost()
    {
        return baseCost + pricePerTopping * toppings.size();
    }
    
    
    
}
