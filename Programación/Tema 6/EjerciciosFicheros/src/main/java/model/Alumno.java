package model;

public class Alumno {

    private String Nombre;
    private int edad;
    private double nota;

    public Alumno(String nombre, int edad, double nota) {
        Nombre = nombre;
        this.edad = edad;
        this.nota = nota;
    }

    public Alumno() {
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String toCsv (){
        return getNombre()+","+getEdad()+","+getNota();
    }
}
