import intro.Code;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CodeTest {

    @Test
    void testSayHello() {
        Code code = new Code();
        assertEquals("Hello World!", code.sayHello());
    }
}
