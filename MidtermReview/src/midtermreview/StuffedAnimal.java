package midtermreview;

public abstract class StuffedAnimal {

    protected boolean batteryHasPower;

    public StuffedAnimal(String name) {
        this.name = name;
        batteryHasPower = true;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void changeBattery() {
        batteryHasPower = true;
    }

    public boolean doesBatteryHasPower() {
        return batteryHasPower;
    }

    abstract String makeNoise();
}
