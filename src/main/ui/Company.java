package ui;

import placeholder.people.Employees;
import placeholder.people.Visitors;
import placeholder.CheckIn;
import placeholder.CheckOut;
import system.Timer;

import java.util.Scanner;
import java.util.ArrayList;


public class Company {
    public Employees emp;
    public Visitors vis;
    public ArrayList<String> occupants;
    public Scanner scanner; // retrieved from LoggingCalculator

    public Company() {
        occupants = new ArrayList<>();
        scanner = new Scanner(System.in);// retrieved from LoggingCalculator
    }

    public static void main(String[] args) {
        Company c = new Company();
        Scanner s = new Scanner(System.in);
        Employees emp = new Employees("v0g2b");
        Visitors vis = new Visitors("Andy");
        System.out.println("Hello");
        System.out.println("Are you a visitor?");
        s.nextLine();
        if (s.equals("Yes")) {
            vis.greetingVisitors();
            s.nextLine();
            CheckIn.visitorStay();
            c.occupants.add("Andy");
            c.occupants.add("Andy Jr");
            CheckOut.visitorLeave();
            c.occupants.remove("Andy");
            c.occupants.remove("Andy Jr");
        } else {
            emp.greetingEmployees();
            System.out.print("");
            s.nextLine();
            CheckIn.employeeStay();
            c.occupants.add("Bob");
            // timer will run
            // later reminder will activate when shift is almost over
            Timer t = new Timer(6);
            t.runningTimer();
            CheckOut.employeeLeave();
            c.occupants.remove("Bob");
        }
    }
}
