package placeholder.people;

import placeholder.CheckIn;
import placeholder.CheckOut;

// Represents people who are visiting
public class Visitor extends Person {
    public String name;
    CheckIn checkIn;
    CheckOut checkOut;

    // MODIFIES: this
    // EFFECTS: sets the given visitor name in the company
    public Visitor(String name) {
        this.name = name;
        checkIn = new CheckIn();
        checkOut = new CheckOut();
    }
}
