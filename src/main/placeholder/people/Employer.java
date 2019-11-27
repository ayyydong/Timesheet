package placeholder.people;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Employer extends Staff {
    Set<Staff> employees = new HashSet<>();

    public Employer(String identity) {
        super(identity);
    }

    public Set<Staff> getEmployees() {
        return employees;
    }

    //notifies employees
    public void assignEmployees(Staff employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
            employee.addEmployer(this);
        }
    }

    public void removeEmployee(Staff employee) {
        employees.remove(employee);
        employee.removeEmployer();
    }

    // REQUIRES: Input ID should be 5 characters long
    // EFFECTS: Returns true if input ID matches an employer ID in database
    // and false otherwise
    public boolean identityCorrect(String input) {
        return (Pattern.matches(identity, input));
    }
}
