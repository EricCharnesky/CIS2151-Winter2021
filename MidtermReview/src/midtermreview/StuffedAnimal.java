/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermreview;

/**
 *
 * @author EricC
 */
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
