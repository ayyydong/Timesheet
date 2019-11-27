package placeholder.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffTest {
    Staff worker;
    Employer employer;
    Employer employer2;

    @BeforeEach
    void runBefore() {
        worker = new Staff("a5h2v");
        employer = new Employer("v0g2b");
        employer2 = new Employer("fake");
    }

    // this tests the CheckIn interface
    @Test
    void identityTest() {
        assertEquals("a5h2v",worker.getIdentity());
        assertFalse("v5g2b" == worker.getIdentity());
    }

    @Test
    void addEmployerWhenOneExistTest() {
        worker.addEmployer(employer);
        assertEquals(employer, worker.getEmployers());
        assertFalse(worker.getEmployers() == null);
        worker.addEmployer(employer2);
        assertFalse(employer.equals(worker.getEmployers()));
        assertEquals(employer2, worker.getEmployers());
    }

    @Test
    void addEmployerWhenOneDNETest() {
        worker.addEmployer(employer);
        assertEquals(employer, worker.getEmployers());
    }

    @Test
    void removeEmployerTest() {
        worker.addEmployer(employer);
        assertEquals(employer, worker.getEmployers());
        worker.removeEmployer();
        assertTrue(worker.getEmployers() == null);
    }

    @Test
    void getEmployersTest() {
        worker.addEmployer(employer);
        assertEquals(employer,worker.getEmployers());
    }
}
