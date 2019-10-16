package system;


public class VisitTime extends Alert {

    public VisitTime(int time) {
        super(time);
    }

    @Override
    public void notifies(int i) {
        System.out.println("You have been checked out at time " + i);
    }
}
