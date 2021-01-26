package chapter6nightreview;

public class Vehicle {

    private final String make;
    private final String model;
    private String color;
    private final double gasTankCapacityInGallons;
    private double milesPerGallonAverage; // this changes in real life, but this isn't real life...
    private double actualGasInTank;

    public Vehicle(String make, String model, String color,
            double gasTankCapacityInGallons, double milesPerGallonAverage) {
        this.make = make;
        this.model = model;
        this.gasTankCapacityInGallons = gasTankCapacityInGallons;
        this.milesPerGallonAverage = milesPerGallonAverage;
        actualGasInTank = 0;
        setColor(color);
    }

    public boolean addGas(double gallonsOfGasToAdd) {
        if (gallonsOfGasToAdd >= 0) {
            actualGasInTank += gallonsOfGasToAdd;
            if (actualGasInTank > gasTankCapacityInGallons) {
                actualGasInTank = gasTankCapacityInGallons;
                return false;
                // youl should probably never use console print/read inside of classes
                // you would use an exception, except we don't know what that is? =(
                // System.out.println("ERROR BAD THING GAS ALL OVER AHHHH");
            }
            return true;
        }
        return false;
    }

    public boolean drive(double milesToDrive) {
        double gasNeeded = milesToDrive / milesPerGallonAverage;
        if ( gasNeeded > actualGasInTank) {
            return false;
        }
        actualGasInTank -= gasNeeded;
        return true;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getGasTankCapacityInGallons() {
        return gasTankCapacityInGallons;
    }

    public double getMilesPerGallonAverage() {
        return milesPerGallonAverage;
    }

    public double getActualGasInTank() {
        return actualGasInTank;
    }
}
