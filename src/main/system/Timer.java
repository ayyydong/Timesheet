package system;

// Represents an internal, built-in stopwatch
public class Timer {
    public int lasthour;
    public int time;

    // REQUIRES: Integer time must be positive
    // MODIFIES: this
    // EFFECTS: sets the time remaining to be the input time
    public Timer(int time) {
        this.time = time;
        this.lasthour = 6;
    }


    // REQUIRES: starting time must be >=0
    // MODIFIES: this
    // EFFECTS: timer will increment by 1 for every passing hour and
    // notify employee until it reaches the 'lasthour'
    public void runningTimer() throws TimeException {
        if (time < 0) {
            throw new TimeException();
        }
        VisitTime v = new VisitTime(time);
        WorkingTime r = new WorkingTime(time);
        for (time = 0; time < lasthour; time++) {
            r.notifies(time);
        }
        v.notifies(time);
        //TODO: we'll keep it like this for now, need fixing; Use the final count from forloop
    }
}
