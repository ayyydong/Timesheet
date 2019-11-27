package placeholder.people;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Employer extends Staff {
    Set<Staff> employees = new HashSet<>();

    public Employer(String identity) {
        super(identity);
    }

    // getters
    public Set<Staff> getEmployees() {
        return employees;
    }

    // MODIFIES: this
    // EFFECTS: if employee is not in the set, add the employee
    public void assignEmployees(Staff employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
            employee.addEmployer(this);
        }
    }

    // REQUIRES: employees must not be empty
    // MODIFIES: this
    // EFFECTS: removes the employee from the set of employees
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
