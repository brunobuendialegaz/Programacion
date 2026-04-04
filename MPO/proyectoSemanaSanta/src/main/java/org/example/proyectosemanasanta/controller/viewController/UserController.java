package org.example.proyectosemanasanta.controller.viewController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import lombok.Data;
import org.example.proyectosemanasanta.model.User;

import java.net.URL;
import java.util.ResourceBundle;

@Data
public class UserController extends BaseController implements Initializable {

    @FXML
    private Button checkInOutButton;

    @FXML
    private Button logOutButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        actions();
    }

    private void actions() {
        checkInOutButton.setOnAction(event -> checkInOut(getUser()));
        logOutButton.setOnAction(this::logOut);
    }

}
