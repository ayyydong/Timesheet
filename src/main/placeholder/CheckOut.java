package placeholder;

public interface CheckOut {

    // NEW EFFECTS: visitor and employee have checked out
    // EFFECTS: implies that visitor has successfully checked out
    void leave();

//    void visitorLeave();
//
//    // EFFECTS: tells employee that they have checked out
//    void employeeLeave();
}
