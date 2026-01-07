package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Carrera {

    private String nombre;
    private int kms;
    private ArrayList<Coche> participantes = new ArrayList<>();


}
