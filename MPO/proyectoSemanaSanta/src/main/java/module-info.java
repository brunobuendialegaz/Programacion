module org.example.proyectosemanasanta {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires lombok;
    requires javafx.base;

    opens org.example.proyectosemanasanta to javafx.fxml, lombok;
    exports org.example.proyectosemanasanta;

    opens org.example.proyectosemanasanta.controller to javafx.fxml, lombok;
    opens org.example.proyectosemanasanta.model to javafx.fxml, lombok, javafx.base;
    opens org.example.proyectosemanasanta.controller.viewController to javafx.fxml, lombok;
    exports org.example.proyectosemanasanta.controller.viewController;


}