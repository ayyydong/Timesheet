package system;

public class Timer {
    public int time;
    private int lasthour;

    public Timer(int time) {
        this.time = time;
        this.lasthour = 7;
    }

    public void runningTimer() {
        Timer t = new Timer(0);
        for (int i = 0; i < 7; i++) {
            Reminder.notifyEmployee(i);
        }
    }

}
