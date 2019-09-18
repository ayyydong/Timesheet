package placeholder.people;


public class Visitors {
    public String name;

    public Visitors(String name) {
        Visitors person = new Visitors(name);
        person.name = name;
    }

    public static void greetingVisitors() {
        System.out.println("Welcome to Company X!");
        System.out.println("Please enter your name");
    }


}
