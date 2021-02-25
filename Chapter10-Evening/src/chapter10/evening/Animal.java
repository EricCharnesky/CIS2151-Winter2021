
package chapter10.evening;

public abstract class Animal {
    
    private String name;
    private String color;
    
    public Animal(String name, String color)
    {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
    
    
    public abstract String makeNoise();
    
}
