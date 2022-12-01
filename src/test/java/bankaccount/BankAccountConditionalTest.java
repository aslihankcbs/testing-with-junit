package bankaccount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

class BankAccountConditionalTest {

    @Test
    @EnabledOnOs({OS.MAC})
    void testMac() {

    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    void testWindows() {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_17})
    void testJRE() {

    }

    @Test
    @DisabledOnJre({JRE.JAVA_17})
    void testNoJRE17() {

    }
}
