package org.example.proyectosemanasanta.model;

import javafx.collections.ObservableList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String nombre, apellido, dni, correo, tipoUsuario;

    private ObservableList<Record> records;

}
