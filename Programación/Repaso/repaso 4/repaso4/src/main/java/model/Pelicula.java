package model;

import java.time.LocalDate;

public class Pelicula {

    private String titulo, direcetor;
    private int duracion, anio;
    private double calificacion;

    public Pelicula(String titulo, String direcetor, int duracion, int anio, double calificacion) {
        this.titulo = titulo;
        this.direcetor = direcetor;
        this.duracion = duracion;
        this.anio = anio;
        if (calificacion>=0&&calificacion<=10){
            this.calificacion = calificacion;
        } else {
            this.calificacion = 0;
        }
    }

    public Pelicula() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirecetor() {
        return direcetor;
    }

    public void setDirecetor(String direcetor) {
        this.direcetor = direcetor;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        if (calificacion>=0&&calificacion<=10){
            this.calificacion = calificacion;
        } else {
            System.out.println("Nota no valida, intentalo de nuevo.");
        }
    }

    public String obtenerDuracionFormateada(){
        return duracion/60 + " horas y " + duracion%60 + " minutos";
    }

    public boolean esClasica(){
        return (LocalDate.now().getYear()-anio)>25;
    }

    public boolean esRecomendable(){
        return calificacion>=7;
    }

    public void mostrarInfo(){
        System.out.println("titulo = " + titulo);
        System.out.println("direcetor = " + direcetor);
        System.out.println("duracion = " + obtenerDuracionFormateada());
        System.out.println("año = " + anio);
        System.out.println("calificacion = " + calificacion);
    }
}
