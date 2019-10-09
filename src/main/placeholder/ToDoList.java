package placeholder;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class ToDoList {

//    public static void test(String[] args) throws IOException {
//        List<String> lines = Files.readAllLines(Paths.get("inputfile.txt"));
//        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
//        lines.add("Trey Coordinator");
//        for (String line : lines) {
//            ArrayList<String> partsOfLine = splitOnSpace(line);
//            System.out.print(partsOfLine.get(0) + " ");
//            System.out.println(partsOfLine.get(1));
//            writer.println(line);
//        }
//        writer.close(); //note -- if you miss this, the file will not be written at all.
//    }

    // this code was taken from FileReaderWriter project and modified
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        load();
        save(scanner.nextLine());
    }


    public static void save(String in) throws IOException {
//        Scanner scanner = new Scanner(System.in);
        List<String> lines = Files.readAllLines(Paths.get("inputfile.txt"));
        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
        lines.add(in);
        for (String line : lines) {
            writer.println(line);
        }
        writer.close();
    }


    public static void load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("inputfile.txt"));
        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
        for (String line : lines) {
            writer.println(line);
        }
        writer.close();
    }
}

