package com.example.gui_airline_ticket_reservation_system;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuWindow {
    private static final float prefHeight = 45;
    private static final float prefWidth = 150;

    public void PrintMenuWindow() {
        Stage menuStage = new Stage();

        //rootPane
        AnchorPane rootPane = new AnchorPane();
        rootPane.setPrefSize(1366, 768);
        rootPane.setBackground(new Background(new BackgroundFill(Color.rgb(205, 252, 246), null, null)));

        //Second AnchorPane
        AnchorPane secondPane = new AnchorPane();
        secondPane.setLayoutX(-2);
        secondPane.setLayoutY(85);
        secondPane.setPrefSize(1366, 575);

        TextArea listView = new TextArea();
        listView.setPrefSize(1356, 498);
        listView.setLayoutX(8);
        listView.setLayoutY(7);
        listView.setEditable(false);

        //multiPurpose Button
        Button multiButton = new Button();
        multiButton.setStyle(LoginWindow.ButtonColor);
        multiButton.setPrefSize(prefWidth, prefHeight);
        multiButton.setCursor(Cursor.HAND);
        multiButton.setLayoutX(611);
        multiButton.setLayoutY(518);

        secondPane.getChildren().addAll(listView, multiButton);


        //HBox
        HBox buttonPane = new HBox();
        buttonPane.setSpacing(5);
        buttonPane.setPadding(new Insets(10, 10, 10, 10));
        buttonPane.setLayoutX(110);
        buttonPane.setLayoutY(14);
        buttonPane.setPrefSize(1146, 50);

        //Buttons
        Button displayFlight = new Button("Display flight’s info");
        displayFlight.setStyle(LoginWindow.ButtonColor);
        displayFlight.setPrefSize(prefWidth, prefHeight);
        displayFlight.setCursor(Cursor.HAND);
        displayFlight.setOnAction(e -> {
            secondPane.getChildren().clear();
            secondPane.getChildren().addAll(multiButton, listView);

            multiButton.setText("Display");
            multiButton.setOnAction(x -> listView.setText("****************************************************************************************************************" +
                    "*********** Flights **********************************************************" +
                    "******************************************************************************\n" + Read.flightsRecord.Display()));

        });

        Button displayPassenger = new Button("Display Passengers info");
        displayPassenger.setStyle(LoginWindow.ButtonColor);
        displayPassenger.setPrefSize(prefWidth, prefHeight);
        displayPassenger.setCursor(Cursor.HAND);
        displayPassenger.setOnAction(e -> {
            secondPane.getChildren().clear();
            secondPane.getChildren().addAll(multiButton, listView);

            multiButton.setText("Display");
            listView.setText("");
            multiButton.setOnAction(x -> listView.setText("****************************************************************************************************************" +
                    "*********** Passengers **********************************************************" +
                    "******************************************************************************\n" + Read.DisplayPassenger()));
        });

        Button modifyFlights = new Button("Add & Edit flights");
        modifyFlights.setStyle(LoginWindow.ButtonColor);
        modifyFlights.setPrefSize(prefWidth, prefHeight);
        modifyFlights.setCursor(Cursor.HAND);
        modifyFlights.setOnAction(e -> {
            secondPane.getChildren().clear();
            secondPane.getChildren().addAll(multiButton, listView);

            multiButton.setText("Modify");
            listView.setText("");
            multiButton.setOnAction(x -> listView.setText("modify Flights"));
        });

        Button reserveTicket = new Button("Reserve a ticket");
        reserveTicket.setStyle(LoginWindow.ButtonColor);
        reserveTicket.setPrefSize(prefWidth, prefHeight);
        reserveTicket.setCursor(Cursor.HAND);
        reserveTicket.setOnAction(e -> {
            secondPane.getChildren().clear();
            secondPane.getChildren().addAll(multiButton, listView);

            multiButton.setText("Reserve");
            listView.setText("");
            multiButton.setOnAction(x -> listView.setText("reserve Ticket"));

        });

        Button cancelReservation = new Button("Cancel a reservation");
        cancelReservation.setStyle(LoginWindow.ButtonColor);
        cancelReservation.setPrefSize(prefWidth, prefHeight);
        cancelReservation.setCursor(Cursor.HAND);
        cancelReservation.setOnAction(e -> {
            secondPane.getChildren().clear();
            secondPane.getChildren().addAll(multiButton, listView);

            multiButton.setText("Cancel");
            listView.setText("");
            multiButton.setOnAction(x -> listView.setText("cancel Reservation"));

        });

        Button checkTicket = new Button("Check a ticket");
        checkTicket.setStyle(LoginWindow.ButtonColor);
        checkTicket.setPrefSize(prefWidth, prefHeight);
        checkTicket.setCursor(Cursor.HAND);
        checkTicket.setOnAction(e -> {
            secondPane.getChildren().clear();
            secondPane.getChildren().addAll(multiButton, listView);

            multiButton.setText("Check");
            listView.setText("");
            multiButton.setOnAction(x -> listView.setText("checkTicket"));

        });

        Button searchPassenger = new Button("Search For Passenger");
        searchPassenger.setStyle(LoginWindow.ButtonColor);
        searchPassenger.setPrefSize(prefWidth, prefHeight);
        searchPassenger.setCursor(Cursor.HAND);
        searchPassenger.setOnAction(e -> {
            secondPane.getChildren().clear();
            secondPane.getChildren().addAll(multiButton, listView);

            multiButton.setText("Search");
            listView.setText("");
            multiButton.setOnAction(x -> listView.setText("search Passenger"));

        });

        Button LogOut = new Button("LogOut");
        LogOut.setPrefSize(70, 20);
        LogOut.setLayoutX(1282);
        LogOut.setLayoutY(669);
        LogOut.setStyle(LoginWindow.ButtonColor);
        LogOut.setCursor(Cursor.CLOSED_HAND);
        LogOut.setOnAction(e -> {
            LoginWindow loginWindow = new LoginWindow();
            loginWindow.printLoginWindow();
            menuStage.close();
        });

        buttonPane.getChildren().addAll(displayFlight, displayPassenger, modifyFlights, reserveTicket, cancelReservation, checkTicket, searchPassenger);


        rootPane.getChildren().addAll(buttonPane, secondPane, LogOut);

        Scene scene = new Scene(rootPane);

        menuStage.setScene(scene);
        menuStage.setTitle("Menu");
        menuStage.setMaximized(true);
        menuStage.getIcons().add(LoginWindow.icon);
        menuStage.show();
    }
}
