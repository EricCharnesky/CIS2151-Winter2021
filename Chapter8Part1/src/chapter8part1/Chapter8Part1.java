package chapter8part1;

import java.util.Random;
import java.util.Scanner;

public class Chapter8Part1 {

    public static void main(String[] args) {
        System.out.println("Happy Tuesday!");
        String again = "Y";
        
        Scanner keyboard = new Scanner(System.in);
        
        while ( again.equalsIgnoreCase("Y"))
        {
            System.out.println("Enter a radius");
            double radius = Double.parseDouble(keyboard.nextLine());
            System.out.println("The circumference of a cirlce with a radius of "
                    + radius + " is " + MathIsFun.calculateCircumference(radius));
            
            System.out.println("Do you want to caluclate another? ( Y/N )");
            again = keyboard.nextLine();
        }
        
        System.out.println("You used our amazing math function " 
                + MathIsFun.mathCounter + " times");
        
        
        BankAccount checking = new BankAccount("Eric");
        checking.deposit(1000);
        
        BankAccount savings = createNewAccount("Eric");
        
        // automagically calling toString()
        System.out.println(checking);
        
        gamble(checking);
        
        // adding toString() to show it's the same thing
        System.out.println(checking.toString());
        
        
        Stonk gamestop = new Stonk("GME", 297);
        Stonk gamestopagain = new Stonk("GME", 297);
        
        boolean areEqual = gamestop.equals(gamestopagain);
       
        
        System.out.println("Does it equal?" + areEqual);
    }
    
    public static BankAccount createNewAccount(String ownerName)
    {
        BankAccount newAccount = new BankAccount(ownerName);
        newAccount.deposit(100);
        // returns the memory location of the new account
        return newAccount;
    }
    
    public static void gamble(BankAccount account)
    {
        // can't reassign to a new location
        // this creates a new account, doesn't change the original
        // account = new BankAccount("Hacker");
        
        Random random = new Random();
        
        int value = random.nextInt(1001);
        
        // gives us a 50/50 chance of deposit or withdrawl
        if ( random.nextInt(2) == 0)
        {
            account.withdraw(value);
        }
        else
        {
            account.deposit(value);
        }
        
    }
    
}
