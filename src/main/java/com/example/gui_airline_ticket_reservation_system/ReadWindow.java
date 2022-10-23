package com.example.gui_airline_ticket_reservation_system;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class ReadWindow {
    private final FileChooser fileChooser = new FileChooser();

    public void ReadWin() {
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        Stage mainStage = new Stage();

        AnchorPane rootPane = new AnchorPane();
        rootPane.setPrefSize(600, 400);
        rootPane.setBackground(new Background(new BackgroundFill(Color.rgb(205, 252, 246), null, null)));

        //image
        ImageView image = new ImageView();
        image.setImage(new Image("file:C:\\Users\\rami0\\Desktop\\Java_Project\\GUI_Airline_ticket_reservation_system\\src\\main\\java\\com\\example\\gui_airline_ticket_reservation_system\\imgs\\ReadFiles.png"));
        image.setFitHeight(122);
        image.setFitWidth(131);
        image.setLayoutX(14);
        image.setLayoutY(14);

        //Buttons
        Button ReadFlights = new Button("Read Flights");
        ReadFlights.setPrefSize(150, 30);
        ReadFlights.setLayoutX(224);
        ReadFlights.setLayoutY(153);
        ReadFlights.setStyle(LoginWindow.ButtonColor);
        ReadFlights.setCursor(Cursor.HAND);
        ReadFlights.setOnAction(e -> {
            fileChooser.setTitle("Read flights file");

            File SelectedFile = fileChooser.showOpenDialog(mainStage);

        });

        Button ReadPassenger = new Button("Read Passengers");
        ReadPassenger.setPrefSize(150, 30);
        ReadPassenger.setLayoutX(224);
        ReadPassenger.setLayoutY(216);
        ReadPassenger.setStyle(LoginWindow.ButtonColor);
        ReadPassenger.setCursor(Cursor.HAND);
        ReadPassenger.setOnAction(e -> {
            fileChooser.setTitle("Read passenger file");

            File SelectedFile = fileChooser.showOpenDialog(mainStage);

        });

        Button LogOut = new Button("LogOut");
        LogOut.setPrefSize(70, 30);
        LogOut.setLayoutX(516);
        LogOut.setLayoutY(356);
        LogOut.setStyle(LoginWindow.ButtonColor);
        LogOut.setCursor(Cursor.CLOSED_HAND);
        LogOut.setOnAction(e -> {
            LoginWindow loginWindow = new LoginWindow();
            loginWindow.printLoginWindow();
            mainStage.close();
        });

        rootPane.getChildren().addAll(ReadPassenger, ReadFlights, LogOut, image);

        //Scene
        Scene mainScene = new Scene(rootPane);
        mainStage.setScene(mainScene);
        mainStage.setTitle("Login ");

        //icon for login page
        mainStage.getIcons().add(LoginWindow.icon);
        mainStage.show();
    }
}
