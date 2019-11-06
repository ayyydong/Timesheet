package system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkingAlertTest {
    public WorkingAlert workingAlert;

    @BeforeEach
    public void runBefore() {
        workingAlert = new WorkingAlert(10);
    }

    @Test
    public void wTimeTest() {
        assertEquals(10, workingAlert.time);
        assertFalse(11 == workingAlert.time);
    }

    @Test
    public void notifiesTest() {
        workingAlert.notifies(8);
    }
}
