package org.example.proyectosemanasanta.model;

import javafx.collections.ObservableList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String firstName, secondName, dni, mail, userType;

    private List<Record> records;

    public User(){
        records = new ArrayList<>();
    }

}
