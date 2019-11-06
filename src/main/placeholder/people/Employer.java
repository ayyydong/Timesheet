package placeholder.people;

import placeholder.ToDoList;

import java.util.HashSet;
import java.util.Set;
import java.io.IOException;

public class Employer extends Worker {
    private ToDoList toDoList;
    Set<Worker> employees = new HashSet<>();

    public Employer(String identity) {
        super(identity);
        toDoList = new ToDoList();
    }

    public void addEmployees(Worker employee) {
        employee.addEmployer(this);
        employees.add(employee);
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
    public boolean identityCorrect(String s) throws InvalidException {
        if (s.matches(identity)) {
            return true;
        } else {
            throw new InvalidException();
        }
    }
}
