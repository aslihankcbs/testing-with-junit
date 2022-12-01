package bankaccount;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankAccountBeforeAndAfterTest {
    static BankAccount bankAccount;

    @BeforeAll
    public void prepTest() {
        System.out.println("Hi!");
        bankAccount = new BankAccount(500, 0);
    }

    @Test
    void testWithdraw() {
        bankAccount.withdraw(300);
        Assertions.assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(500);
        Assertions.assertEquals(700, bankAccount.getBalance());
    }

    @AfterAll
    public void endTest() {
        System.out.println("Bye!");
    }
}
