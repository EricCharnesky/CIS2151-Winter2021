package project1.morning;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlaneTest {
    
    public PlaneTest() {
    }

    @Test
    public void testConstructorAndGets() {
        // Arrange
        String expectedModel = "747";
        int expectedMaxAltitude = 50_000;
        int expectedCurrentAltitude = Plane.STARTING_ALTITUDE_IN_MICHIGAN; // michigan
        
        // Act
        Plane plane = new Plane(expectedModel, expectedMaxAltitude);
        String actualModel = plane.getModel();
        int actualMaxAltitude = plane.getMaxAltitudeInFeet();
        int actualCurrentAltitude = plane.getCurrentAltitudeInFeet();
        boolean actualLandingGearStatus = plane.isLandingGearEnabled();
        
        // Assert
        assertEquals(expectedModel, actualModel);
        assertEquals(expectedMaxAltitude, actualMaxAltitude);
        assertEquals(expectedCurrentAltitude, actualCurrentAltitude);
        assertTrue(actualLandingGearStatus);
    }

    @Test
    public void testEnabledLandingGearWorks() {
        // Arrange
        
        // Act
        Plane plane = new Plane("", 10000);
        boolean actualEnableLandingGear = plane.enabledLandingGear();
        boolean actualLandingGearStatus = plane.isLandingGearEnabled();
        
        // Assert
        assertTrue(actualEnableLandingGear);
        assertTrue(actualLandingGearStatus);
    }
    
    @Test
    public void testEnabledLandingGearDoesNotWork() {
        // Arrange
        
        // Act
        Plane plane = new Plane("", 10000);
        plane.changeAltitude(2000);
        plane.disableLandingGear();
        boolean actualEnableLandingGear = plane.enabledLandingGear();
        boolean actualLandingGearStatus = plane.isLandingGearEnabled();
        
        // Assert
        assertFalse(actualEnableLandingGear);
        assertFalse(actualLandingGearStatus);
    }

    @Test
    public void testDisableLandingGearWorks() {
        // Arrange
        
        // Act
        Plane plane = new Plane("", 10000);
        plane.changeAltitude(2000);
        boolean actualDisableLandingGear = plane.disableLandingGear();
        boolean actualLandingGearStatus = plane.isLandingGearEnabled();
        
        // Assert
        assertTrue(actualDisableLandingGear);
        assertFalse(actualLandingGearStatus);
    }
    
    @Test
    public void testDisableLandingGearDoesNotWork() {
        // Arrange
        
        // Act
        Plane plane = new Plane("", 10000);
        boolean actualDisableLandingGear = plane.disableLandingGear();
        boolean actualLandingGearStatus = plane.isLandingGearEnabled();
        
        // Assert
        assertFalse(actualDisableLandingGear);
        assertTrue(actualLandingGearStatus);
    }

    @Test
    public void testChangeAltitudeGoingUpWorks() {
        // Arrange
        int changeInAltitude = 1000;
        int expectedAltitude = changeInAltitude + Plane.STARTING_ALTITUDE_IN_MICHIGAN ;
        
        // Act
        Plane plane = new Plane("", 10_000);
        boolean actualChangeAltitude = plane.changeAltitude(changeInAltitude);
        int actualCurrentAltitude = plane.getCurrentAltitudeInFeet();
        
        
        // Assert
        assertTrue(actualChangeAltitude);
        assertEquals(expectedAltitude, actualCurrentAltitude);
    }
    
    @Test
    public void testChangeAltitudeGoingAboveMaxDoesNotWork() {
        // Arrange
        int maxAltitude = 5000;
        int expectedAltitude = maxAltitude;
        
        // Act
        Plane plane = new Plane("", maxAltitude);
        boolean actualChangeAltitude = plane.changeAltitude(maxAltitude);
        int actualCurrentAltitude = plane.getCurrentAltitudeInFeet();
        
        // Assert
        assertFalse(actualChangeAltitude);
        assertEquals(expectedAltitude, actualCurrentAltitude);
    }
    
    @Test
    public void testChangeAltitudeGoingDownWorks() {
        // Arrange
        int changeInAltitude = -100;
        int expectedAltitude = Plane.STARTING_ALTITUDE_IN_MICHIGAN + changeInAltitude;
        
        // Act
        Plane plane = new Plane("", 10_000);
        boolean actualChangeAltitude = plane.changeAltitude(changeInAltitude);
        int actualCurrentAltitude = plane.getCurrentAltitudeInFeet();
        
        // Assert
        assertTrue(actualChangeAltitude);
        assertEquals(expectedAltitude, actualCurrentAltitude);
    }
    
    @Test
    public void testChangeAltitudeGoingDownStopsAt1000WithoutLandingGear() {
        // Arrange
        int expectedAltitude = 1000;
        
        // Act
        Plane plane = new Plane("", 10_000);
        plane.changeAltitude(expectedAltitude);
        plane.disableLandingGear();
        boolean actualChangeAltitude = plane.changeAltitude(-expectedAltitude);
        int actualCurrentAltitude = plane.getCurrentAltitudeInFeet();
        
        // Assert
        assertFalse(actualChangeAltitude);
        assertEquals(expectedAltitude, actualCurrentAltitude);
    }
    
}
