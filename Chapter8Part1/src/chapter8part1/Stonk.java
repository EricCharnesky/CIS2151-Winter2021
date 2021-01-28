package chapter8part1;

import java.util.Objects;

public class Stonk {
    private String symbol;
    private double value;
    
    public Stonk(String symbol, double value)
    {
        this.symbol = symbol;
        this.value = value;
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
