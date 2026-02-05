package model;

public class Alumno {

    private String nombre;
    private double notaTeoria, notaPractica;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNotaPractica(int notaPractica) {
        this.notaPractica = notaPractica;
    }

    public double getNotaPractica() {
        return notaPractica;
    }

    public void setNotaTeoria(int notaTeoria) {
        this.notaTeoria = notaTeoria;
    }

    public double getNotaTeoria() {
        return notaTeoria;
    }

    public Alumno (){}

    public Alumno (String nombre, int notaTeoria, int notaPractica){
        this.nombre = nombre;
        this.notaTeoria = notaTeoria;
        this.notaPractica = notaPractica;
    }

    

}
