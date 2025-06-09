// File: gui/loginPanel.java
package gui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import Main.LoginSystem;
import Users.*;

public class loginPanel extends VBox {
    public loginPanel(Stage stage) {
        setSpacing(10);
        setAlignment(Pos.CENTER);

        Label label1 = new Label("Username / Nama:");
        TextField input1 = new TextField();
        Label label2 = new Label("Password / NIM:");
        PasswordField input2 = new PasswordField();

        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {
            String user1 = input1.getText();
            String user2 = input2.getText();

            User user = LoginSystem.authenticate(user1, user2);
            if (user != null) {
                if (user instanceof Users.Admin) {
                    stage.setScene(new Scene(new AdminDashboard(stage), 500, 400));
                } else if (user instanceof Users.Mahasiswa) {
                    stage.setScene(new Scene(new MahasiswaDashboard(stage), 500, 400));
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Login gagal. Periksa kembali.");
                alert.show();
            }
        });

        getChildren().addAll(label1, input1, label2, input2, loginButton);
    }
}
