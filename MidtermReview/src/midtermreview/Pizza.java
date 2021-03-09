package midtermreview;

import java.util.ArrayList;

public class Pizza {

    private ArrayList<String> toppings;
    private int numberOfSlices;
    private double baseCost;
    private double pricePerTopping;

    public Pizza(int numberOfSlices, double baseCost, double pricePerTopping) {
        toppings = new ArrayList<String>();
        this.numberOfSlices = numberOfSlices;
        this.baseCost = baseCost;
        this.pricePerTopping = pricePerTopping;

    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public double getTotalCost() {
        return baseCost + (toppings.size() * pricePerTopping);
    }

    public ArrayList<String> getToppings() {
        return new ArrayList<String>(toppings);
    }

    public int getNumberOfSlices() {
        return numberOfSlices;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public double getPricePerTopping() {
        return pricePerTopping;
    }
}
