package placeholder.people;

import placeholder.CheckIn;
import placeholder.CheckOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Represents the company employees
public class Employees implements CheckIn, CheckOut {
    public String identity;
    List<String> instantiate;

    // MODIFIES: this
    // EFFECTS: sets the given visitor name in the company
    public Employees(String identity) {
        this.identity = identity;
        instantiate = new ArrayList<>();
    }

    // EFFECTS: the employee is greeted and asked for ID
    @Override
    public void greeting() {
        System.out.println("Welcome back to Company X!");
        System.out.println("Please enter your ID");
    }

    // EFFECTS: tells employee that he/she has successfully checked in
    @Override
    public void stay() {
        System.out.println("You have been successfully checked in.");
    }

    // EFFECTS: tells employee that they have checked out
    @Override
    public void leave() {
        System.out.println("You have been successfully checked out.");
    }

//    // EFFECTS: the employee is greeted and asked for ID
//    public void greetingEmployees() {
//        System.out.println("Welcome back to Company X!");
//        System.out.println("Please enter your ID");
//    }

    // REQUIRES: Input ID should be 5 characters long
    // EFFECTS: Returns true if input ID matches an employee ID in database
    // and false otherwise
    public boolean identityCorrect(Scanner s) {
        return (s.nextLine().equals(identity));
    }
}
