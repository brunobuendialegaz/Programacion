package org.example.proyectosemanasanta.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lombok.Data;
import org.example.proyectosemanasanta.model.User;

import java.net.URL;
import java.util.ResourceBundle;

@Data
public class AdminListController implements Initializable {

    @FXML
    private Button delButton;

    @FXML
    private Button logOutButton;

    @FXML
    private TableColumn<User, String> mailColumn;

    @FXML
    private Button showDetButton;

    @FXML
    private TableColumn<User, String> userColumn;

    @FXML
    private Button userFormButton;

    @FXML
    private TableView<User> userTable;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
