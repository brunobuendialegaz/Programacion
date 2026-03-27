module org.example.bibliotecaterror {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires lombok;
    requires com.google.gson;
    requires java.net.http;
    requires java.compiler;


    opens org.example.bibliotecaterror to javafx.fxml;
    exports org.example.bibliotecaterror;

    opens org.example.bibliotecaterror.controller to javafx.fxml;
    opens org.example.bibliotecaterror.model to com.google.gson, javafx.base;


}