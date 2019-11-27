package placeholder.people;

// Represents the company employees
public class Staff {
    public String identity;
    Employer employer;

    // MODIFIES: this
    // EFFECTS: sets the given visitor name in the company
    public Staff(String identity) {
        this.identity = identity;
    }

    public String getIdentity() {
        return identity;
    }

    public void addEmployer(Employer employer) {
        if (this.employer != employer) {
            removeEmployer();
        }
        this.employer = employer;
        employer.assignEmployees(this);
    }

    //EFFECTS: remove the current Employer assigned to Employees
    public void removeEmployer() {
        if (employer != null) {
            Employer emp = employer;
            this.employer = null;
            emp.removeEmployee(this);
        }
    }

    public Employer getEmployers() {
        return employer;
    }
}
