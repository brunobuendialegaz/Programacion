module org.example.bibliotecaterror {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires lombok;
    requires com.google.gson;


    opens org.example.bibliotecaterror to javafx.fxml;
    exports org.example.bibliotecaterror;

    opens org.example.bibliotecaterror.controller to javafx.fxml;

}