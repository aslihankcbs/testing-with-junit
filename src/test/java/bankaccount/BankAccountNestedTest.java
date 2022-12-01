package bankaccount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountNestedTest {
    @Test
    @DisplayName("Withdraw 500 successfully")
    void testWithdraw() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);
        Assertions.assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully")
    void testDeposit() {
        BankAccount bankAccount = new BankAccount(400, 0);
        bankAccount.deposit(500);
        Assertions.assertEquals(900, bankAccount.getBalance());
    }

    @Nested
    class WhenBalanceEqualsZero {
        @Test
        @DisplayName("Withdrawing below minimum balance: exception")
        void testWithdrawMinimumBalanceIs0() {
            BankAccount bankAccount = new BankAccount(0, 0);
            assertThrows(RuntimeException.class, () -> bankAccount.withdraw(500));
        }

        @Test
        @DisplayName("Withdrawing and getting negative balance")
        void testWithdrawMinimumBalanceNegative1000() {
            BankAccount bankAccount = new BankAccount(0, -1000);
            bankAccount.withdraw(500);
            Assertions.assertEquals(-500, bankAccount.getBalance());
        }
    }

}
