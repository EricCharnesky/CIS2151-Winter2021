package chapter8part1;

public class BankAccount {
    
    private static int currentAccountNumber = 1;
    
    private double balance;
    private String ownerName;
    private int accountNumber;
    
    public BankAccount(String ownerName)
    {
        this.ownerName = ownerName;
        balance = 0;
        accountNumber = currentAccountNumber;
        currentAccountNumber++;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    
    public boolean deposit(double moneyToDeposit)
    {
        if ( moneyToDeposit < 0 )
        {
            return false;
        }
        balance += moneyToDeposit;
        return true;
        
    }
    
    public boolean withdraw(double moneyToWithdraw)
    {
        if ( moneyToWithdraw < 0 || moneyToWithdraw > balance)
        {
            return false;
        }
        balance -= moneyToWithdraw;
        return true;
        
    }
    
    @Override
    public String toString()
    {
        return "Account Owner: " + ownerName + " - Balance: $" + balance;
    }
    
}
