package ui;

import placeholder.people.Employees;
import placeholder.people.Visitors;
import placeholder.CheckIn;
import placeholder.CheckOut;


public class Company {
    public static Employees emp;
    public static Visitors vis;

    public Company() {
    }

    public static void main(String[] args) {
        Company c = new Company();
        System.out.println("Hello");
//        if (Employees = true);
        emp.greetingEmployees();
        CheckIn.employeeStay();
        // timer will run
        // later reminder will activate when shift is almost over
        CheckOut.employeeLeave();
//        else;
        vis.greetingVisitors();
        CheckIn.visitorStay();
        CheckOut.visitorLeave();
    }
}
