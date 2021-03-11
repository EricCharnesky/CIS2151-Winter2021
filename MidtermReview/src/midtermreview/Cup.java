
package midtermreview;

public class Cup extends Beverage {

    public Cup(String name, int maxVOlumeInOunces) {
        super(name, maxVOlumeInOunces);
    }
    
    @Override
    public void fill() {
        currentVolumeInOunces = maxVolumeInOunces;
    }

    @Override
    public String drink(int ounces) {
        if ( ounces > currentVolumeInOunces )
        {
            return "You can't drink that much!";
        }
        return "You drink some delicious " + name;
    }
    
}
