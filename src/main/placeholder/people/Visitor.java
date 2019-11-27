package placeholder.people;

// Represents people who are visiting
public class Visitor {
    public String name;

    // MODIFIES: this
    // EFFECTS: sets the given visitor name in the company
    public Visitor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
