
package designpatterns;


public class TaxableItem {
    private String name;
    private double cost;
    private static double taxRate = 1.06;
    
    public TaxableItem(String name, double cost){
        this.name = name;
        this.cost = cost;
    }
    
    public double getTotalCost(){
        return cost * taxRate;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public static double getTaxRate() {
        return taxRate;
    }
    
    
}
