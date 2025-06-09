// File: gui/AdminDashboard.java
package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import Data.Item;
import Main.LoginSystem;

public class AdminDashboard extends VBox {
    public AdminDashboard(Stage stage) {
        setSpacing(10);
        setPadding(new Insets(10));

        Label title = new Label("Admin Dashboard");

        ListView<String> itemList = new ListView<>();
        for (Item item : LoginSystem.ReportedItems) {
            itemList.getItems().add(item.getNamaItem() + " - " + item.getStatus());
        }

        Button back = new Button("Logout");
        back.setOnAction(e -> stage.setScene(new Scene(new loginPanel(stage), 400, 300)));

        getChildren().addAll(title, itemList, back);
    }
}
