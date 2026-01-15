package ej3;

public class Persona {

    private String nombre;
    private int edad;

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona(){}

    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public void presentarse(){
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años.");
    }

}
