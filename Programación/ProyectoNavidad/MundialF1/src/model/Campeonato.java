package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Campeonato {

    private ArrayList<Carrera> carreras = new ArrayList<>();
    private String nombre;

}
