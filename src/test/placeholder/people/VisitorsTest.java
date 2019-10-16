package placeholder.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitorsTest {
    private Visitors visitors;

    @BeforeEach
    public void runBefore() {
        visitors = new Visitors("Andy");
    }

    @Test
    public void nameMatchesTest() {
        assertEquals("Andy",(visitors.name));
        assertFalse("AndyJr".equals(visitors.name));
    }

    @Test
    public void greetingTest() {
        visitors.greeting();
    }

    @Test
    public void stayTest() {
        visitors.stay();
    }

    @Test
    public void leaveTest() {
        visitors.leave();
    }
}
