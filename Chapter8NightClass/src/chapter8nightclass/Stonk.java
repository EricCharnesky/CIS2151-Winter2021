package chapter8nightclass;

public class Stonk {

    private String symbol;
    private double value;

    public Stonk(String symbol, double value) {
        this.symbol = symbol;
        this.value = value;
    }
    
    public Stonk(Stonk otherStonk)
    {
        // don't use = to copy reference types - strings are an exception
        this.symbol = otherStonk.symbol;
        this.value = otherStonk.value;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getValue() {
        return value;
    }
    
    
    @Override
    public boolean equals(Object other)
    {
        if ( other.getClass() != this.getClass() )
        {
            return false;
        }
        
        Stonk otherStonk = (Stonk)other;
        
        return otherStonk.symbol.equals(symbol) && otherStonk.value == value;
    }
    
}
