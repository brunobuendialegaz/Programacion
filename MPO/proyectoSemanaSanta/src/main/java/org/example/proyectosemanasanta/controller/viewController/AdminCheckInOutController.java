package org.example.proyectosemanasanta.controller.viewController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminCheckInOutController implements Initializable {

    @FXML
    private Button adminFormButton;

    @FXML
    private Button adminListButton;

    @FXML
    private Button checkInOutButton;

    @FXML
    private Button delButton;

    @FXML
    private Button logOutButton;

    @FXML
    private TableView<Record> recordsTable;

    @FXML
    private TableColumn<Record, String> timeColumn;

    @FXML
    private TableColumn<Record, String> typeColumn;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
