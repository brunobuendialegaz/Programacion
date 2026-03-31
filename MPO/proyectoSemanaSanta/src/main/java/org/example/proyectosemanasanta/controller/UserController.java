package org.example.proyectosemanasanta.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import lombok.Data;

import java.net.URL;
import java.util.ResourceBundle;

@Data
public class UserController implements Initializable {

    @FXML
    private Button checkInOutButton;

    @FXML
    private Button logOutButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
