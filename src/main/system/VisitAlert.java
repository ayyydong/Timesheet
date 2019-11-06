package system;

public class VisitAlert extends Alert {

    public VisitAlert(int time) {
        super(time);
    }

    @Override
    public void notifies(int i) {
        System.out.println("You have been checked out at time " + i);
    }
}
