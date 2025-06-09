// File: gui/MainApp.java
package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        loginPanel login = new loginPanel(primaryStage);
        Scene scene = new Scene(login, 400, 300);
        primaryStage.setTitle("Login System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
