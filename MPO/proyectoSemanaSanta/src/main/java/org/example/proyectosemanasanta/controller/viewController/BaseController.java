package org.example.proyectosemanasanta.controller.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lombok.Data;
import org.example.proyectosemanasanta.MainApplication;
import org.example.proyectosemanasanta.controller.DataController;
import org.example.proyectosemanasanta.data.DataUsers;
import org.example.proyectosemanasanta.model.Record;
import org.example.proyectosemanasanta.model.User;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Optional;

@Data
public abstract class BaseController {

    private User user;

    private static final DataController dataController = new DataController();

    public void logOut(ActionEvent event){
        try {
            dataController.exportUsers();
            Stage ventanaLogin = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("loginView.fxml"));
            Parent parent = fxmlLoader.load();
            ventanaLogin.setTitle("Login Bruno Buendia");
            Scene scene = new Scene(parent);
            ventanaLogin.setScene(scene);
            ventanaLogin.show();
            Node source = (Node) event.getSource();
            ((Stage)(source.getScene().getWindow())).close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void checkInOut(User user){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        String dateTime = now.format(format);
        User activeUser = DataUsers.getInstance().getUsers().stream()
                .filter(item -> item.equals(user)).findAny().orElseThrow();
        Optional<Record> lastRecord = activeUser.getRecords().stream()
                .max(Comparator.comparing(record -> LocalDateTime.parse(record.getTime(), format)));
        String type = "in";
        if (lastRecord.isPresent() && lastRecord.get().getType().equals("in")){
            type = "out";
        }
        activeUser.getRecords().add(new Record(dateTime, type, user));
        Alert dialogPane = new Alert(Alert.AlertType.INFORMATION);
        dialogPane.setHeaderText("Info");
        dialogPane.setContentText("Fichaje Realizado Correctamente.");
        dialogPane.show();

    }


}
