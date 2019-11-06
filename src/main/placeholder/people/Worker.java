package placeholder.people;

import placeholder.CheckIn;
import placeholder.CheckOut;

import java.util.ArrayList;


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
    }

    public void addEmployer(Employer employer) {
        this.employer = employer;
        employer.addEmployees(this);
    }

    public void removeEmployer() {
        employer.removeEmployee(this);
        this.employer = null;
    }

    public Employer getEmployers() {
        return employer;
    }

    // EFFECTS: the worker is greeted and asked for name
    public void greeting() {
        System.out.println("Welcome back to Company X!");
        System.out.println("Please enter your ID");
//        checkIn.greeting("Welcome back to Company X!");
//        checkIn.greeting("Please enter your ID");
    }

    // EFFECTS: implies that worker has successfully checked in
    public void stay() {
        System.out.println("You have been successfully checked in.");
//        checkIn.stay("You have been successfully checked in.");
    }

    // EFFECTS: implies that worker has successfully checked out
    public void leave() {
        System.out.println("You have been successfully checked out.");
//        checkOut.leave("You have been successfully checked out.");
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
