package ui;

import placeholder.people.InvalidException;
import placeholder.people.Visitors;
import placeholder.people.Employer;
import system.TimeException;
import system.Timer;
import system.VisitTime;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

// Represents the company (moved from main)
public class Company {
    public ArrayList<String> occupants;
    public Timer time;
    public VisitTime visT;
    protected UserInput input;

    public Company() {
        visT = new VisitTime(0);
        time = new Timer(6);
        occupants = new ArrayList<>();
        input = new UserInput();
    }

    public void visitorOrMember(Company c, Scanner s, Visitors vis, Employer emp) throws IOException, TimeException {
        System.out.println("Are you a visitor?");
        if (s.nextLine().equals("yes")) {
            vis.greeting();
            s.nextLine();
            vis.stay();
            c.occupants.add("Andy");
            c.occupants.add("Andy Jr");
            System.out.println("Press quit when you leave");
            if (s.nextLine().equals("quit")) {
                visT.notifies(time.lasthour);
                vis.leave();
                c.occupants.remove("Andy");
                c.occupants.remove("Andy Jr");
            }
        } else {
            isMember(emp, s);
        }
    }

    // must type v0g2b, don't know how to fix complicated bug, also something wrong with change

    public void isMember(Employer emp, Scanner s) throws IOException, TimeException {
        emp.greeting();
        try {
            emp.identityCorrect(s.nextLine());
            emp.stay();
            if (input.requestChange()) {
                input.command();
            }
            Timer t = time;
            t.runningTimer();
            emp.leave();
        } catch (InvalidException e) {
            System.out.println("Invalid ID. Please try again");
        } finally {
            System.out.println("Still deciding what to put here...");
        }
    }

    public static void main(String[] args) throws IOException {
        Company c = new Company();
        Scanner s = new Scanner(System.in);
        Employer emp = new Employer("v0g2b");
        Visitors vis = new Visitors("Andy");
        System.out.println("Hello");
        try {
            c.visitorOrMember(c, s, vis, emp);
        } catch (TimeException e) {
            System.out.println("Time cannot be negative!");
        }
    }
}
