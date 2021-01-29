package chapter8nightclass;

public class BankAccount {

    private static int currentAccountNumber = 1;

    private final String ownerName;
    private final String accountType;
    private final int accountNumber;
    private double balance;

    public BankAccount(String ownerName, String accountType) {
        this.ownerName = ownerName;
        this.accountType = accountType;
        accountNumber = currentAccountNumber;
        balance = 0;

        currentAccountNumber++;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public boolean deposit(double amountToDeposit) {
        if (amountToDeposit <= 0) {
            return false;
        }

        balance += amountToDeposit;
        return true;
    }

    public boolean withdraw(double amountToWithdraw) {
        if (amountToWithdraw <= 0 || amountToWithdraw > balance) {
            return false;
        }
        balance -= amountToWithdraw;
        return true;
    }
    
    @Override
    public String toString()
    {
        return "Account type: " + accountType + " owner: " + ownerName 
                + " balance: $" + balance;
    }
}
