package system;

public class Reminder {

    public Reminder() {
    }

    public static void notifyEmployee(int i) {
        if (i < 6) {
            System.out.println("You have worked for " + i + " hours");
        } else {
            System.out.println("Your shift is almost over!");
        }
    }
}