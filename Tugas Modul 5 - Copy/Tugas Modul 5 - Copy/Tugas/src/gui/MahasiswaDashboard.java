// File: gui/MahasiswaDashboard.java
package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import Main.LoginSystem;
import Data.Item;

public class MahasiswaDashboard extends VBox {
    public MahasiswaDashboard(Stage stage) {
        setSpacing(10);
        setPadding(new Insets(10));

        Label title = new Label("Mahasiswa Dashboard");

        TextField namaField = new TextField();
        namaField.setPromptText("Nama Barang");

        TextField descField = new TextField();
        descField.setPromptText("Deskripsi");

        TextField lokasiField = new TextField();
        lokasiField.setPromptText("Lokasi");

        Button laporBtn = new Button("Laporkan");

        ListView<String> laporanList = new ListView<>();
        for (Item item : LoginSystem.ReportedItems) {
            if (item.getStatus().equalsIgnoreCase("Reported")) {
                laporanList.getItems().add(item.getNamaItem() + " - " + item.getLokasi());
            }
        }

        laporBtn.setOnAction(e -> {
            String nama = namaField.getText();
            String desc = descField.getText();
            String lokasi = lokasiField.getText();

            if (!nama.isEmpty() && !lokasi.isEmpty()) {
                Item item = new Item(nama, desc, lokasi, "Reported");
                LoginSystem.ReportedItems.add(item);
                laporanList.getItems().add(nama + " - " + lokasi);
                namaField.clear();
                descField.clear();
                lokasiField.clear();
            }
        });

        Button back = new Button("Logout");
        back.setOnAction(e -> stage.setScene(new Scene(new loginPanel(stage), 400, 300)));

        getChildren().addAll(title, namaField, descField, lokasiField, laporBtn, new Label("Laporan Barang:"), laporanList, back);
    }
}
