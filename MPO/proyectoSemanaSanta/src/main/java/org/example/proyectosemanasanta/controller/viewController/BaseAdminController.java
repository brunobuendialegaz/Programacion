package org.example.proyectosemanasanta.controller.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Data;
import org.example.proyectosemanasanta.MainApplication;
import org.example.proyectosemanasanta.model.User;

import java.io.IOException;

@Data
public abstract class BaseAdminController extends BaseController{

    public void changeView(ActionEvent event, String view, String title, User user){
        try {
            Stage ventanaLogin = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(view));
            Parent parent = fxmlLoader.load();
            Object newController = fxmlLoader.getController();
            if (newController instanceof BaseController) {
                ((BaseController) newController).setUser(user);
            }
            ventanaLogin.setTitle(title);
            Scene scene = new Scene(parent);
            ventanaLogin.setScene(scene);
            ventanaLogin.show();
            Node source = (Node) event.getSource();
            ((Stage)(source.getScene().getWindow())).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
