package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Coche {

    private String nombre;
    private int kms, puntos, kmsTotales;

    public Coche (String nombre){
        this.nombre = nombre;
        kms = 0;
        puntos = 0;
        kmsTotales = 0;
    }

}
