package ui;

import placeholder.people.Employer;

import java.io.IOException;
import java.util.Scanner;

public class UserInput {
    Scanner typing;

    public UserInput() {
        typing = new Scanner(System.in);
    }

    public Boolean requestChange() {
        return (typing.nextLine().matches("yes"));
    }

    public void command() throws IOException {
        Employer employ = new Employer("v0g2b");
        System.out.println("Whose ID do you want to change?");
//        System.out.println("What do you want to change it to?");
        employ.changeLog(typing.nextLine());//,typing.nextLine());
    }
}
