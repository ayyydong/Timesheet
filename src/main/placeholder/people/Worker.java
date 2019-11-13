package placeholder.people;

import placeholder.CheckIn;
import placeholder.CheckOut;

// Represents the company employees
public class Worker extends Person {
    CheckIn checkIn;
    CheckOut checkOut;
    public String identity;
    Employer employer;

    // MODIFIES: this
    // EFFECTS: sets the given visitor name in the company
    public Worker(String identity) {
        this.identity = identity;
        checkIn = new CheckIn();
        checkOut = new CheckOut();
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

    // EFFECTS: the worker is greeted and asked for name
    @Override
    public void greeting() {
        checkIn.greeting("Welcome back to Company X!");
        checkIn.greeting("Please enter your ID");
    }

    // EFFECTS: implies that worker has successfully checked in
    @Override
    public void stay() {
        checkIn.stay("You have been successfully checked in.");
    }

    // EFFECTS: implies that worker has successfully checked out
    @Override
    public void leave() {
        checkOut.leave("You have been successfully checked out.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Worker emp = (Worker) o;
        if (!emp.equals(emp.identity)) {
            return false;
        }
        return emp.equals(emp.identity);
    }

    @Override
    public int hashCode() {
        int result = identity.hashCode();
        return result;
    }
}
