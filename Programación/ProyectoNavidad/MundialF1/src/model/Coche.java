package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Coche {

    private String nombre;
    private String escuderia;
    private int kms;
    private int puntos;

    public Coche (String nombre){
        this.nombre = nombre;
        this.kms = 0;
        this.puntos = 0;
    }

}
