package project1;

public class Plane {

    private final int maxAltitudeInFeet;
    private boolean landingGearEnabled;
    private final String model;
    private int currentAltitudeInFeet;
    private final int landingGearThresholdAltitude;

    public Plane(String model, int maxAltitudeInFeet) {
        currentAltitudeInFeet = 0;
        landingGearEnabled = true;
        this.model = model;
        this.maxAltitudeInFeet = maxAltitudeInFeet;
        landingGearThresholdAltitude = 1000;
    }

    public boolean enableLandingGear() {
        if (currentAltitudeInFeet <= landingGearThresholdAltitude) {
            landingGearEnabled = true;
            return true;
        }
        return false;
    }

    public boolean disableLandingGear() {
        if (currentAltitudeInFeet >= landingGearThresholdAltitude) {
            landingGearEnabled = false;
            return true;
        }
        return false;
    }

    public boolean changeAltitutde(int change) {
        currentAltitudeInFeet += change;
        if (change > 0) {
            if (currentAltitudeInFeet > maxAltitudeInFeet) {
                currentAltitudeInFeet = maxAltitudeInFeet;
                return false;
            }
            return true;
        } else {
            if ( !landingGearEnabled && currentAltitudeInFeet < landingGearThresholdAltitude )
            {
                currentAltitudeInFeet = landingGearThresholdAltitude;
                return false;
            }
            return true;
        }
    }

    public int getMaxAltitudeInFeet() {
        return maxAltitudeInFeet;
    }

    public boolean isLandingGearEnabled() {
        return landingGearEnabled;
    }

    public String getModel() {
        return model;
    }

    public int getCurrentAltitudeInFeet() {
        return currentAltitudeInFeet;
    }

}
