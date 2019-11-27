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
        assertEquals("Andy", visitor.getName());
        assertFalse("AndyJr".equals(visitor.getName()));
    }
}