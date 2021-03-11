
package midtermreview;

public abstract class StuffedAnimal {
    
    private boolean batteryHasPower;
    private String name;

    public String getName() {
        return name;
    }
   
    public boolean doesBatteryHasPower() {
        return batteryHasPower;
    }
    
    abstract String makeNoise();
}
