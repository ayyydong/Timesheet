package ui;

public abstract class AbstractClass {
    public int time;

    public AbstractClass(int time) {
        this.time = time;
    }

    // REQUIRES: Integer i must be positive
    // EFFECTS: Notifies the employee about how long he/she has worked
    // and when their shift is almost over
    public abstract void notifies(int num);
}
