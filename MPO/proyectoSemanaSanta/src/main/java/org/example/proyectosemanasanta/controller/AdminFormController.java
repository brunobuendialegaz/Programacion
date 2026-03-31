package org.example.proyectosemanasanta.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminFormController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextField dni;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField mail;

    @FXML
    private TextField secondNameField;

    @FXML
    private RadioButton userRadio;

    @FXML
    private RadioButton adminRadio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
