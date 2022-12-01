package bankaccount;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BankAccountOrderedExecutionTest {
    static BankAccount bankAccount = new BankAccount(0, 0);

    @Test
    @Order(2)
    void testWithdraw() {
        bankAccount.withdraw(300);
        Assertions.assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @Order(1)
    void testDeposit() {
        bankAccount.deposit(500);
        Assertions.assertEquals(500, bankAccount.getBalance());
    }
}
