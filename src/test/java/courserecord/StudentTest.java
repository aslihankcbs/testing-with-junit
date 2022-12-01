package courserecord;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * assertEquals,
 * assertNotEquals,
 * assertTrue,
 * assertFalse,
 * assertArrayEquals,
 * assertSame,
 * assertNotSame
 * */

class StudentTest {
    @Test
    @DisplayName("Test every student must have an id, name and surname")
    void shouldCreateStudentWithIdNameAndSurname() {
        Student aslihan = new Student("1", "Aslihan", "Kocabas");
        assertEquals("Aslihan", aslihan.name());
        assertEquals("Aslihan", aslihan.name(), "Student's name must be Aslihan");
        assertNotEquals("Asli", aslihan.name());

        assertTrue(aslihan.name().startsWith("A"));
        assertTrue(aslihan.name().startsWith("A"), () -> "Student's name " + "starts with A"); // () -> supplier usage example
        assertFalse(() -> {
            Student test = new Student("2", "TestName", "TestSurname");
            return test.name().endsWith("K");
        }, "Student's name ends with K");

        Student test2 = new Student("3", "Test2", "Test2Surname");
        assertArrayEquals(new String[]{"Aslihan", "Test2"}, Stream.of(aslihan, test2).map(Student::name).toArray());

        Student student = aslihan;

        assertSame(aslihan, student); // assertSame compare this two object in all dimensions like their references and values.
        assertNotSame(test2, student);
    }

}
