package placeholder.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesTest {
    public Employees employees;

    @BeforeEach
    public void runBefore() {
        employees = new Employees("a5h2v");
    }

//    @Test
//    public void testID() {
//        assertEquals(employees.getID(),"v0g2b");
//    }

    // this tests the CheckIn interface
    @Test
    public void identityTest() {
        assertEquals("a5h2v",(employees.identity));
        assertFalse("v5g2b" == (employees.identity));
    }
}
