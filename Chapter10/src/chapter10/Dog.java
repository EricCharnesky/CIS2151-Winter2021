
package chapter10;


public class Dog extends Animal implements Pet, Moveable{

    private double weight;
    
    public Dog(String name, String color, double weight){
        super(name, color);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
    
    @Override
    public String makeNoise() {
        if ( weight <= 15){
            return "Yip";
        }
        return "Woof";
    }

    @Override
    public String pet() {
        return getName() + " starts scratching is back leg quickly";
    }

    @Override
    public String playWithToy() {
        return getName() + " starts ripping into the new toy and it shreds, time to buy another";
    }

    @Override
    public String run() {
        return getName() + " quickly outpaces you and pees on a mailbox";
    }

    @Override
    public String walk() {
        return getName() + " pulls constantaly on the leash and you think your arm is going to fall off";
    }
    
}
