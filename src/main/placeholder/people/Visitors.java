package placeholder.people;

import placeholder.CheckIn;
import placeholder.CheckOut;

// Represents people who are visiting
public class Visitors implements CheckIn, CheckOut {
    public String name;

    // MODIFIES: this
    // EFFECTS: sets the given visitor name in the company
    public Visitors(String name) {
        this.name = name;
    }

    // EFFECTS: the visitor is greeted and asked for name
    @Override
    public void greeting() {
        System.out.println("Welcome to Company X!");
        System.out.println("Please enter your name");
    }

    // EFFECTS: implies that visitor has successfully checked in
    @Override
    public void stay() {
        System.out.println("Enjoy your visit!");
    }

    // EFFECTS: implies that visitor has successfully checked out
    @Override
    public void leave() {
        System.out.println("We hope you enjoyed your visit!");
    }
}
