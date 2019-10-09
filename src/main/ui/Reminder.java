package ui;

public class Reminder extends AbstractClass {
    int num;

    // CONSTRUCTOR...blank for now
    public Reminder(int time) {
        super(time);
    }

    // REQUIRES: Integer i must be positive
    // EFFECTS: Notifies the employee about how long he/she has worked
    // and when their shift is almost over
    @Override
    public void notifies(int num) {
        if (num < 6) {
            System.out.println("You have worked for " + num + " hours");
        } else {
            System.out.println("Your shift is almost over!");
        }
    }

//    @Override
//    public void notifies(int i) {
//        if (i < 6) {
//            System.out.println("You have worked for " + i + " hours");
//        } else {
//            System.out.println("Your shift is almost over!");
//        }
//    }
}