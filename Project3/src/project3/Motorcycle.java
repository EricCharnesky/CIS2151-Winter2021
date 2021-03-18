
package project3;


public class Motorcycle extends Cart {
    
    public Motorcycle(Track track, int maxSpeed, int acceleration, int breakSpeed) {
        super(track, maxSpeed + 3, acceleration + 3, breakSpeed + 3);
    }
    
}
