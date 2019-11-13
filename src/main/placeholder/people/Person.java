package placeholder.people;

public abstract class Person {

    // EFFECTS: the visitor is greeted and asked for name
    // TODO: refactor
    public void greeting() {
        System.out.println("Welcome to Company X!");
        System.out.println("Please enter your name");
//        checkIn.greeting("Welcome to Company X!");
//        checkIn.greeting("Please enter your name");
    }

    // EFFECTS: implies that visitor has successfully checked in
    public void stay() {
        System.out.println("Enjoy your visit!");
//        checkIn.stay("Enjoy your visit!");
    }

    // EFFECTS: implies that visitor has successfully checked out
    public void leave() {
        System.out.println("We hope you enjoyed your visit!");
//        checkOut.leave("We hope you enjoyed your visit!");
    }
}
