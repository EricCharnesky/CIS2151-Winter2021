package chapter8nightclass;

import java.util.Random;
import java.util.Scanner;

public class Chapter8NightClass {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        // don't need an instance to do anything
        MathFun myMathFun = new MathFun();

        System.out.println("Enter a radius, and I'll tell you the area");
        double radius = Double.parseDouble(keyboard.nextLine());

        System.out.println("The area is: " + MathFun.calculateAreaOfCircle(radius));
        System.out.println("The area is: " + MathFun.calculateAreaOfCircle(radius));
        System.out.println("The area is: " + MathFun.calculateAreaOfCircle(radius));
        System.out.println("You used MathFun " + MathFun.counter + " times!");

        BankAccount checking = createAccountWithBonus("Eric", "Checking");
        
        checking.deposit(1000);
        System.out.println(checking);
        gamble(checking);
        System.out.println(checking);
        
        Stonk gamestop = new Stonk("GME", 336);
        Stonk otherGameStonk = new Stonk("GME", 336);
        
        // bad news bears - two variables pointed at the same thing
        Stonk copyGameStonk = otherGameStonk;
        
        // good way to copy after we write a copy constructor
        Stonk realCopyGameStonk = new Stonk(gamestop);
        
        System.out.println(gamestop);
        System.out.println(otherGameStonk);
        System.out.println(copyGameStonk);
        
        // == compares for refernece types - are you the same location in memory
        boolean firstCompare = gamestop == otherGameStonk;
        System.out.println("gamestop == otherGameStonk "+ firstCompare);
        
        // == compares for refernece types - are you the same location in memory
        boolean secondCompare = otherGameStonk == copyGameStonk;
        System.out.println("otherGameStonk == copyGameStonk "+ secondCompare);
        
        // == compares for refernece types - are you the same location in memory
        boolean thirdCompare = gamestop == realCopyGameStonk;
        System.out.println("gamestop == realCopyGameStonk "+ thirdCompare);
        
        // == compares for refernece types - are you the same location in memory
        boolean equalsFirstCompare = gamestop.equals(otherGameStonk);
        System.out.println("gamestop.equals(otherGameStonk) "+ equalsFirstCompare);
        
        // == compares for refernece types - are you the same location in memory
        boolean equalsSecondCompare = otherGameStonk.equals(copyGameStonk);
        System.out.println("otherGameStonk.equals(copyGameStonk) "+ equalsSecondCompare);
        
        // == compares for refernece types - are you the same location in memory
        boolean equalsthirdompare = gamestop.equals(realCopyGameStonk);
        System.out.println("gamestop.equals(realCopyGameStonk) "+ equalsthirdompare);

    }
    
    public static BankAccount createAccountWithBonus(String ownerName, String accountType)
    {
        BankAccount account = new BankAccount(ownerName, accountType);
        account.deposit(100);
        return account;
    }

    public static void gamble(BankAccount account) {
        
        // this is creating a new bankaccount and account points to it,
        // it doesn't change the old account
        // account = new BankAccount("Hacker", "bitcoin");
        Random random = new Random();

        int value = random.nextInt(1001);

        // 50/50 chance of win or lose
        if (random.nextInt(2) == 0) {
            account.withdraw(value);
        } else {
            account.deposit(value);
        }
    }

}
