
package midtermreview;

public class Mug extends Beverage {
    
    private String color;

    public Mug(String name, int maxVOlumeInOunces, String color) {
        super(name, maxVOlumeInOunces);
        this.color = color;
    }
    
    @Override
    public void fill() {
        this.currentVolumeInOunces = maxVolumeInOunces;
    }

    @Override
    public String drink(int ounces) {
        if ( ounces > currentVolumeInOunces )
        {
            return "There is not enough coffee in your mug, that's sad for you!";
        }
        currentVolumeInOunces -= ounces;
        return "That was some delicious coffee!";
    }
    
}
