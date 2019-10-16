package system;

public abstract class Alert {
    public int time;

    public Alert(int time) {
        this.time = time;
    }

    // REQUIRES: Integer count must be positive
    // EFFECTS: Notifies the employee about how long he/she has worked
    // and when their shift is almost over
    public abstract void notifies(int num);
}
