package system;

public class Reminder {

    // CONSTRUCTOR...blank for now
    public Reminder() {
    }

    // REQUIRES: Integer i must be positive
    // EFFECTS: Notifies the employee about how long he/she has worked
    // and when their shift is almost over
    public void notifyEmployee(int i) {
        if (i < 6) {
            System.out.println("You have worked for " + i + " hours");
        } else {
            System.out.println("Your shift is almost over!");
        }
    }
}