package placeholder;

import placeholder.people.Employer;
import ui.UserInput;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ToDoList {
    public List<String> inputline;
    public List<String> outputline;
    private UserInput userInput;

    public ToDoList() {
        userInput = new UserInput();
    }

    //TODO: add all existing members to inputfile (in data file)


    // this code was taken from FileReaderWriter project and modified
    public void save(String in) throws IOException {
        Employer employ = new Employer("v0g2b");
        PrintWriter existingInfo = new PrintWriter("./data/inputfile.txt", "UTF-8");
        existingInfo.println(employ.identity); //prints all company id's in inputfile
        inputline = Files.readAllLines(Paths.get("./data/inputfile.txt")); //reads inputfile
        PrintWriter writer = new PrintWriter("./data/outputfile.txt", "UTF-8");
        inputline.add(in); //add line to whatever is read
        for (String line : inputline) {
            writer.println(line);
        }
        writer.close();
    }

    // TODO: change lines.get(counter)
    public void load(String out) throws IOException {
        outputline = Files.readAllLines(Paths.get("./data/outputfile.txt"));
        for (String line : outputline) {
            if (line.matches(out)) {
                line.replace(line, out);//, changed);
                //TODO: make the change, should be changed
            }
        }
    }
}

