package org.example.proyectosemanasanta.controller.viewController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import lombok.Data;
import org.example.proyectosemanasanta.model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController extends BaseAdminController implements Initializable {

    @FXML
    private Button logOutButton;

    @FXML
    private Button checkInOutButton;

    @FXML
    private Button formButton;

    @FXML
    private Button userListButton;

    @FXML
    private Button checkListButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        actions();
    }

    private void actions() {
        logOutButton.setOnAction(this::logOut);
        checkInOutButton.setOnAction(event -> checkInOut(getUser()));
        formButton.setOnAction(event -> changeView(event, "adminFormView.fxml", "Add User View", getUser()));
        userListButton.setOnAction(event -> changeView(event, "adminListView.fxml", "Users List View", getUser()));
        checkListButton.setOnAction(event -> changeView(event, "recordsView.fxml", "Records List View", getUser()));

    }

}
