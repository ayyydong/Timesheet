package system;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkingTimeTest {
    public WorkingTime workingTime;

    @BeforeEach
    public void runBefore() {
        workingTime = new WorkingTime(10);
    }

    @Test
    public void wTimeTest() {
        assertEquals(10, workingTime.time);
        assertFalse(11 == workingTime.time);
    }

    @Test
    public void notifiesTest() {
        workingTime.notifies(8);
    }
}
