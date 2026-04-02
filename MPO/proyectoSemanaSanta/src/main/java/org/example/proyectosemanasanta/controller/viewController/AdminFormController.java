package org.example.proyectosemanasanta.controller.viewController;

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
    private RadioButton adminRadio;

    @FXML
    private Button checkInOut;

    @FXML
    private Button checkInOutList;

    @FXML
    private Button clearButton;

    @FXML
    private TextField dni;

    @FXML
    private TextField firstNameField;

    @FXML
    private Button logOutButton;

    @FXML
    private TextField mail;

    @FXML
    private TextField secondNameField;

    @FXML
    private Button userListButton;

    @FXML
    private RadioButton userRadio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instances();
        initGUI();
        actions();
    }

    private void actions() {
    }

    private void initGUI() {
    }

    private void instances() {
    }
}
