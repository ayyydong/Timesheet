package placeholder.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
    public Worker worker;
    public Employer employer;
    public Employer employer2;

    @BeforeEach
    public void runBefore() {
        worker = new Worker("a5h2v");
        employer = new Employer("v0g2b");
        employer2 = new Employer("fake");
    }

    // this tests the CheckIn interface
    @Test
    public void identityTest() {
        assertEquals("a5h2v",(worker.identity));
        assertFalse("v5g2b" == (worker.identity));
    }

    @Test
    public void greetingTest() {
        worker.greeting();
    }

    @Test
    public void stayTest() {
        worker.stay();
    }

    @Test
    public void leaveTest() {
        worker.leave();
    }

    @Test
    public void addEmployerTest() {
        worker.addEmployer(employer);
        assertEquals(employer, worker.employer);
        assertFalse(worker.employer == null);
        worker.addEmployer(employer2);
        assertFalse(employer.equals(worker.employer));
        assertEquals(employer2, worker.employer);
    }

    @Test
    public void removeEmployerTest() {
        worker.addEmployer(employer);
        assertEquals(employer, worker.employer);
        worker.removeEmployer();
        assertTrue(worker.employer == null);
    }

    @Test
    public void getEmployersTest() {
        worker.addEmployer(employer);
        assertEquals(employer,worker.getEmployers());
    }
}
