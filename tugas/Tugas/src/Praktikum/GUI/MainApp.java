package Praktikum.GUI;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginPane loginPane = new LoginPane();
        loginPane.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
