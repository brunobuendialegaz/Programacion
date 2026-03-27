package org.example.bibliotecaterror.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javafx.collections.ObservableList;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Biblioteca {

    @SerializedName("data")
    @Expose
    private List<Libro> libros;

    }




