package placeholder;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {
    List<String> lines;


    @Test
    public void containInputFileTest() throws IOException {
        lines = Files.readAllLines(Paths.get("inputfile.txt"));
        assertTrue(lines.contains("Deliverable :("));
        assertTrue(lines.contains("AndyJr help"));
        assertFalse(lines.contains("Bob"));
    }

    @Test
    public void containOutputFileTest() throws IOException {
        lines = Files.readAllLines(Paths.get("outputfile.txt"));
        assertTrue(lines.contains("Deliverable :("));
        assertTrue(lines.contains("AndyJr help"));
        assertFalse(lines.contains("Bob"));
        assertTrue(lines.contains("Billy ok"));
    }

    @Test
    public void InputFileSizeTest() throws IOException {
        lines = Files.readAllLines(Paths.get("inputfile.txt"));
        assertEquals(lines.size(), 3);
    }

    @Test
    public void OutputFileSizeTest() throws IOException {
        lines = Files.readAllLines(Paths.get("outputfile.txt"));
        assertEquals(lines.size(), 4);
    }
}
