package org.example.bibliotecaterror.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lombok.Data;
import org.example.bibliotecaterror.MainApplication;
import org.example.bibliotecaterror.model.Libro;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Data
public class BookViewController implements Initializable {


    @FXML private Button botonLista1;

    @FXML private Text editorial;

    @FXML private Text fechaLanzamiento;

    @FXML private Text isbn;

    @FXML private Text nominaciones;

    @FXML private Text numPaginas;

    @FXML private Text titulo;

    // variable libro para traer el libro seleccionado en el listController
    private Libro libro;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        actions();
    }

    private void actions() {
        botonLista1.setOnAction(event -> {
            // cambio de ventana de nuevo a la principal
            try {
                Stage ventanaListas = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("listView.fxml"));
                Parent parent = fxmlLoader.load();
                ventanaListas.setTitle("Biblioteca Bruno Buendia Legaz");
                Scene scene = new Scene(parent);
                ventanaListas.setScene(scene);
                ventanaListas.show();
                ((Stage)(botonLista1.getScene().getWindow())).close();
            } catch (IOException | IllegalStateException e) {
                System.out.println("Error al cargar la ventana " + e);
            }

        });
    }



    public void iniciarGUI() {
        editorial.setText(libro.getPublisher());
        fechaLanzamiento.setText(libro.getYear().toString());
        isbn.setText(libro.getIsbn());
        numPaginas.setText(libro.getPages().toString());
        titulo.setText(libro.getTitle());
    }
}
