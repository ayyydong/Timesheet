package system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VisitTimeTest {
    public VisitTime visitTime;

    @BeforeEach
    public void runBefore() {
        visitTime = new VisitTime(10);
    }

    @Test
    public void vTimeTest() {
        assertEquals(10, visitTime.time);
        assertFalse(11 == visitTime.time);
    }

    @Test
    public void notifiesTest() {
        visitTime.notifies(8);
    }
}
