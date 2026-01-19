package ej4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Notas {

    private HashMap<String, ArrayList<Double>> notas;

    public HashMap<String, ArrayList<Double>> getNotas() {
        return notas;
    }

    public void setNotas(HashMap<String, ArrayList<Double>> notas) {
        this.notas = notas;
    }

    public Notas() {
        notas = new HashMap<>();
    }

    public Notas(HashMap<String, ArrayList<Double>> notas) {
        this.notas = notas;
    }

    public void agregarEstudiante(String nombre){
        notas.put(nombre, new ArrayList<>());
    }

    public void agregarCalificacion(String nombre, double calificacion){
        if (!notas.containsKey(nombre)){
            System.out.println("El estudiante no existe");
            return;
        }
        notas.get(nombre).add(calificacion);
    }

    public double calcularPromedio(String nombre){
        if (!notas.containsKey(nombre)){
            System.out.println("El estudiante " + nombre + " no existe.");
            return 0.0;
        }
        ArrayList<Double> notasEstudiante = notas.get(nombre);
        if (notasEstudiante.isEmpty()){
            return 0.0;
        }
        double total = 0;
        for (Double item : notasEstudiante) {
            total += item;
        }
        return total/notasEstudiante.size();
    }

    public void mostrarCalificaciones(String nombre){
        if (!notas.containsKey(nombre)||notas.get(nombre).size()==0){
            System.out.println("No hay notas para este estudiante.");
            return;
        }
        ArrayList<Double> notasEstudiante = notas.get(nombre);
        System.out.print(nombre + ": ");
        System.out.println(notasEstudiante.toString());
    }

    public String mejorEstudiante(){
        if (notas.isEmpty()){
            return "No hay estudiantes.";
        } else {
            String mejorEstudiante = "";
            double notaMaxima = -1;
            for (String item : notas.keySet()) {
                double promedioActual = calcularPromedio(item);
                if(promedioActual>notaMaxima){
                    mejorEstudiante = item;
                    notaMaxima = promedioActual;
                }
            }
            return mejorEstudiante;
        }
    }

    public void listarEstudiantesAprobados(double notaMinima){
        if (notas.isEmpty()){
            System.out.println("No hay estudiantes");
            return;
        }
        System.out.println("Estudiantes aprobados: ");
        int contador = 0;
        for (String nombre : notas.keySet()) {
            double promedioActual = calcularPromedio(nombre);
            if (promedioActual>=notaMinima){
                System.out.println("- " + nombre + " nota: " + promedioActual);
                contador++;
            }
        }
        if (contador==0){
            System.out.println("Tristemente..., ninguno");
        }
    }

    public double promedioGeneral(){
        if (notas.isEmpty()){
            return 0.0;
        }
        double suma = 0;
        for (String nombre : notas.keySet()) {
            suma += calcularPromedio(nombre);
        }
        return suma/notas.size();
    }







}
