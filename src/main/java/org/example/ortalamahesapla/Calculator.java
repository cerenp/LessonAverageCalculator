package org.example.ortalamahesapla;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Calculator extends Application {

    private final TextField tfVize = new TextField();
    private final TextField tfFinal = new TextField();
    private final TextField tfOrtalama = new TextField();
    private final TextField tfHarfNotu = new TextField();
    private final Button btHesapla = new Button("Hesapla");


    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Vize Notunuz :"), 0, 0);
        gridPane.add(tfVize, 1, 0);
        gridPane.add(new Label("Final Notunuz :"), 0, 1);
        gridPane.add(tfFinal, 1, 1);
        gridPane.add(new Label("Ortalamanız :"), 0, 2);
        gridPane.add(tfOrtalama, 1, 2);
        gridPane.add(new Label("Harf Notunuz :"), 0, 3);
        gridPane.add(tfHarfNotu, 1, 3);
        gridPane.add(btHesapla, 1, 4);

        gridPane.setAlignment(Pos.CENTER);
        tfVize.setAlignment(Pos.BOTTOM_RIGHT);
        tfFinal.setAlignment(Pos.BOTTOM_RIGHT);

        tfHarfNotu.setAlignment(Pos.BOTTOM_RIGHT);
        tfHarfNotu.setEditable(false);
        tfOrtalama.setAlignment(Pos.BOTTOM_RIGHT);
        tfOrtalama.setEditable(false);

        GridPane.setHalignment(btHesapla, HPos.RIGHT);
        GridPane.setHalignment(tfHarfNotu, HPos.RIGHT);

        btHesapla.setOnAction(e -> NotHesapla());


        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setTitle("Not Hesaplayıcı");
        primaryStage.setScene(scene);
        gridPane.setStyle("-fx-background-color: GRAY");
        primaryStage.show();
    }

    private void NotHesapla() {


        double vizeNotu = 0;
        double finalNotu = 0;
        try {
            vizeNotu = Double.parseDouble(tfVize.getText()) * 40 / 100;
            finalNotu = Double.parseDouble(tfFinal.getText()) * 60 / 100;
        } catch (NumberFormatException e) {
            tfOrtalama.setText("Lütfen sayı giriniz");
            tfOrtalama.setStyle("-fx-text-fill: red");
            tfHarfNotu.setText("Lütfen sayı giriniz");
            tfHarfNotu.setStyle("-fx-text-fill: red");

            return;
        }

        double ortalama = vizeNotu + finalNotu;
        String harfNotu = tfHarfNotu.getText();
        tfOrtalama.setText(String.valueOf(ortalama));


        if (ortalama >= 45) {
            tfOrtalama.setStyle("-fx-text-fill: green");
        } else if (ortalama < 45) {
            tfOrtalama.setStyle("-fx-text-fill: red");
        }

        if (finalNotu / 0.6 < 45) {
            tfOrtalama.setStyle("-fx-text-fill: red");
            harfNotu = "FF";
        } else if (ortalama >= 81) {
            harfNotu = "AA";
        } else if (ortalama >= 76) {
            harfNotu = "BA";
        } else if (ortalama >= 70) {
            harfNotu = "BB";
        } else if (ortalama >= 60) {
            harfNotu = "CB";
        } else if (ortalama >= 50) {
            harfNotu = "CC";
        } else if (ortalama >= 45) {
            harfNotu = "DC";
        } else if (ortalama >= 40) {
            harfNotu = "DD";
        } else if (ortalama >= 30) {
            harfNotu = "FD";
        } else {
            harfNotu = "FF";
        }
        tfHarfNotu.setText(harfNotu);


    }


    public static void main(String[] args) {
        launch(args);
    }
}


