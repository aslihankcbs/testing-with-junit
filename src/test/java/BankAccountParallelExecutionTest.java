import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
class BankAccountParallelExecutionTest {
    @Test
    @DisplayName("Deposit 400 successfully")
    void testDeposit(BankAccount bankAccount) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully")
    void testDeposit2(BankAccount bankAccount) {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully")
    void testDeposit3(BankAccount bankAccount) {
        try {
            Thread.sleep(1250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }
}
