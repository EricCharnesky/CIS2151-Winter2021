package chapter8nightclass;


public class Stonk {

    // immuatble - can't change values
    private final String symbol;
    private final double value;
    private final double quantity;

    public Stonk(String symbol, double value) {
        
        // used to call another constructors
        this(symbol, value, 1);
        
    }
    
    public Stonk(String symbol, double value, double quantity)
    {
        this.symbol = symbol;
        this.value = value;
        this.quantity = quantity;
    }
    
    public Stonk(Stonk otherStonk)
    {
        // don't use = to copy reference types - strings are an exception
        this.symbol = otherStonk.symbol;
        this.value = otherStonk.value;
        this.quantity = otherStonk.quantity;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getValue() {
        return value;
    }

    public double getQuantity() {
        return quantity;
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
