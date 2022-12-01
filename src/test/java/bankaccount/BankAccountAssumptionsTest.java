package bankaccount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.*;

class BankAccountAssumptionsTest {
    @Test
    @DisplayName("Test activation account after creation")
    void testActive() {
        BankAccount bankAccount = new BankAccount(500, 0);
//        assumeTrue(bankAccount == null);
//        assumeFalse(bankAccount == null);
        assumingThat(bankAccount == null, () -> Assertions.assertTrue(bankAccount.isActive()));
    }
}
