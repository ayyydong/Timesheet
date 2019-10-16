package placeholder.people;

import placeholder.ToDoList;

import java.io.IOException;

public class Employer extends Employees {
    private ToDoList toDoList;

    public Employer(String identity) {
        super(identity);
        toDoList = new ToDoList();
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
