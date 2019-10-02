package placeholder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import placeholder.people.Employees;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesTest {
    private Employees employees;

    @BeforeEach
    public void runBefore() {
        employees = new Employees("v0g2b");
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

    // this tests the CheckIn interface
    @Test
    public void identityCorrectTest() {
        assertEquals("v0g2b",(employees.identity));
        assertEquals("v5g2b",(employees.identity));
    }
}
