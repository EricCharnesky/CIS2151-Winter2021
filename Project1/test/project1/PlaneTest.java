package project1;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlaneTest {
    
    public PlaneTest() {
    }
    
    @Test
    public void testPlaneConstructor()
    {
        // Arrange
        int expectedMaxAltitude = 10000;
        String expectedModel = "747";
        int expectedAltitude = 0;
        
        // Act
        Plane plane = new Plane(expectedModel, expectedMaxAltitude);
        int actualMaxAltitude = plane.getMaxAltitudeInFeet();
        int actualCurrentAlitude = plane.getCurrentAltitudeInFeet();
        boolean actualLandingGearEnabled = plane.isLandingGearEnabled();
        String actualModel = plane.getModel();
        
        // Assert
        assertTrue(actualLandingGearEnabled);
        assertEquals(expectedModel, actualModel);
        assertEquals(expectedAltitude, actualCurrentAlitude);
        assertEquals(expectedMaxAltitude, actualMaxAltitude);
        
    }

    @Test
    public void testEnableLandingGearWorks() {
        // Arrange
        
        // Act
        Plane plane = new Plane("", 10000);
        boolean actualEnabledLandingGear = plane.enableLandingGear();
        boolean actualLandingGearEnabled = plane.isLandingGearEnabled();
        
        assertTrue(actualLandingGearEnabled);
        assertTrue(actualEnabledLandingGear);
        
    }
    
    @Test
    public void testEnableLandingGearDoesntEnable() {
        // Arrange
        
        // Act
        Plane plane = new Plane("", 10000);
        plane.changeAltitutde(2000);
        boolean actualEnabledLandingGear = plane.enableLandingGear();
        
        assertFalse(actualEnabledLandingGear);
    }

    @Test
    public void testDisableLandingGearWorks() {
        // Arrange
        
        // Act
        Plane plane = new Plane("", 10000);
        plane.changeAltitutde(2000);
        boolean actualDisableLandingGear = plane.disableLandingGear();
        boolean actualIsLandingGearEnabled = plane.isLandingGearEnabled();
        
        assertTrue(actualDisableLandingGear);
        assertFalse(actualIsLandingGearEnabled);
    }
    
    @Test
    public void testDisableLandingGearDoesntDisable() {
        // Arrange
        
        // Act
        Plane plane = new Plane("", 10000);
        boolean actualDisableLandingGear = plane.disableLandingGear();
        
        assertFalse(actualDisableLandingGear);
    }

    @Test
    public void testChangeAltitutdeGoesUp() {
        // Arrange
        int expectedAltitude = 5280;
        
        // Act
        Plane plane = new Plane("", 10000);
        boolean actualChangeAlitude = plane.changeAltitutde(expectedAltitude);
        int actualAltitude = plane.getCurrentAltitudeInFeet();
        
        // Assert
        assertTrue(actualChangeAlitude);
        assertEquals(expectedAltitude, actualAltitude);
    }
    
    @Test
    public void testChangeAltitutdeGoesUpOverMax() {
        // Arrange
        int expectedAltitude = 5280;
        
        // Act
        Plane plane = new Plane("", expectedAltitude);
        boolean actualChangeAlitude = plane.changeAltitutde(expectedAltitude*2);
        int actualAltitude = plane.getCurrentAltitudeInFeet();
        
        // Assert
        assertFalse(actualChangeAlitude);
        assertEquals(expectedAltitude, actualAltitude);
    }
    
    @Test
    public void testChangeAltitutdeGoesDown() {
        // Arrange
        int expectedAltitude = 5280;
        int change = 100;
        // Act
        Plane plane = new Plane("", 10000);
        plane.changeAltitutde(expectedAltitude+change);
        boolean actualChangeAlitude = plane.changeAltitutde(-change);
        int actualAltitude = plane.getCurrentAltitudeInFeet();
        
        // Assert
        assertTrue(actualChangeAlitude);
        assertEquals(expectedAltitude, actualAltitude);
    }
    
    @Test
    public void testChangeAltitutdeGoesDownStopsAt1000WithoutLandingGearEnabled() {
        // Arrange
        int expectedAltitude = 1000;

        // Act
        Plane plane = new Plane("", 10000);
        plane.changeAltitutde(2000);
        plane.disableLandingGear();
        boolean actualChangeAlitude = plane.changeAltitutde(-2000);
        int actualAltitude = plane.getCurrentAltitudeInFeet();
        
        // Assert
        assertFalse(actualChangeAlitude);
        assertEquals(expectedAltitude, actualAltitude);
    }
    
}
