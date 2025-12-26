package ej3;

import java.util.Scanner;

public class Ej3 {
    Scanner s = new Scanner(System.in);

    public void ej3(){
        double[] notas = new double[10];

        //Pedimos las notas
        System.out.println("Introduce las notas de los 10 alumnos (entre 0 y 10).");
        for (int i = 0; i < notas.length; i++) {
            do {
                System.out.print("Introduce la nota del alumno "+(i+1)+": ");
                notas[i] = s.nextDouble();
            }while (notas[i]<0||notas[i]>10);
        }

        System.out.println("Notas del exámen:");
        for (int i = 0; i < notas.length; i++) {
            System.out.printf("%.2f\t",notas[i]);
        }

        //Media de la clase
        System.out.print("\nNota media de la clase: ");
        double notaTotal = 0;
        for (int i = 0; i < notas.length; i++) {
            notaTotal += notas[i];
        }
        System.out.println(notaTotal/notas.length);

        //Nota baja o alta
        double notaBaja = 5, notaAlta = 5;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i]<notaBaja){
                notaBaja = notas[i];
            }
            if (notas[i]>notaAlta){
                notaAlta = notas[i];
            }
        }
        System.out.printf("""
                Nota mas baja: %.2f.
                Nota mas alta: %.2f
                """,notaBaja, notaAlta);

        //Alumnos aprobados/suspensos
        int aprobados = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i]>=5){
                aprobados++;
            }
        }
        System.out.printf("""
                Alumnos aprobados: %d.
                Alumnos suspendidos: %d.
                """,aprobados,notas.length-aprobados);


    }

}
