package ui;

import placeholder.people.Employees;
import placeholder.people.Visitors;
//import placeholder.CheckIn;
//import placeholder.CheckOut;

import java.util.Scanner;
import java.util.ArrayList;

// Represents the company (moved from main)
public class Company {
    public Employees emp;
    public Visitors vis;
    public ArrayList<String> occupants;
    public Scanner scanner; // retrieved from LoggingCalculator
    public Timer time;
    public VisitTime vist;

    public Company() {
        vist = new VisitTime(0);
        time = new Timer(6);
        occupants = new ArrayList<>();
        this.scanner = new Scanner(System.in);// retrieved from LoggingCalculator
    }

    //how to make this scanner accept multiple inputs? eg. Yes yes YES yeS
    //how to make scanner only accept string inputs? certain length, regex (has to match format)
    public void visitorOrEmployee(Company c, Scanner s, Visitors vis, Employees emp) {
        System.out.println("Are you a visitor?");
        if (s.nextLine().equals("yes")) {
            vis.greeting();
            s.nextLine();
            vis.stay();
            c.occupants.add("Andy");
            c.occupants.add("Andy Jr");
            System.out.println("Press quit when you leave");
            if (s.nextLine().equals("quit")) {
                vist.notifies(0);
            }
            vis.leave();
            c.occupants.remove("Andy");
            c.occupants.remove("Andy Jr");
        } else {
            isEmployee(c, s, emp);//, in, out);
        }
    }

    public void isEmployee(Company c, Scanner s, Employees emp) {
        emp.greeting();
        scanner.nextLine();
//        if (emp.identityCorrect(s)) {
        emp.stay();
        c.occupants.add("Bob");
        // timer will run
        // later reminder will activate when shift is almost over
        Timer t = time;
        t.runningTimer();
        emp.leave();
        c.occupants.remove("Bob");
//        } else {
//            System.out.println("Incorrect ID. Please try again.");
    }
//    }

    public static void main(String[] args) {
        Company c = new Company();
        Scanner s = new Scanner(System.in);
        Employees emp = new Employees("v0g2b");
        Visitors vis = new Visitors("Andy");
//        CheckIn in = new CheckIn();
//        CheckOut out = new CheckOut();
        System.out.println("Hello");
        c.visitorOrEmployee(c, s, vis, emp);//, in, out);
//        System.out.println("Are you a visitor?");
//        if (s.nextLine().equals("yes")) {
//            vis.greetingVisitors();
//            s.nextLine();
//            in.visitorStay();
//            c.occupants.add("Andy");
//            c.occupants.add("Andy Jr");
//            out.visitorLeave();
//            c.occupants.remove("Andy");
//            c.occupants.remove("Andy Jr");
//        } else {
//            emp.greetingEmployees();
//            System.out.print("");
//            s.nextLine();
//            in.employeeStay();
//            c.occupants.add("Bob");
//            // timer will run
//            // later reminder will activate when shift is almost over
//            Timer t = new Timer(6);
//            t.runningTimer();
//            out.employeeLeave();
//            c.occupants.remove("Bob");
//      }
    }
}
