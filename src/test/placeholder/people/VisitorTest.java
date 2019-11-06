package placeholder.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitorTest {
    private Visitor visitor;

    @BeforeEach
    public void runBefore() {
        visitor = new Visitor("Andy");
    }

    @Test
    public void nameMatchesTest() {
        assertEquals("Andy",(visitor.name));
        assertFalse("AndyJr".equals(visitor.name));
    }

    @Test
    public void greetingTest() {
        visitor.greeting();
    }

    @Test
    public void stayTest() {
        visitor.stay();
    }

    @Test
    public void leaveTest() {
        visitor.leave();
    }
}
