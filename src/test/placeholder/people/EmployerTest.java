package placeholder.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class EmployerTest {
    public Employer employer;

    @BeforeEach
    public void runBefore() {
        employer = new Employer("v0g2b");
    }

    // this tests the CheckIn interface
    @Test
    public void identityTest() {
        assertEquals("v0g2b", (employer.identity));
        assertFalse("v5g2b" == (employer.identity));
    }

    //this test cannot be tested much (calls ToDoList)
    @Test
    public void changeLogTest() throws IOException {
        employer.changeLog("Hello World");//, "Hi");
    }

    @Test
    public void identityCorrectTest() {
        assertTrue(employer.identityCorrect("v0g2b"));
    }

    @Test
    public void typedSomethingWrongExpectInvalid() {
        try {
            employer.identityCorrect("v3g2b");
            fail("Should throw exception");
        } catch (InvalidException i) {
            System.out.println("Works!");
        }
    }

    @Test
    public void typedItCorrectExpectTrue() {
        try {
            employer.identityCorrect("v0g2b");
            System.out.println("Works!");
        } catch (InvalidException i) {
            fail("Caught invalid exception");
        }
        assertTrue(employer.identityCorrect("v0g2b"));
    }
}
