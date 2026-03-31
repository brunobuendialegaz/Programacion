package org.example.proyectosemanasanta.data;

import javafx.collections.ObservableList;
import lombok.Data;
import org.example.proyectosemanasanta.model.User;

@Data
public class DataUsers {

    private ObservableList<User> users;
}
