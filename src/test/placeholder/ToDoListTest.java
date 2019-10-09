package placeholder;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {
    List<String> lines;

    @Test
    public void InputFileSizeTest() throws IOException {
        lines = Files.readAllLines(Paths.get("inputfile.txt"));
        assertEquals(lines.size(), 1);
    }

    @Test
    public void OutputFileSizeTest() throws IOException {
        lines = Files.readAllLines(Paths.get("outputfile.txt"));
        assertEquals(lines.size(), 2);
    }

    @Test
    public void saveAndLoadTest() throws IOException{
        ToDoList.save("Andy");
        assertFalse("outputfile.txt".isEmpty());
    }
}
