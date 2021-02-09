package project1.morning;

public class Plane {
    
    public static final int STARTING_ALTITUDE_IN_MICHIGAN = 600;

    private static final int FEET_AT_WHICH_LANDING_GEAR_MUST_BE_ON = 1000;
    
    private int maxAltitudeInFeet;
    private boolean landingGearEnabled;
    private String model;
    private int currentAltitudeInFeet;

    public Plane(String model, int maxAltitudeInFeet) {
        this.model = model;
        this.maxAltitudeInFeet = maxAltitudeInFeet;
        this.currentAltitudeInFeet = STARTING_ALTITUDE_IN_MICHIGAN;
        landingGearEnabled = true;
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
    
    public boolean enabledLandingGear()
    {
        if ( currentAltitudeInFeet <= FEET_AT_WHICH_LANDING_GEAR_MUST_BE_ON )
        {
            landingGearEnabled = true;
            return true;
        }
        return false;
    }
    
    public boolean disableLandingGear()
    {
        if ( currentAltitudeInFeet >= FEET_AT_WHICH_LANDING_GEAR_MUST_BE_ON)
        {
            landingGearEnabled = false;
            return true;
        }
        return false;
    }
    
    public boolean changeAltitude(int changeInFeet)
    {
        // going up
        if ( changeInFeet > 0 )
        {
            currentAltitudeInFeet += changeInFeet;
            if ( currentAltitudeInFeet > maxAltitudeInFeet)
            {
                currentAltitudeInFeet = maxAltitudeInFeet;
                return false;
            }
            return true;
        }
        else
        {   // or !landingGearEnabled
            if ( landingGearEnabled == false && currentAltitudeInFeet + changeInFeet < FEET_AT_WHICH_LANDING_GEAR_MUST_BE_ON )
            {
                currentAltitudeInFeet = FEET_AT_WHICH_LANDING_GEAR_MUST_BE_ON;
                return false;
            }
            currentAltitudeInFeet += changeInFeet;
            return true;
        }
        
    }
    
}
