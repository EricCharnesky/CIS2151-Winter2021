
package project3;


public class Motorcycle extends Cart {
    
    public Motorcycle(int maxSpeed, int acceleration, int breakSpeed) {
        super(maxSpeed + 3, acceleration + 3, breakSpeed + 3);
    }
    
}
