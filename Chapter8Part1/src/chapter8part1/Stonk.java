package chapter8part1;

import java.util.Objects;

public class Stonk {
    private String symbol;
    private double value;
    private double quantityOwned;
    
    public Stonk(String symbol, double value)
    {
        // calls the other constructor so we don't have repeated code
        this(symbol, value, 1);
    }
    
    public Stonk(String symbol, double value, double quantityOwned)
    {
        this.symbol = symbol;
        this.value = value;
        this.quantityOwned = quantityOwned;
    }
    
    // copy constructor
    public Stonk(Stonk otherStonk)
    {
        // be careful with copies of reference types
        // strings are safe for this, others are not
        symbol = otherStonk.symbol;
        value = otherStonk.value;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getValue() {
        return value;
    }
    
    // this is the harder way, but overrides
    @Override
    public boolean equals(Object other)
    {
        if ( other.getClass() != this.getClass() )
        {
            return false;
        }
        
        Stonk otherStonk = (Stonk)other;
        
        return otherStonk.symbol == this.symbol && otherStonk.value == this.value;
    }
    
    // easier equals
    public boolean equals(Stonk otherStonk)
    {
        return otherStonk.symbol == this.symbol && otherStonk.value == this.value;
    }

}
