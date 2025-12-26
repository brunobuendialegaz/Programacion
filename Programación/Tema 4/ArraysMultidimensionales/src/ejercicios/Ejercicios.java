package ejercicios;

import arrayUtility.ArrayUtility;

import java.util.Scanner;

public class Ejercicios {

    ArrayUtility a = new ArrayUtility();
    Scanner s = new Scanner(System.in);

    public void ej1(){
        int[][] numeros = new int[3][3];
        a.crearArrayInt(numeros,10);
        a.recorrerArrayBidimensional(numeros);
    }

    public void ej2(){
        int[][] numeros = new int[2][4];
        a.rellenarArrayBidScanner(numeros);
        a.recorrerArrayBidimensional(numeros);
    }

    public void ej3(){
        int[][] numeros = new int[3][5];
        int total = 0;
        a.crearArrayInt(numeros,20);
        a.recorrerArrayBidimensional(numeros);
        System.out.println("El total de la suma del array es: "+a.sumaArrayBidimensional(numeros,total));
    }

    public void ej4(){
        int[][] numeros = new int[3][5];
        int numObjetivo;
        a.crearArrayInt(numeros,100);
        a.recorrerArrayBidimensional(numeros);
        System.out.print("Introduce el numero a encontrar en la matriz: ");
        numObjetivo = s.nextInt();
        System.out.println(a.buscarEnArrayBid(numeros,numObjetivo));
    }

    public void ej5(){
        double[][] numeros = new double[4][3];
        a.crearArrayDouble(numeros,10);
        a.recorrerArrayBidDouble(numeros);
        a.mediaFila(numeros);
    }

    public void ej6(){
        int[][] numeros = new int[3][4];
        a.crearArrayInt(numeros, 50);
        a.recorrerArrayBidimensional(numeros);
        a.numAltoColumna(numeros);
    }

    public void ej7(){
        int[][] numerosOriginal = new int[3][4];
        a.crearArrayInt(numerosOriginal, 20);
        System.out.println("Array original: ");
        a.recorrerArrayBidimensional(numerosOriginal);
        System.out.println("\nArray transpuesto: ");
        a.transponerMatriz(numerosOriginal);
    }
    
    public void ej8(){
        int[][] numeros = new int[4][5];
        a.crearArrayInt(numeros, 40);
        a.recorrerArrayBidimensional(numeros);
        a.contarParImpar(numeros);
    }

    public void ej9(){
        int[][] tablas = new int[10][10];
        for (int i = 0; i < tablas.length; i++) {
            for (int j = 0; j < tablas[i].length; j++) {
                System.out.print((i+1)*(j+1)+" ");
            }
            System.out.println();
        }

    }

    public void ej10(){
        System.out.print("¿Cuantos estudiantes hay? ");
        int estudiantes = s.nextInt();
        System.out.print("¿Cuantas asignaturas hay? ");
        int asignaturas = s.nextInt();
        double[][] notas = new double[estudiantes][asignaturas];
        // pedir las notas
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                System.out.printf("Introduce nota de estudiante %d, asignatura %d: ",i+1,j+1);
                notas[i][j] = s.nextInt();
            }
        }
        // mostrar todas las notas
        for(int i = 0; i < notas.length; i++){
            if (i==0){
                System.out.printf(" --- TABLA DE NOTAS --- %n");
                System.out.printf("        ");
                for (int j = 0; j < notas[i].length; j++) {
                    System.out.printf("asig%d  ",j+1);
                }
            }
                System.out.printf("\nest %d: ",i+1);
            for (int j = 0; j < notas[i].length; j++) {
                System.out.printf("  %.1f  ",notas[i][j]);
            }
        }
        // promedios estudiante
        System.out.printf("%n%n--- PROMEDIOS POR ESTUDIANTE ---%n");
        for (int i = 0; i < notas.length; i++) {
            double promedioEstudiante = 0;
            System.out.printf("Estudiante %d: ",i+1);
            for (int j = 0; j < notas[i].length; j++) {
                promedioEstudiante += notas[i][j];
            }
            System.out.println(promedioEstudiante/notas[i].length);
        }
        // promedios asignaturas
        System.out.printf("%n--- PROMEDIOS POR ASIGNATURA ---%n");
        for (int i = 0; i < notas[0].length; i++) {
            double promedioNota = 0;
            System.out.printf("Asignatura %d: ",i+1);
            for (int j = 0; j < notas.length; j++) {
                promedioNota += notas[j][i];
            }
            System.out.println(promedioNota/notas.length);
        }
        // nota mas alta
        double notaAlta = 0;
        int estAlta = 0, asigAlta = 0;
        for(int i = 0; i < notas.length; i++){
            for (int j = 0; j < notas[i].length; j++) {
                if (notaAlta<notas[i][j]){
                    notaAlta = notas[i][j];
                    estAlta = i+1;
                    asigAlta = j+1;
                    System.out.printf("""
                %n--- NOTA MÁS ALTA ---
                La nota más alta es %.1f (Estudiante %d, Asignatura %d)
                """,notaAlta,estAlta,asigAlta);
                } else if (notaAlta==notas[i][j]) {
                    notaAlta = notas[i][j];
                    estAlta = i+1;
                    asigAlta = j+1;
                    System.out.printf("""
                Nota empatada más alta es %.1f (Estudiante %d, Asignatura %d)
                """,notaAlta,estAlta,asigAlta);
                }
            }
        }

    }
}
