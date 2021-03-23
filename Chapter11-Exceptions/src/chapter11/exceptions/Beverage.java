package chapter11.exceptions;

public class Beverage {

    private int maxVolumeInMililiters;
    private int currentVolumeInMililiters;

    public Beverage(int maxVolumeInMililiters) {
        this.maxVolumeInMililiters = maxVolumeInMililiters;
        currentVolumeInMililiters = 0;
    }

    public void fill() {
        currentVolumeInMililiters = maxVolumeInMililiters;
    }

    public void drink(int mililitersToDrink) {
        if ( mililitersToDrink > currentVolumeInMililiters ){
            // bad form, don't do this!
            //System.out.println("YOU CAN'T DRINK THAT MUCH!!!!");
            
            throw new IllegalArgumentException("Not enough left in the cup");
        }
        
        currentVolumeInMililiters -= mililitersToDrink;
    }
}
