package model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {


    private String nombre, apellido, dni;


    @Override
    public String toString() {
        return String.format("%s,%s,%s",nombre,apellido,dni);
    }
}
