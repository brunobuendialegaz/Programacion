module org.example.proyectosemanasanta {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens org.example.proyectosemanasanta to javafx.fxml;
    exports org.example.proyectosemanasanta;
}