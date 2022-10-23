package com.example.gui_airline_ticket_reservation_system;

import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        LoginWindow s = new LoginWindow();
        s.printLoginWindow();


    }

    public static void main(String[] args) {
        launch();
    }
}