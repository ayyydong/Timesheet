package ui;

// Represents an internal, built-in stopwatch
public class Timer {
    public int lasthour;
    public int time;

    // REQUIRES: Integer time must be positive
    // MODIFIES: this
    // EFFECTS: sets the time remaining to be the input time
    public Timer(int time) {
        this.time = time;
        this.lasthour = 7;
    }


    // REQUIRES: starting time must be <=0
    // MODIFIES: this
    // EFFECTS: timer will increment by 1 for every passing hour and
    // notify employee until it reaches the 'lasthour'
    public void runningTimer() {
        Reminder r = new Reminder(time);
        for (int i = 0; i < 7; i++) {
            r.notifies(i);
        }
    }
}
