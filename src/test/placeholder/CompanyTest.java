package placeholder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Company;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for Company
class CompanyTest {
    private Company comp;


    @BeforeEach
    public void runBefore() {
        comp = new Company();
    }

    @Test
    public void testContainsVisitors() {
        assertEquals(null, comp.vis);
    }

    @Test
    public void testContainsEmployees() {
        assertEquals(null, comp.emp);
    }

    @Test
    public void testContainsBob() {
        assertFalse(comp.occupants.contains("Andy"));
        assertFalse(comp.occupants.contains("Bob"));
    }
}
