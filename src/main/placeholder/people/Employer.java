package placeholder.people;

import placeholder.ToDoList;

import java.util.HashSet;
import java.util.Set;
import java.io.IOException;

public class Employer extends Worker {
    private ToDoList toDoList;
    Set<Worker> employees = new HashSet<>();
    Set<Person> people = new HashSet<>();

    public Employer(String identity) {
        super(identity);
        toDoList = new ToDoList();
    }

    //notifies employees
    public void assignEmployees(Worker employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
            employee.addEmployer(this);
        }
    }

    public Set<Worker> getEmployees() {
        return employees;
    }

    public void removeEmployee(Worker employee) {
        employees.remove(employee);
        employee.removeEmployer();
    }

    //save will be user input
    public void changeLog(String out) throws IOException {
        toDoList.load(out);//, changed);
    }

    // REQUIRES: Input ID should be 5 characters long
    // EFFECTS: Returns true if input ID matches an employer ID in database
    // and false otherwise
    public boolean identityCorrect(String input) {
        if (!input.equalsIgnoreCase(identity)) {
            System.out.println("Invalid ID. Please try again");
        }
        return (input.equalsIgnoreCase(identity));
    }

    public void addObserver(Person obs) {
        people.add(obs);
    }

    public void removeObserver(Person obs) {
        people.remove(obs);
    }
}
