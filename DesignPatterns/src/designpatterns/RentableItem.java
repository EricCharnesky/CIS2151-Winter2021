
package designpatterns;


public class RentableItem {
    private double rent;
    private String name;
    
    public RentableItem(String name, double rent){
        this.name = name;
        this.rent = rent;
    }

    public double getRent() {
        return rent;
    }

    public String getName() {
        return name;
    }
    
    
}
