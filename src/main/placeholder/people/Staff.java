package placeholder.people;

// Represents the company employees
public class Staff {
    public String identity;
    Employer employer;

    // MODIFIES: this
    // EFFECTS: sets the given Staff name in the company
    // note: can be either Employer or Employee
    public Staff(String identity) {
        this.identity = identity;
    }

    //getters
    public String getIdentity() {
        return identity;
    }

    public Employer getEmployers() {
        return employer;
    }

    // MODIFIES: this
    // EFFECTS: remove Employer if currently assigned,
    // then assign a new Employer
    public void addEmployer(Employer employer) {
        if (this.employer != employer) {
            removeEmployer();
        }
        this.employer = employer;
        employer.assignEmployees(this);
    }

    // MODIFIES: this
    // EFFECTS: remove the current Employer assigned to Employees
    public void removeEmployer() {
        if (employer != null) {
            Employer emp = employer;
            this.employer = null;
            emp.removeEmployee(this);
        }
    }
}
