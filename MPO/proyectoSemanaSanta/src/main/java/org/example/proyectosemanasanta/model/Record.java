package org.example.proyectosemanasanta.model;

import java.io.Serial;
import java.io.Serializable;

public class Record implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String time, type;

    private User user;


}
