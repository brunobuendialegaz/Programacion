package org.example.proyectosemanasanta.controller.viewController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import lombok.Data;
import org.example.proyectosemanasanta.model.User;

import java.net.URL;
import java.util.ResourceBundle;

@Data
public class UserController implements Initializable {

    @FXML
    private Button checkInOutButton;

    @FXML
    private Button logOutButton;

    private User user;


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
