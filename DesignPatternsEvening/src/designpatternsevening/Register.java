
package designpatternsevening;

import java.util.ArrayList;

public class Register {
    private double cash;
    private ArrayList<Double> transactions;
    
    public Register(double startingCash)
    {
        cash = startingCash;
        transactions = new ArrayList<Double>();
        transactions.add(cash);
    }
    
    public void enterTransaction(double amount){
        transactions.add(amount);
        cash += amount;
    }
}
