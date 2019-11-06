package system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VisitAlertTest {
    public VisitAlert visitAlert;

    @BeforeEach
    public void runBefore() {
        visitAlert = new VisitAlert(10);
    }

    @Test
    public void vTimeTest() {
        assertEquals(10, visitAlert.time);
        assertFalse(11 == visitAlert.time);
    }

    @Test
    public void notifiesTest() {
        visitAlert.notifies(8);
    }
}
