package system;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TimerTest {
    Timer timer;

    @Test
    public void timerWithNegTimeExpectingException() {
        timer = new Timer(-1);
        try {
            timer.runningTimer();
            fail("Should throw TimeException");
        } catch(TimeException t) {
            System.out.println("Success!");
        }
        assertEquals(-1, timer.time);
    }

    @Test
    public void timerWithPosTimeNotExpectingException() {
        timer = new Timer(9);
        try {
            timer.runningTimer();
            System.out.println("Success!");
        } catch(TimeException t) {
            fail("Not expecting a TimeException");
        }
        assertEquals(6, timer.time);
    }
}
