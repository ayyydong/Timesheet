package placeholder;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToDoList {

    // this code was taken from FileReaderWriter project and modified
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("inputfile.txt"));
        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
        lines.add("Billy ok");
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnSpace(line);
            System.out.print(partsOfLine.get(0) + " ");
            System.out.println(partsOfLine.get(1));
            writer.println(line);
        }
        writer.close();
    }

    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }
}
