package org.example.bibliotecaterror;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.bibliotecaterror.controller.ApiController;
import org.example.bibliotecaterror.controller.MainViewController;
import org.example.bibliotecaterror.model.Biblioteca;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/org/example/bibliotecaterror/listView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Biblioteca Bruno Buendia Legaz");
        stage.setScene(scene);
        stage.show();
    }
}
