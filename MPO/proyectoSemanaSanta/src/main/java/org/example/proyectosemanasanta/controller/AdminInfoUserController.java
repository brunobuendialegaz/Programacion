package org.example.proyectosemanasanta.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminInfoUserController implements Initializable {

    @FXML
    private Button adminFormButton;

    @FXML
    private Button adminListButton;

    @FXML
    private Button delButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Text mailText;

    @FXML
    private Text nameText;

    @FXML
    private TableView<Record> recordsTable;

    @FXML
    private TableColumn<Record, String> timeColumn;

    @FXML
    private TableColumn<Record, String> typeColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
