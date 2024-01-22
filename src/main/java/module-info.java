module org.example.ortalamahesapla {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ortalamahesapla to javafx.fxml;
    exports org.example.ortalamahesapla;
}