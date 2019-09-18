package ui;

import placeholder.people.Employees;
import placeholder.people.Visitors;
import placeholder.CheckIn;
import placeholder.CheckOut;


public class Company {
    public static Employees emp;
    public static Visitors vis;

    public Company() {
        Company c = new Company();
    }

    public static void main(String[] args) {
        System.out.println("Hello");
//        if (Employees = true);
        emp.greeting();
        CheckIn.employeestay();
        // timer will run
        // later reminder will activate when shift is almost over
        CheckOut.employeeleave();
//        else;
        vis.greeting2();
        CheckIn.visitorstay();
        CheckOut.visitorleave();

    }
}
