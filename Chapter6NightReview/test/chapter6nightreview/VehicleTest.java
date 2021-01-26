package chapter6nightreview;

import org.junit.Test;
import static org.junit.Assert.*;

public class VehicleTest {
    
    public VehicleTest() {
    }

    @Test
    public void testAddGas() {
        // AAA format - Arrange - Act - Assert
        
        // Arrange - setup all the variables we need for testing
        double expectedGasInTankInGallons = 4.2;
        
        // Act - call the code we're testing
        Vehicle vehicle = new Vehicle("", "", "", 5, 1);
        boolean addGasResult = vehicle.addGas(expectedGasInTankInGallons);
        double actualGasInTankInGallons = vehicle.getActualGasInTank();
        
        // Assert - did we get what we expected?
        assertEquals(expectedGasInTankInGallons, actualGasInTankInGallons, .000001);
        assertTrue(addGasResult);
    }
    
    @Test
    public void testAddGasOverCapacity() {
        // AAA format - Arrange - Act - Assert
        
        // Arrange - setup all the variables we need for testing
        double expectedGasInTankInGallons = 2;
        
        // Act - call the code we're testing
        Vehicle vehicle = new Vehicle("", "", "", 2, 1);
        boolean addGasResult = vehicle.addGas(4.2);
        double actualGasInTankInGallons = vehicle.getActualGasInTank();
        
        // Assert - did we get what we expected?
        assertEquals(expectedGasInTankInGallons, actualGasInTankInGallons, .000001);
        assertFalse(addGasResult);
        assertEquals(false, addGasResult);
    }
    
    @Test
    public void testAddGasNegativeValue() {
        // AAA format - Arrange - Act - Assert
        
        // Arrange - setup all the variables we need for testing
        double expectedGasInTankInGallons = 0;
        
        // Act - call the code we're testing
        Vehicle vehicle = new Vehicle("", "", "", 5, 1);
        boolean addGasResult = vehicle.addGas(-1);
        double actualGasInTankInGallons = vehicle.getActualGasInTank();
        
        // Assert - did we get what we expected?
        assertEquals(expectedGasInTankInGallons, actualGasInTankInGallons, .000001);
        assertFalse(addGasResult);
    }

    @Test
    public void testDrive() {
        // AAA format - Arrange - Act - Assert
        
        // Arrange - setup all the variables we need for testing
        double expectedGallonsInTank = 4;
        
        // Act - call the code we're testing
        Vehicle vehicle = new Vehicle("", "", "", 5, 10);
        vehicle.addGas(5);
        boolean driveResult = vehicle.drive(10);
        double actualGasInTank = vehicle.getActualGasInTank();
        
        // Assert - did we get what we expected?
        assertEquals(expectedGallonsInTank, actualGasInTank, .000001);
        assertTrue(driveResult);
    }
    
    @Test
    public void testDriveTooFar() {
        // AAA format - Arrange - Act - Assert
        
        // Arrange - setup all the variables we need for testing
        double expectedGallonsInTank = 5;
        
        // Act - call the code we're testing
        Vehicle vehicle = new Vehicle("", "", "", expectedGallonsInTank, 10);
        vehicle.addGas(expectedGallonsInTank);
        boolean driveResult = vehicle.drive(100);
        double actualGasInTank = vehicle.getActualGasInTank();
        
        // Assert - did we get what we expected?
        assertEquals(expectedGallonsInTank, actualGasInTank, .000001);
        assertFalse(driveResult);
    }

    @Test
    public void testSetColor() {
        // AAA format - Arrange - Act - Assert
        
        // Arrange - setup all the variables we need for testing
        String expectedColor = "Blue Jean Metalic";
        
        // Act - call the code we're testing
        Vehicle vehicle = new Vehicle("", "", expectedColor, 1, 1);
        // this happens in the constructor anyway 
        // vehicle.setColor(expectedColor);
        String actualColor = vehicle.getColor();
        
        // Assert - did we get what we expected?
        assertEquals(expectedColor, actualColor);
        
        
    }

    @Test
    public void testGetMake() {
        // AAA format - Arrange - Act - Assert
        
        // Arrange - setup all the variables we need for testing
        String expectedMake = "Ford";
        
        // Act - call the code we're testing
        Vehicle vehicle = new Vehicle(expectedMake, "", "", 1, 1);
        String actualMake = vehicle.getMake();
        
        // Assert - did we get what we expected?
        assertEquals(expectedMake, actualMake);
    }

    @Test
    public void testGetModel() {
        // AAA format - Arrange - Act - Assert
        
        // Arrange - setup all the variables we need for testing
        String expectedModel = "Transit";
        
        // Act - call the code we're testing
        Vehicle vehicle = new Vehicle("", expectedModel, "", 1, 1);
        String actualModel = vehicle.getModel();
        
        // Assert - did we get what we expected?
        assertEquals(expectedModel, actualModel);
    }

    @Test
    public void testGetGasTankCapacityInGallons() {
        // AAA format - Arrange - Act - Assert
        
        // Arrange - setup all the variables we need for testing
        double expectedGasTankCapacityInGallons = 4.2;
        
        // Act - call the code we're testing
        Vehicle vehicle = new Vehicle("", "", "", expectedGasTankCapacityInGallons, 1);
        double actualGasTankCapacityInGallons = vehicle.getGasTankCapacityInGallons();
        
        // Assert - did we get what we expected?
        assertEquals(expectedGasTankCapacityInGallons, actualGasTankCapacityInGallons, .000001);
    }

    @Test
    public void testGetMilesPerGallonAverage() {
        // AAA format - Arrange - Act - Assert
        
        // Arrange - setup all the variables we need for testing
        double expectedMilesPerGallonAverage = 4.2;
        
        // Act - call the code we're testing
        Vehicle vehicle = new Vehicle("", "", "", 1, expectedMilesPerGallonAverage);
        double actualMilesPerGallonAverage = vehicle.getMilesPerGallonAverage();
        
        // Assert - did we get what we expected?
        assertEquals(expectedMilesPerGallonAverage, actualMilesPerGallonAverage, .000001);
    }
    
}
