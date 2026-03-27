package org.example.bibliotecaterror.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class BookViewController implements Initializable {


    @FXML private Button botonLista1;

    @FXML private Button botonListaFav1;

    @FXML private Text editorial;

    @FXML private Text fechaLanzamiento;

    @FXML private Text isbn;

    @FXML private Text nominaciones;

    @FXML private Text numPaginas;

    @FXML private Text titulo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
