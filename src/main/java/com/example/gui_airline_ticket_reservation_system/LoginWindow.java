package com.example.gui_airline_ticket_reservation_system;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginWindow {
    private final String username_admin = "rami";
    private final String password_admin = "rami2006";
    public static String ButtonColor = "-fx-background-color: #98A8F8";
    public static Image icon = new Image("file:C:\\Users\\rami0\\Desktop\\Java_Project\\GUI_Airline_ticket_reservation_system\\src\\main\\java\\com\\example\\gui_airline_ticket_reservation_system\\imgs\\airplane.png");

    public void printLoginWindow() {
        Stage mainStage = new Stage();

        //Root pane
        AnchorPane rootPane = new AnchorPane();
        rootPane.setPrefSize(600, 400);
        rootPane.setBackground(new Background(new BackgroundFill(Color.rgb(205, 252, 246), null, null)));

        //image
        ImageView image = new ImageView();
        image.setImage(new Image("file:C:\\Users\\rami0\\Desktop\\Java_Project\\GUI_Airline_ticket_reservation_system\\src\\main\\java\\com\\example\\gui_airline_ticket_reservation_system\\imgs\\Login.png"));
        image.setFitHeight(122);
        image.setFitWidth(131);
        image.setLayoutX(14);
        image.setLayoutY(14);

        //labels
        Label userName = new Label("User name");
        userName.setPrefSize(70, 20);
        userName.setLayoutX(217);
        userName.setLayoutY(134);

        Label password = new Label("Password");
        password.setPrefSize(70, 20);
        password.setLayoutX(217);
        password.setLayoutY(190);

        //TextFiled
        TextField UserNameTxt = new TextField();
        UserNameTxt.setPrefSize(150, 20);
        UserNameTxt.setLayoutX(311);
        UserNameTxt.setLayoutY(132);
        UserNameTxt.setPromptText("Enter your User Name");

        PasswordField passwordTxt = new PasswordField();
        passwordTxt.setPrefSize(150, 20);
        passwordTxt.setLayoutX(311);
        passwordTxt.setLayoutY(188);
        passwordTxt.setPromptText("Enter your Password");

        //Buttons
        Button login = new Button("LOGIN");
        login.setPrefSize(150, 20);
        login.setLayoutX(236);
        login.setLayoutY(237);
        login.setStyle(ButtonColor);
        login.setCursor(Cursor.HAND);
        login.setOnAction(e -> {
            if (UserNameTxt.getText().equals(username_admin) && passwordTxt.getText().equals(password_admin)) {
                ReadWindow readWindow = new ReadWindow();
                readWindow.ReadWin();
                mainStage.close();
            } else {
                Alert Error = new Alert(Alert.AlertType.ERROR);
                Error.setTitle("Wrong");
                Error.setContentText("Wrong password or username");
                Error.show();
            }
        });

        Button Exit = new Button("Exit");
        Exit.setPrefSize(70, 30);
        Exit.setLayoutX(516);
        Exit.setLayoutY(356);
        Exit.setStyle(ButtonColor);
        Exit.setCursor(Cursor.CLOSED_HAND);
        Exit.setOnAction(e -> mainStage.close());

        rootPane.getChildren().addAll(userName, password, UserNameTxt, passwordTxt, login, Exit, image);

        //Scene
        Scene mainScene = new Scene(rootPane);
        mainStage.setScene(mainScene);
        mainStage.setTitle("Login");
        mainStage.resizableProperty().setValue(false);

        //icon for login page
        mainStage.getIcons().add(icon);
        mainStage.show();
    }
}
