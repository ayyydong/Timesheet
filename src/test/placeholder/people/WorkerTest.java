package placeholder.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
    public Worker worker;

    @BeforeEach
    public void runBefore() {
        worker = new Worker("a5h2v");
    }

//    @Test
//    public void testID() {
//        assertEquals(worker.getID(),"v0g2b");
//    }

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
}
