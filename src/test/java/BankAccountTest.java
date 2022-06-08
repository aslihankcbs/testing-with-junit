import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount class")
class BankAccountTest {

    @Test
    @DisplayName("Withdraw 500 successfully")
    void testWithdraw() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully")
    void testDeposit() {
        BankAccount bankAccount = new BankAccount(400, 0);
        bankAccount.deposit(500);
        assertEquals(900, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Withdraw will become negative")
    void testWithdrawNotStuckAtZero() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(800);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Test activation account after creation")
    void testActive() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test set holder name")
    void testHolderNameSet() {
        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.setHolderName("Aslihan");
        assertNotNull(bankAccount.getHolderName());
    }

    @Test
    @DisplayName("Test that we can't withdraw below minimum")
    void testNoWithdrawBelowMinimum() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));
    }

    @Test
    @DisplayName("Test no exceptions for withdraw and deposit")
    void testWithdrawAndDepositWithoutException() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertAll(() -> bankAccount.deposit(200), () -> bankAccount.withdraw(450));
    }

    @Test
    @DisplayName("Test no exceptions for withdraw and deposit")
    void testDepositTimeout() {
        BankAccount bankAccount = new BankAccount(400, 0);
        assertTimeout(Duration.ofNanos(1), () -> bankAccount.deposit(200));
    }
}
