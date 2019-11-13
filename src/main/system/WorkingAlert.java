package system;

public class WorkingAlert extends Alert {

    // CONSTRUCTOR...blank for now
    public WorkingAlert(int time) {
        super(time);
    }

    // REQUIRES: Integer count must be positive
    // EFFECTS: Notifies the employee about how long he/she has worked
    // and when their shift is almost over
    @Override
    public void notifies(int num) {
        if (num < 6) {
            System.out.println("You have worked for " + num + " hours");
            if (num == 5) {
                System.out.println("Your shift is almost over!");
            }
        }
    }
}
