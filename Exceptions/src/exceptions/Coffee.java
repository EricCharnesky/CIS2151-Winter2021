package exceptions;

public class Coffee {

    private int mililiters;

    public Coffee(int mililiters) {
        this.mililiters = mililiters;
    }

    public void drink(int mililitersToDrink) {
        if (mililitersToDrink > mililiters) {
            // code stops executing at the exception
            throw new IllegalArgumentException("You can not drink more mililiters than are in the cup");
        }
        mililiters -= mililitersToDrink;
    }

    public int getMililiters() {
        return mililiters;
    }
    
    
}
