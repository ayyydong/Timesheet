package ui;

import placeholder.people.*;
import system.TimeException;
import system.Timer;
import system.VisitAlert;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

// Represents the company (moved from main)
public class Company {
    public Map<Employer, ArrayList<Worker>> occupants = new HashMap<>();
    public Timer time;
    public VisitAlert visT;
    protected UserInput input;

    Employer emp = new Employer("v0g2b");
    Person vis = new Visitor("Andy");
    Employer andy = new Employer("Andy");
    Worker andyJr = new Worker("AndyJr");
    Worker andySr = new Worker("AndySr");
    ArrayList<Worker> members = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Company() {
        visT = new VisitAlert(0);
        time = new Timer(6);
        input = new UserInput();
    }

    public void visitorOrMember() throws IOException, TimeException {
        System.out.println("Are you a visitor?");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            vis.greeting();
            scanner.nextLine();
            vis.stay();
            System.out.println("Press quit when you leave");
            if (scanner.nextLine().equals("quit")) {
                visT.notifies(time.lasthour);
                vis.leave();
            }
        } else {
            isMember();
        }
    }

    public void foreachTest() {
        String identity = members.get(0).identity;
        for (Worker worker : members) {
            if (worker.identity == members.get(0).identity) { //testing if hashcode compares identity strings
                System.out.println(identity);
                members.remove(worker);
                identity = members.get(0).identity;
                System.out.println(identity);
                System.out.println(andy.getEmployees());
                System.out.println(andyJr.getEmployers());
            }
        }
    }

    // must type v0g2b, don't know how to fix complicated bug, also something wrong with change

    public void isMember() throws IOException, TimeException {
        emp.greeting();
        try {
            emp.identityCorrect(scanner.nextLine());
            emp.stay();
            occupants.put(andy, members);
            members.add(andyJr);
            members.add(andySr);
            if (input.requestChange()) {
                input.command();
            }
            time.runningTimer();
            emp.leave();
            foreachTest();
        } catch (InvalidException e) {
            System.out.println("Invalid ID. Please try again");
        } finally {
            System.out.println("Still deciding what to put here...");
        }
    }

    public static void main(String[] args) throws IOException {
        Company c = new Company();
        System.out.println("Hello");
        try {
            c.visitorOrMember();
        } catch (TimeException e) {
            System.out.println("Time cannot be negative!");
        }
    }
}
