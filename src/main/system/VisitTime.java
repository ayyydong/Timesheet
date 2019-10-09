package system;


public class VisitTime extends AbstractClass {
    public int closingtime = 12;


    public VisitTime(int time) {
        super(time);
    }

    @Override
    public void notifies(int i) {
        System.out.println("You have been checked out");
    }
}
