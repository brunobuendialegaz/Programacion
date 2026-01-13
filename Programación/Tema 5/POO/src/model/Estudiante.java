package model;

import java.util.Scanner;

public class Estudiante extends Persona {

    private double nota;

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        Scanner s = new Scanner(System.in);
        while (nota<0||nota>10){
            System.out.print("\nAsignando nota "+nota+"... ");
            System.out.print("Nota no valida, introduce una nota valida...");
            nota = s.nextInt();
        }
        this.nota = nota;
        System.out.println("Nota "+nota+" asignada.");
        s.close();
    }

    public Estudiante(){}

    public Estudiante(String nombre, int edad, double nota){
        super(nombre, edad);
        this.nota = nota;
    }

    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("nota = " + nota);
    }



}
