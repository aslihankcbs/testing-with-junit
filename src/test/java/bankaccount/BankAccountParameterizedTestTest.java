package bankaccount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(BankAccountParameterResolver.class)
class BankAccountParameterizedTestTest {
    @ParameterizedTest
    @ValueSource(ints = {100, 400, 800, 1000})
    @DisplayName("Deposit 500 successfully")
    void testDeposit(int amount, BankAccount bankAccount) {
        bankAccount.deposit(amount);
        Assertions.assertEquals(amount, bankAccount.getBalance());
    }

    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class, names = {"TUESDAY", "THURSDAY"})
    void testDayOfWeek(DayOfWeek day) {
        assertTrue(day.toString().startsWith("T"));
    }

    @ParameterizedTest
//    @CsvSource({"100, Mary", "200, Rachid", "150, Ted"})
    @CsvFileSource(resources = "details.csv", delimiter = ';')
    void depositAndNameTest(double amount, String name, BankAccount bankAccount) {
        bankAccount.deposit(amount);
        bankAccount.setHolderName(name);
        Assertions.assertEquals(amount, bankAccount.getBalance());
        Assertions.assertEquals(name, bankAccount.getHolderName());
    }
}
