package chapter8nightclass;

import java.util.ArrayList;

public class Portfolio {
    private String ownerName;
    private ArrayList<Stonk> stonks;
    
    public Portfolio(String ownerName)
    {
        this.ownerName = ownerName;
        stonks = new ArrayList<Stonk>();
    }
    
    public void addStonk(Stonk stonk)
    {
        stonks.add(stonk);
    }
    
    public Stonk getStonk(String symbol)
    {
        for ( Stonk stonk : stonks)
        {
            if ( symbol.equalsIgnoreCase(stonk.getSymbol()))
            {
                return new Stonk(stonk);
            }
        }
        return null;
    }
    
    public ArrayList<Stonk> getStonks()
    {
        ArrayList<Stonk> copy = new ArrayList<Stonk>();
        
        for ( Stonk stonk : stonks)
        {
            // doing the copy here ensures the existing refernces aren't passed back
            copy.add(new Stonk(stonk));
        }
        
        return copy;
        // don't return a mutable reference type unless you really want someone to have full access to it
        // return stonks;
    }
    
    public double calculateValue()
    {
        double value = 0;
        for( Stonk stonk : stonks )
        {
            value += stonk.getValue() * stonk.getQuantity();
        }
        
        return value;
    }
}
