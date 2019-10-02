package placeholder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import placeholder.people.Visitors;

import static org.junit.jupiter.api.Assertions.*;

class VisitorsTest {
    private Visitors visitors;

    @BeforeEach
    public void runBefore() {
        visitors = new Visitors("Andy");
    }

    @Test
    public void nameMatchesTest() {
        assertTrue("Andy".equals(visitors.name));
        assertFalse("AndyJr".equals(visitors.name));
    }

    @Test
    public void stayTest() {
        //there is nothing to test since the methods implementing interfaces
        //use sout
    }

    @Test
    public void leaveTest() {
        //there is nothing to test since the methods implementing interfaces
        //use sout
    }

}
