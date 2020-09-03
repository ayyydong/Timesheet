package ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import placeholder.people.Employer;
import placeholder.people.Staff;
import placeholder.people.Visitor;
import ui.system.Clock;
import java.util.regex.Pattern;


// Represents the Company
public class Company extends Application implements EventHandler<ActionEvent> {
    Employer employer = new Employer("v0g2b");
    Stage window;
    Scene mainScene;
    Scene staffScene;
    Scene visitorScene;
    Scene staffCheckin;
    Scene employerCheckin;
    Scene visitorCheckin;
    Button staffButton;
    Button visitorButton;
    Button submit = new Button("Enter");
    Button goBack = new Button("Go back");
    Button signout = new Button("Sign out");
    Button time = new Button("Time");
    Label todo = new Label("");
    Label staffGreet = new Label("Welcome back");
    Label staffRequest = new Label("Please enter your ID");
    Label visGreet = new Label("Welcome");
    Label visRequest = new Label("Please enter your name");
    TextField visInput = new TextField();
    TextField staffInput = new TextField();
    VBox todoBox = new VBox();

    public static void main(String[] args) {
        launch(args);
    }

    // MODIFIES: this
    // EFFECTS: initializes the first scene
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Company System Manager");
        VBox firstFrame = mainStructure();
        mainScene = new Scene(firstFrame, 450, 375); // size of window
        window.setScene(mainScene); // the window displays mainScene
        window.show();
    }

    // EFFECTS: the template design for the mainScene that is ran by first window
    private VBox mainStructure() {
        //BUTTON FOR STAFF
        staffButton = new Button("I am a staff member");

        //BUTTON FOR VISITOR
        visitorButton = new Button("I am a visitor");

        staffButton.setOnAction(this); //initialize button for staff
        visitorButton.setOnAction(this); //initialize button for visitor

        Label greet = new Label("Welcome to Company X");
        Label request = new Label("Please select your status");
        VBox vertBox = new VBox(5); //spacing between texts vertically
        vertBox.getChildren().addAll(greet, request); //vertical texts);
        vertBox.setAlignment(Pos.CENTER);

        HBox horiBox = new HBox(5); //spacing between buttons horizontally
        horiBox.getChildren().addAll(staffButton, visitorButton); //horizontal buttons
        horiBox.setAlignment(Pos.CENTER);

        VBox assembleBox = new VBox(25);
        assembleBox.getChildren().addAll(vertBox, horiBox); //assembling the vertBox and horiBox vertically
        assembleBox.setAlignment(Pos.CENTER);
        return assembleBox;
    }

    // MODIFIES: this
    // EFFECTS: sets the window to display the given Scene
    public void goToScene(Scene s) {
        window.setScene(s);
    }

    // EFFECTS: the template for the notification box
    private VBox initTodoBox() {
        VBox inputBox = new VBox();
        inputBox.setAlignment(Pos.CENTER);
        inputBox.getChildren().add(todo);
        return inputBox;
    }

    // MODIFIES: this
    // EFFECTS: upon clicking the button "time",
    // a new window with a clock will appear
    private void clockAction() {
        time.setOnAction(event -> new Clock());
    }

    // MODIFIES: this
    // EFFECTS: redirects the window to login scenes depending on whether visitor or staff
    @Override
    public void handle(ActionEvent event) {
        // allows user to go back to mainScene if they mis-clicked
        goBack.setOnAction(event1 -> goToScene(mainScene));

        if (event.getSource() == staffButton) {
            staffFrame();
            goToScene(staffScene); // sets up the window for staff members

        } else if (event.getSource() == visitorButton) {
            visitorFrame();
            goToScene(visitorScene); // sets up the window for visitors

            visitorIsInFrame(); //I put it here because this does not need checking
        }
    }

    // EFFECTS: the template for the staff login scene
    private void staffFrame() {
        submit.setOnAction(event1 -> checker(staffInput.getText()));
        staffInput.setMaxWidth(200); // width of text box
        VBox svBox = new VBox(5);
        svBox.getChildren().addAll(staffGreet, staffRequest, staffInput, submit, goBack);
        svBox.setAlignment(Pos.CENTER);
        staffScene = new Scene(svBox, 450, 375);
    }

    // EFFECTS: the template for the visitor login scene
    private void visitorFrame() {
        submit.setOnAction(event1 -> startToVisit());
        visInput.setMaxWidth(200);
        VBox vvBox = new VBox(5);
        vvBox.getChildren().addAll(visGreet, visRequest, visInput, submit, goBack);
        vvBox.setAlignment(Pos.CENTER);
        visitorScene = new Scene(vvBox, 450, 375);
    }

    // MODIFIES: this
    // EFFECTS: a greeting Alert is displayed when name is typed,
    // sets the window scene to the independent visitor scene
    private void startToVisit() {
        Alert nameGreet = new Alert(Alert.AlertType.INFORMATION);
        String name = visInput.getText();
        nameGreet.setContentText("Enjoy your visit " + name + "!");
        new Visitor(name);
        nameGreet.showAndWait();
        window.setScene(visitorCheckin);
    }

    // MODIFIES: this
    // EFFECTS: Creates a frame that visitors will be able to access upon log-in
    private void visitorIsInFrame() {
        VBox vcBox = new VBox(5); //visitor check-in scene design
        vcBox.getChildren().addAll(time);
        vcBox.setAlignment(Pos.CENTER);
        VBox soBox = new VBox();
        soBox.getChildren().add(signout);
        soBox.setAlignment(Pos.BOTTOM_CENTER);
        VBox vcAssemble = new VBox(200);
        vcAssemble.setAlignment(Pos.CENTER);
        vcAssemble.getChildren().addAll(vcBox, soBox);
        clockAction();

        visitorCheckin = new Scene(vcAssemble, 450, 375);
        signoutAction(visitorCheckin);
    }

    // MODIFIES: this
    // EFFECTS: if signout button is clicked will asked to confirm or cancel
    // nothing happens if cancel, goes to main scene if confirm
    private void signoutAction(Scene s) {
        signout.setOnAction(event2 -> {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setContentText("You will be logged out");
            if (confirm.showAndWait().get() == ButtonType.CANCEL) {
                goToScene(s); //cancelled
            } else {
                goToScene(mainScene); // allows user to sign out
            }
        });
    }

    // EFFECTS: checks if the inputs from Textfield are found in the employer database
    // will ask to try again if invalid
    public void checker(String input) {
        Alert success = new Alert(Alert.AlertType.INFORMATION);
        TextField todoInput = new TextField();
        todoInput.setMaxWidth(300);
        submit.setOnAction(event -> todo.setText(todoInput.getText()));
        if (employer.identityCorrect(input)) {
            employerVerified(todoInput);
        }
        if (Pattern.matches("[a-z]\\d[a-z]\\d[a-z]", input)) {
            //5 characters long and follows format: letter,int...)
            if (!Pattern.matches(employer.getIdentity(), input)) {
                employeeVerified(input, success);
            }
        } else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Incorrect ID");
            errorAlert.setContentText("Please try again");
            errorAlert.showAndWait();
        }
    }

    // REQUIRES: Employee has been checked in
    // MODIFIES: this
    // EFFECTS: assembles the template for private Staff scene and window opens it
    private void employeeVerified(String input, Alert success) {
        VBox ecAssemble = staffIsInFrame(input, success);

        staffCheckin = new Scene(ecAssemble, 450, 375);
        signoutAction(staffCheckin);
        goToScene(staffCheckin);
    }

    // REQUIRES: Employer has been checked in
    // MODIFIES: this
    // EFFECTS: assembles the template for private Employer scene and window opens it
    private void employerVerified(TextField todoInput) {
        VBox ecAssemble = employerIsInFrame(todoInput);

        employerCheckin = new Scene(ecAssemble, 450, 375);
        signoutAction(employerCheckin);
        goToScene(employerCheckin);
    }

    // EFFECTS: the template design for the private Staff scene
    private VBox staffIsInFrame(String input, Alert success) {
        success.setContentText("You have been successfully checked in.");
        success.showAndWait();
        new Staff(input);
        todoBox = initTodoBox();
        VBox empBox = new VBox(10);
        empBox.getChildren().addAll(time, todoBox);//employee check-in scene design
        empBox.setAlignment(Pos.CENTER);
        clockAction();
        VBox eoBox = new VBox();
        eoBox.getChildren().add(signout);
        eoBox.setAlignment(Pos.BOTTOM_CENTER);
        VBox ecAssemble = new VBox(200);
        ecAssemble.setAlignment(Pos.CENTER);
        ecAssemble.getChildren().addAll(empBox, eoBox);
        return ecAssemble;
    }

    // EFFECTS: the template design for the private Employer scene
    private VBox employerIsInFrame(TextField todoInput) {
        Label compose = new Label("Write your notification here");
        VBox employBox = new VBox(5); //employer check-in scene design
        todoBox = initTodoBox();
        employBox.getChildren().addAll(time, compose, todoInput, submit, todoBox);
        employBox.setAlignment(Pos.CENTER);
        clockAction();
        VBox eoBox = new VBox();
        eoBox.getChildren().add(signout);
        eoBox.setAlignment(Pos.BOTTOM_CENTER);
        VBox ecAssemble = new VBox(200);
        ecAssemble.setAlignment(Pos.CENTER);
        ecAssemble.getChildren().addAll(employBox, eoBox);
        return ecAssemble;
    }
}
