package placeholder.people;

public class Employees {
    private String identity;

    public Employees(String identity) {
        this.identity = identity;
    }

    public void greetingEmployees() {
        System.out.println("Welcome back to Company X!");
        System.out.println("Please enter your ID");
    }

    public boolean checkID(Employees input) {
        return (identity.equals(input));
    }
}
