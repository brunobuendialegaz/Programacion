package org.example.bibliotecaterror.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.bibliotecaterror.model.Biblioteca;
import org.example.bibliotecaterror.model.Libro;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

public class BibliotecaController implements Initializable {

    @FXML private Button exportar;

    @FXML private Button importar;

    @FXML private Button botonFav;

    @FXML private Button botonLibro;

    @FXML private Button botonLista;

    @FXML private Button botonListaFav;

    @FXML
    private TableView<Libro> tablaLibro;

    @FXML private TableColumn<Libro, Number> columnaAnio;

    @FXML private TableColumn<Libro, String> columnaEditorial;

    @FXML private TableColumn<Libro, String> columnaIsbn;

    @FXML private TableColumn<Libro, String> columnaNombre;

    @FXML private TextField textFiltro;

    private Biblioteca biblioteca;

    private ObservableList<Libro> librosFavoritos;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instances();
        iniciarGUI();
        action();
    }

    private void instances() {
        ApiController apiController = new ApiController();
        librosFavoritos = FXCollections.observableArrayList();
        biblioteca = apiController.llamadaApi("https://stephen-king-api.onrender.com/api/books");
    }

    private void iniciarGUI() {
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnaAnio.setCellValueFactory(new PropertyValueFactory<>("year"));
        columnaEditorial.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        columnaIsbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        ObservableList<Libro> libros = FXCollections.observableArrayList(biblioteca.getLibros());
        tablaLibro.setItems(libros);

    }

    private void action() {
        botonLista.setOnAction(event -> tablaLibro.setItems(FXCollections.observableArrayList(biblioteca.getLibros())));
        botonListaFav.setOnAction(event -> tablaLibro.setItems(librosFavoritos));
        botonLibro.setOnAction(event -> { });
        botonFav.setOnAction(event -> {
            if (!librosFavoritos.contains(tablaLibro.getSelectionModel().getSelectedItem())) {
                librosFavoritos.add(tablaLibro.getSelectionModel().getSelectedItem());
            }
        });
        importar.setOnAction(event -> { });
        exportar.setOnAction(event -> { });

    }
}
