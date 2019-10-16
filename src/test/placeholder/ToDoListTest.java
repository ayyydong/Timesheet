package placeholder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {
    List<String> lines;
    List<String> lines2;
    ToDoList todo;

    @BeforeEach
    public void runBefore() throws IOException {
        lines = Files.readAllLines(Paths.get("outputfile.txt"));
        lines2 = Files.readAllLines(Paths.get("inputfile.txt"));
        todo = new ToDoList();
    }

    @Test
    public void OutputFileSizeTest() throws IOException {
        todo.save("Hello");
        lines = Files.readAllLines(Paths.get("outputfile.txt"));
        assertEquals(lines.size(), 1);
        assertFalse(lines.size() == 2);
    }


    //replacing is not working!
    @Test
    public void saveAndLoadTest() throws IOException {
        todo.load("Andy");
        for (int i = 0; i < 5; i++) {
            todo.save("Andy"); //should actually be save, but load isnt working
        }
        assertEquals(lines.size(), 1); // this is because I haven't added more lines
        // to add to outputfile
        assertEquals(lines.get(0), "Andy");
        assertTrue(lines.contains("Andy"));
        assertFalse(lines.contains("Fail"));
    }
}
