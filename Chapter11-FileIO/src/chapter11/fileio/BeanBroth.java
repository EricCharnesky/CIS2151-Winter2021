
package chapter11.fileio;

import java.io.Serializable;

public class BeanBroth implements Serializable {
    private String name;
    private int currentVolumeInMililiters;
    private int maxVolumeInMililiters;

    public BeanBroth(String name, int maxVolume) {
        this.name = name;
        this.maxVolumeInMililiters = maxVolume;
        this.currentVolumeInMililiters = 0;
    }
    
    public void fill()
    {
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

    public String getName() {
        return name;
    }

    public int getCurrentVolumeInMililiters() {
        return currentVolumeInMililiters;
    }

    public int getMaxVolumeInMililiters() {
        return maxVolumeInMililiters;
    }
    
    
}
