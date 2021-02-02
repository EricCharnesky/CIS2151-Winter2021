package chapter8part1;

import java.util.ArrayList;

public class Portfolio {

    private ArrayList<Stonk> stonks;

    public Portfolio() {
        stonks = new ArrayList<Stonk>();
    }

    public Stonk getStonk(String symbol) {
        for (Stonk stonk : stonks) {
            if (stonk.getSymbol().equalsIgnoreCase(symbol)) {
                // we know Stonk has no methods for changing values, but a good practice
                // depending on if you want people to be able to change your values
                // make a copy so our version can't be changed outside of our public methods
                
                // the copy constructor creates a new instance in memory to give to the caller
                return new Stonk(stonk);
            }
        }
        // null is not an object
        return null;
    }

    public void addStonk(Stonk stonk) {
        stonks.add(stonk);
    }

    public void removeStonk(Stonk stonk) {
        stonks.remove(stonk);
    }

    public double getTotalValue() {
        double totalValue = 0;

        for (int index = 0; index < stonks.size(); index++) {
            totalValue += stonks.get(index).getValue();
        }

        return totalValue;
    }
}
