package placeholder.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployerTest {
    Employer employer;
    Staff employee;

    @BeforeEach
    public void runBefore() {
        employer = new Employer("v0g2b");
        employee = new Staff("v3g2b");
    }

    @Test
    void identityTest() {
        assertEquals("v0g2b", employer.getIdentity());
        assertFalse("v5g2b" == employer.getIdentity());
    }

    @Test
    void assignEmployeeWithExistingEmployeeTest() {
        employer.assignEmployees(employee);
        assertTrue(employer.getEmployees().contains(employee));
        employer.assignEmployees(employee);
        assertEquals(1, employer.getEmployees().size());
    }

    @Test
    void assignEmployeeNotExistingTest() {
        employer.assignEmployees(employee);
        assertTrue(employer.getEmployees().contains(employee));
        assertFalse(employer.getEmployees().isEmpty());
        assertEquals(1, employer.getEmployees().size());
    }

    @Test
    void identityCorrectTest() {
        assertTrue(employer.identityCorrect("v0g2b"));
    }

    @Test
    void typedSomethingWrongExpectInvalidTest() {
        assertFalse(employer.identityCorrect("v3g2b"));
    }
}
