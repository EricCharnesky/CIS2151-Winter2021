
package midtermreview;

public abstract class Beverage {
    
    protected String name;
    protected int maxVolumeInOunces;
    protected int currentVolumeInOunces;
    
    public Beverage(String name, int maxVOlumeInOunces)
    {
        this.name = name;
        this.maxVolumeInOunces = maxVOlumeInOunces;
    }

    public String getName() {
        return name;
    }

    public int getMaxVolumeInOunces() {
        return maxVolumeInOunces;
    }

    public int getCurrentVolumeInOunces() {
        return currentVolumeInOunces;
    }
    
    public abstract void fill();
    
    public abstract String drink(int ounces);
}
