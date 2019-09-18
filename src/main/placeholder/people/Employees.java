package placeholder.people;

public class Employees {
    private String ID;

    public Employees(String identity) {
    this.ID = identity;
    }

    public static void greeting() {
        System.out.println("Welcome back to Company X!");
        System.out.println("Please enter your ID");
    }

    private boolean IDcheck(Employees input) {
        return (ID.equals(input));


    }
}
