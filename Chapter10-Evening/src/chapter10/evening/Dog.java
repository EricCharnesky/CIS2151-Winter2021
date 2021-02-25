package chapter10.evening;

public class Dog extends Animal implements Moveable {

    private double weight;

    public Dog(String name, String color, double weight) {
        super(name, color);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String makeNoise() {
        if (weight < 15) {
            return "Yip!";
        }
        return "Woof!";
    }

    @Override
    public String walk() {
        return getName() + " pulls on your leash constantly";
    }

    @Override
    public String run() {
        return getName() + " chases after the nearest squirrel";
    }

}
