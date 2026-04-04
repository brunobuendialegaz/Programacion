package org.example.proyectosemanasanta.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Data;
import org.example.proyectosemanasanta.controller.DataController;
import org.example.proyectosemanasanta.model.User;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class DataUsers implements Serializable {

    private static DataUsers instance;

    private ObservableList<User> users;

    private User focusUser;

    private final DataController dataController = new DataController();

    private DataUsers(){
        ObservableList<User> importUsers = dataController.importUsers();
        users = FXCollections.observableArrayList();

        if (importUsers == null){
            users.add(new User("admin", "admin", "dni", "admin@gmail.com", "admin", new ArrayList<>()));
            users.add(new User("user", "user", "dni", "user@gmail.com", "user", new ArrayList<>()));
        } else {
            users = importUsers;
        }
    }

    private void setUsers(ObservableList<User> users) {
        this.users = users;
    }

    public static DataUsers getInstance(){
        if (instance == null){
            instance = new DataUsers();
        }
        return instance;
    }
}
