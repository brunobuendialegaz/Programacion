package org.example.bibliotecaterror.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lombok.Data;
import org.example.bibliotecaterror.MainApplication;
import org.example.bibliotecaterror.model.Biblioteca;
import org.example.bibliotecaterror.model.Libro;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

@Data
public class BibliotecaController implements Initializable {

    @FXML private Button exportar;

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
        // instancio las listas del api para poder trabajar con ellas
        ApiController apiController = new ApiController();
        //instancio tambien el filecontroller para traerme los favoritos al iniciar el programa
        FileController fileController = new FileController();
        librosFavoritos = fileController.importarFavoritos();
        biblioteca = apiController.llamadaApi("https://stephen-king-api.onrender.com/api/books");
    }

    private void iniciarGUI() {
        // asigno los valores correspondientes de mis objetos a las columnas de la tabla
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("title"));
        columnaAnio.setCellValueFactory(new PropertyValueFactory<>("year"));
        columnaEditorial.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        columnaIsbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        // asigno el listado de objetos que debe mostrar
        ObservableList<Libro> libros = FXCollections.observableArrayList(biblioteca.getLibros());
        tablaLibro.setItems(libros);
    }

    private void action() {
        botonLista.setOnAction(event -> {
            //Aqui simplemente cambio la asignación de la tabla y doy mensaje
            tablaLibro.setItems(FXCollections.observableArrayList(biblioteca.getLibros()));
            Alert dialogPane = new Alert(Alert.AlertType.INFORMATION);
            dialogPane.setHeaderText("Info");
            dialogPane.setContentText("Lista general cargada.");
            dialogPane.show();
        });
        botonListaFav.setOnAction(event -> {
            //Aqui simplemente cambio la asignación de la tabla y doy mensaje
            tablaLibro.setItems(librosFavoritos);
            Alert dialogPane = new Alert(Alert.AlertType.INFORMATION);
            dialogPane.setHeaderText("Info");
            dialogPane.setContentText("Lista de favoritos cargada.");
            dialogPane.show();
        });
        botonLibro.setOnAction(event -> {
            //Selecciono el libro para la nueva ventana
            Libro libroSeleccionado = tablaLibro.getSelectionModel().getSelectedItem();
            if (libroSeleccionado!=null){
                try {
                    //cambio de ventana
                    Stage ventanaLibro = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("bookView.fxml"));
                    Parent parent = fxmlLoader.load();
                    //aqui traigo la instancia del controller de la nueva ventana para pasarle el libro
                    BookViewController bookViewController = fxmlLoader.getController();
                    bookViewController.setLibro(tablaLibro.getSelectionModel().getSelectedItem());
                    //Lanzo tambien aqui la inicialización del GUI, si lo meto en el metodo initialize falla
                    //por que intenta lanzar los datos del libro, pero aun es null
                    bookViewController.iniciarGUI();
                    ventanaLibro.setTitle("Vista Libro");
                    Scene scene = new Scene(parent);
                    ventanaLibro.setScene(scene);
                    ventanaLibro.show();
                ((Stage)(botonLista.getScene().getWindow())).close();

            } catch (IOException | IllegalStateException e) {
                System.out.println("Error al cargar la vista ");
                e.printStackTrace();
            }

            } else {
                Alert dialogPane = new Alert(Alert.AlertType.ERROR);
                dialogPane.setHeaderText("Error");
                dialogPane.setContentText("No hay libro seleccionado.");
                dialogPane.show();
            }
        });
        botonFav.setOnAction(event -> {
            //Agrega el libro a la lista de fav, si ya existe, lo borra
            if (!librosFavoritos.contains(tablaLibro.getSelectionModel().getSelectedItem())) {
                librosFavoritos.add(tablaLibro.getSelectionModel().getSelectedItem());
                Alert dialogPane = new Alert(Alert.AlertType.INFORMATION);
                dialogPane.setHeaderText("Info");
                dialogPane.setContentText(tablaLibro.getSelectionModel().getSelectedItem().getTitle() + " añadido a favoritos.");
                dialogPane.show();
            } else {
                Alert dialogPane = new Alert(Alert.AlertType.INFORMATION);
                dialogPane.setHeaderText("Info");
                dialogPane.setContentText(tablaLibro.getSelectionModel().getSelectedItem().getTitle() + " eliminado de favoritos.");
                dialogPane.show();
                librosFavoritos.remove(tablaLibro.getSelectionModel().getSelectedItem());
            }
        });
        exportar.setOnAction(event -> {
            FileController fileController = new FileController();
            fileController.exportarLibros(librosFavoritos);
            Alert dialogPane = new Alert(Alert.AlertType.INFORMATION);
            dialogPane.setHeaderText("Info");
            dialogPane.setContentText("Lista de favoritos exportada.");
            dialogPane.show();
        });

    }
}
