package org.example.proyectosemanasanta.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String time, type;

    private User user;


}
