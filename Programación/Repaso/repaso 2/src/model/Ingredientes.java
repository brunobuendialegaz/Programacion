package model;

public enum Ingredientes {
    TOMATE("Tomate", 1.99),
    QUESO("Queso", 2.99),
    BACON("Bacon", 4),
    PINIA("Piña", 2.99),
    PEPPERONI("Pepperoni", 5),
    JAMON("Jamón", 6);


    private String nombre;
    private double precio;

    Ingredientes(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    Ingredientes() {
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }


}
