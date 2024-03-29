package bankaccount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
class BankAccountRepeatedTestTest {
    @RepeatedTest(5)
    @DisplayName("Deposit 500 successfully")
    void testDeposit(BankAccount bankAccount) {
        bankAccount.deposit(500);
        Assertions.assertEquals(500, bankAccount.getBalance());
    }

    @RepeatedTest(5)
    @DisplayName("Deposit 500 successfully")
    void testDepositRepetitionInfo(BankAccount bankAccount, RepetitionInfo repetitionInfo) {
        bankAccount.deposit(500);
        Assertions.assertEquals(500, bankAccount.getBalance());
        System.out.println("Nr: " + repetitionInfo.getCurrentRepetition());
    }
}
