package chapter8nightclass;

import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {
    
    public BankAccountTest() {
    }
    
    @Test
    public void testBankAccountConstructor()
    {
        // Arrange
        String expectedOwnerName = "Eric";
        String expectedAccountType = "checking";
        double expectedAccountBalance = 0;
        int expectedAccountNumber = 5;
        
        // Act
        BankAccount account = new BankAccount(expectedOwnerName, expectedAccountType);
        String actualOwnerName = account.getOwnerName();
        String actualAccountType = account.getAccountType();
        double actualBalance = account.getBalance();
        int actualAccountNumber = account.getAccountNumber();
        
        // Assert
        assertEquals(expectedOwnerName, actualOwnerName);
        assertEquals(expectedAccountType, actualAccountType);
        assertEquals(expectedAccountBalance, actualBalance, .0000001);
        assertEquals(expectedAccountNumber, actualAccountNumber);
    }
    
    @Test
    public void testDeposit()
    {
        // Arrage
        double expectedBalance = 4.2;
        
        // Act
        BankAccount account = new BankAccount("", "");
        boolean depositResult = account.deposit(expectedBalance);
        double actualBalance = account.getBalance();
        
        // Assert
        assertEquals(expectedBalance, actualBalance, .00001);
        assertTrue(depositResult);
    }
    
    @Test
    public void testDepositNegativeValue()
    {
        // Arrage
        double expectedBalance = 0;
        
        // Act
        BankAccount account = new BankAccount("", "");
        boolean depositResult = account.deposit(-4.2);
        double actualBalance = account.getBalance();
        
        // Assert
        assertEquals(expectedBalance, actualBalance, .00001);
        assertFalse(depositResult);
    }
    
    @Test
    public void testWithdraw()
    {
        // Arrage
        double expectedBalance = 4.2;
        
        // Act
        BankAccount account = new BankAccount("", "");
        account.deposit(10);
        boolean withdrawResult = account.withdraw(5.8);
        double actualBalance = account.getBalance();
        
        // Assert
        assertEquals(expectedBalance, actualBalance, .00001);
        assertTrue(withdrawResult);
    }
    
    @Test
    public void testWithdrawNegativeValue()
    {
        // Arrage
        double expectedBalance = 10;
        
        // Act
        BankAccount account = new BankAccount("", "");
        account.deposit(10);
        boolean withdrawResult = account.withdraw(-4.2);
        double actualBalance = account.getBalance();
        
        // Assert
        assertEquals(expectedBalance, actualBalance, .00001);
        assertFalse(withdrawResult);
    }
    
    @Test
    public void testWithdrawGreatherThanBalance()
    {
        // Arrage
        double expectedBalance = 10;
        
        // Act
        BankAccount account = new BankAccount("", "");
        account.deposit(10);
        boolean withdrawResult = account.withdraw(20);
        double actualBalance = account.getBalance();
        
        // Assert
        assertEquals(expectedBalance, actualBalance, .00001);
        assertFalse(withdrawResult);
    }
    
}
