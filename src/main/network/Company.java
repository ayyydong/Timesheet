package network;

import placeholder.ObservableValue;
import placeholder.Observer;
import placeholder.TextObserver;
import placeholder.people.*;
import system.TimeException;
import system.Timer;
import system.VisitAlert;
import ui.UserInput;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

// Represents the Company
public class Company {
    public Map<Employer, ArrayList<Worker>> occupants = new HashMap<>();
    Employer emp = new Employer("v0g2b");
    Person vis = new Visitor("Andy");
    Employer andy = new Employer("Andy");
    Worker andyJr = new Worker("AndyJr");
    Worker andySr = new Worker("AndySr");
    ArrayList<Worker> members = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    VisitAlert visT = new VisitAlert(0);
    Timer time = new Timer(6);
    UserInput input = new UserInput();


    public Company() throws IOException {
        askVisitor();
    }

    public void visitorOrMember() throws IOException, TimeException {
        printMessages("Hello");
        String input = askingInput("Are you a visitor?");
        // input is yes or no
        if (input.equalsIgnoreCase("no")) {
            isWorker();
        } else {
            visitorActions();
        }
    }

    private void visitorActions() {
        vis.greeting();
        scanner.nextLine();
        //TODO: store it
        vis.stay();
        askingToQuit();
        visT.notifies(time.lasthour);
        vis.leave();
    }

    public void foreachTest() {
        String identity = members.get(0).identity;
        for (Worker worker : members) {
            if (worker.identity == members.get(0).identity) { //testing if hashcode compares identity strings
                System.out.println(identity);
                members.remove(worker);
                identity = members.get(0).identity;
                printMessages(identity);
            }
        }
    }

    // must type v0g2b, don't know how to fix complicated bug, also something wrong with change

    public void isWorker() throws IOException, TimeException {
        workerActions();
        foreachTest();
    }

    private void workerActions() throws IOException, TimeException {
        String id;
        emp.greeting();
        do {
            id = scanner.nextLine();
        } while (!emp.identityCorrect(id));
        // want to loop if identity incorrect
        emp.stay();
        occupants.put(andy, members);
        members.add(andyJr);
        members.add(andySr);
        String input = askingInput("Do you want to make changes to the ID database?");
        if (input.equalsIgnoreCase("yes")) {
            this.input.command();
        }
        time.runningTimer();
        askingToQuit();
        emp.leave();
    }

    // TODO: move appropriate methods to UserInput
    private void askingToQuit() {
        do {
            printMessages("Type quit when you leave.");
        } while
        (!correctInput(scanner.nextLine(), "quit"));
    }

    private String askingInput(String s) {
        String input;
        do {
            printMessages(s);
        } while
        (!correctInput(input = scanner.nextLine(), "yes", "no"));
        return input;
    }

    public static void main(String[] args) throws IOException {
        websitePage();
        new Company();
        observPattern();
    }

    private static void websitePage() throws IOException {
        BufferedReader br = null;
        try {
            String theURL = "https://www.students.cs.ubc.ca/~cs-210/2018w1/welcomemsg.html";
            //original source of given example (http://zetcode.com/articles/javareadwebpage/)
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            System.out.println(sb);
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    //this was taken from
    // https://www.javaworld.com/article/2077258/observer-and-observable.html?fbclid
    // =IwAR31sgl_AZZwd4zkHyxWjrXI1Uf6W6T5Uux7zNp5MOZ9refRfAtLOXVerzY
    private static void observPattern() {
        ObservableValue ov = new ObservableValue(0);
        TextObserver to = new TextObserver(ov);
        ov.setValue(1);
        ov.addObserver(to);
        System.out.println(ov.getValue());
    }

    public void askVisitor() throws IOException {
        try {
            visitorOrMember();
        } catch (TimeException e) {
            printMessages("Time cannot be negative!");
        }
    }

    private void printMessages(String s) {
        System.out.println(s);
    }

    private boolean correctInput(String input, String... s) {
        for (String x : s) {
            if (input.equalsIgnoreCase(x)) {
                return true;
            }
        }
        return false;
    }

    private boolean correctInput(String input, String s) {
        return (input.equalsIgnoreCase(s));
    }
}
