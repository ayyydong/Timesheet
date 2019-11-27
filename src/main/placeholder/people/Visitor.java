package placeholder.people;

// Represents people who are visiting
public class Visitor {
    public String name;

    // MODIFIES: this
    // EFFECTS: sets the given Visitor name in the company
    public Visitor(String name) {
        this.name = name;
    }

    // getter
    public String getName() {
        return name;
    }
}
