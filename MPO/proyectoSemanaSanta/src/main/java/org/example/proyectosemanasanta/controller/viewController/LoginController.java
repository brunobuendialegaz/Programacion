package org.example.proyectosemanasanta.controller.viewController;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.proyectosemanasanta.MainApplication;
import org.example.proyectosemanasanta.data.DataUsers;
import org.example.proyectosemanasanta.model.User;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField emailField;

    @FXML
    private Button loginButton;

    @FXML
    private TextField passwordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        actions();

    }

    private void actions() {
        loginButton.setOnAction(event -> {
            String email = emailField.getText();
            String pass = passwordField.getText();
            Optional<User> user = DataUsers.getInstance().getUsers().stream().filter(item -> item.getCorreo().toLowerCase().equals(email)).findAny();
            if (user.isPresent() && user.get().getDni().equalsIgnoreCase(pass)
                    && user.get().getTipoUsuario().equalsIgnoreCase("admin")) {
                try {
                    Stage adminView = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("adminView.fxml"));
                    Parent parent = fxmlLoader.load();
                    AdminController adminController = fxmlLoader.getController();
                    adminController.setUser(user.get());
                    adminView.setTitle("Admin View");
                    Scene scene = new Scene(parent);
                    adminView.setScene(scene);
                    adminView.show();
                    ((Stage)(loginButton.getScene().getWindow())).close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            } else if (user.isPresent() && user.get().getDni().equalsIgnoreCase(pass)
                    && user.get().getTipoUsuario().equalsIgnoreCase("user")) {
                try {
                    Stage userView = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("userView.fxml"));
                    Parent parent = fxmlLoader.load();
                    UserController userController = fxmlLoader.getController();
                    userController.setUser(user.get());
                    userView.setTitle("User View");
                    Scene scene = new Scene(parent);
                    userView.setScene(scene);
                    userView.show();
                    ((Stage)(loginButton.getScene().getWindow())).close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                Alert dialogPane = new Alert(Alert.AlertType.ERROR);
                dialogPane.setHeaderText("Error");
                dialogPane.setContentText("Usuario no valido.");
                dialogPane.show();
            }

        });
    }

}
