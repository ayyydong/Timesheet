package placeholder.people;

import placeholder.CheckIn;
import placeholder.CheckOut;


// Represents the company employees
public class Employees implements CheckIn, CheckOut {
    public String identity;

    // MODIFIES: this
    // EFFECTS: sets the given visitor name in the company
    public Employees(String identity) {
        this.identity = identity;
    }

//    // Getter
//    public String getID() {
//        return identity;
//    }

    // EFFECTS: the employee is greeted and asked for ID
    @Override
    public void greeting() {
        System.out.println("Welcome back to Company X!");
        System.out.println("Please enter your ID");
    }

    // EFFECTS: implies that employee has successfully checked in
    @Override
    public void stay() {
        System.out.println("You have been successfully checked in.");
    }

    // EFFECTS: tells employer that they have checked out
    @Override
    public void leave() {
        System.out.println("You have been successfully checked out.");
    }
}
