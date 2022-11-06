package com.example.gui_airline_ticket_reservation_system;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

            //Labels
            Label flightNumberLabel = new Label("Flight Number");
            flightNumberLabel.setLayoutX(511);
            flightNumberLabel.setLayoutY(96);
            flightNumberLabel.setPrefSize(100, 20);

            Label airLineNameLabel = new Label("AirLine Name");
            airLineNameLabel.setLayoutX(511);
            airLineNameLabel.setLayoutY(145);
            airLineNameLabel.setPrefSize(100, 20);

            Label sourceLabel = new Label("Source");
            sourceLabel.setLayoutX(511);
            sourceLabel.setLayoutY(195);
            sourceLabel.setPrefSize(100, 20);

            Label destinationLabel = new Label("Destination");
            destinationLabel.setLayoutX(511);
            destinationLabel.setLayoutY(237);
            destinationLabel.setPrefSize(100, 20);

            Label capacityLabel = new Label("Capacity");
            capacityLabel.setLayoutX(511);
            capacityLabel.setLayoutY(278);
            capacityLabel.setPrefSize(100, 20);


            //TextField
            TextField flightNumberTxt = new TextField();
            flightNumberTxt.setLayoutX(612);
            flightNumberTxt.setLayoutY(93);

            TextField airLineNameTxt = new TextField();
            airLineNameTxt.setLayoutX(612);
            airLineNameTxt.setLayoutY(142);

            TextField sourceTxt = new TextField();
            sourceTxt.setLayoutX(612);
            sourceTxt.setLayoutY(192);

            TextField destinationTxt = new TextField();
            destinationTxt.setLayoutX(612);
            destinationTxt.setLayoutY(234);

            TextField capacityTxt = new TextField();
            capacityTxt.setLayoutX(612);
            capacityTxt.setLayoutY(275);

            Button Edit = new Button("Modify");
            Edit.setStyle(LoginWindow.ButtonColor);
            Edit.setPrefSize(prefWidth, prefHeight);
            Edit.setCursor(Cursor.HAND);
            Edit.setLayoutX(436);
            Edit.setLayoutY(518);
            Edit.setDisable(true);


            multiButton.setText("Search");
            multiButton.setOnAction(x -> {
                Node<Flight> Search = null;
                if (!flightNumberTxt.getText().trim().equals("")) {
                    Search = Read.flightsRecord.search(new Flight(Integer.parseInt(flightNumberTxt.getText().trim()), null, null, null, 0));

                } else {
                    Alert Error = new Alert(Alert.AlertType.ERROR);
                    Error.setTitle("Empty");
                    Error.setContentText("Please Enter Flight Number");
                    Error.show();
                }
                if (Search != null) {
                    flightNumberTxt.setText(String.valueOf(Search.getData().getFlightNumber()));
                    airLineNameTxt.setText(Search.getData().getAirLineName());
                    sourceTxt.setText(Search.getData().getSource());
                    destinationTxt.setText(Search.getData().getDestination());
                    capacityTxt.setText(String.valueOf(Search.getData().getCapacity()));
                    Edit.setDisable(false);
                    Node<Flight> finalSearch = Search;
                    Edit.setOnAction(q -> {
                        if (!flightNumberTxt.getText().equals("") && !airLineNameTxt.getText().equals("") && !sourceTxt.getText().equals("")
                                && !destinationTxt.getText().equals("") && !capacityTxt.getText().equals("")) {
                            finalSearch.getData().setFlightNumber(Integer.parseInt(flightNumberTxt.getText()));
                            finalSearch.getData().setAirLineName(airLineNameTxt.getText());
                            finalSearch.getData().setSource(sourceTxt.getText());
                            finalSearch.getData().setDestination(destinationTxt.getText());
                            finalSearch.getData().setCapacity(Integer.parseInt(capacityTxt.getText()));
                            Alert Done = new Alert(Alert.AlertType.CONFIRMATION);
                            Done.setTitle("Done");
                            Done.setContentText("Done");
                            Done.show();
                        }
                    });
                } else {
                    Alert Error = new Alert(Alert.AlertType.ERROR);
                    Error.setTitle("Not Exist");
                    Error.setContentText("Not Exist Flight ");
                    Error.show();
                }
            });
            secondPane.getChildren().addAll(flightNumberLabel, flightNumberTxt, airLineNameLabel, airLineNameTxt, sourceLabel, sourceTxt, destinationLabel, destinationTxt,
                    capacityLabel, capacityTxt, multiButton, Edit);

        });

        Button reserveTicket = new Button("Reserve a ticket");
        reserveTicket.setStyle(LoginWindow.ButtonColor);
        reserveTicket.setPrefSize(prefWidth, prefHeight);
        reserveTicket.setCursor(Cursor.HAND);
        reserveTicket.setOnAction(e -> secondPane.getChildren().clear());

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
