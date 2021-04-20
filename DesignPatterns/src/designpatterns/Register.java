
package designpatterns;

import java.util.ArrayList;


public class Register {
    private double total;
    private double startingValue;
    private ArrayList<Double> transactions;
    
    public Register(double startingValue){
        this.startingValue = startingValue;
        this.total = startingValue;
        
    }
    
    public void addTransation(double amount){
        total += amount;
        transactions.add(amount);
    }
}
