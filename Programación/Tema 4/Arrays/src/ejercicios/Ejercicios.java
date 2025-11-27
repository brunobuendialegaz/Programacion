package ejercicios;

import utilidadesArray.ArrayUtility;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicios {
    ArrayUtility a = new ArrayUtility();
    Scanner s = new Scanner(System.in);

    public void ej1() {
        String[] frutas = {"Manzana", "Plátano", "Naranja", "Fresa", "Uva"};
        System.out.println("Frutas en el array:");
        a.recorrerArrayString(5,frutas);
    }

    public void ej2(){
        int[] numeros = new int[6];
        a.arrayIntRandom(6,numeros,50);
        System.out.println("Los numeros del array son:");
        a.recorrerArrayInt(6,numeros);
    }

    public void ej3(){
        int tamanioArray = 5;
        String[] nombres = new String[tamanioArray];
        a.arrayStringScanner(tamanioArray,nombres);
        System.out.println("Nombres introducidos: ");
        a.recorrerArrayString(tamanioArray,nombres);
    }

    public void ej4(){
        int[] numeros = new int[7];
        a.arrayIntRandom(7,numeros,10);
        System.out.print("Introduce un numero: ");
        int numeroIntroducido = s.nextInt();
        a.recorrerArrayInt(7,numeros);
        boolean estaArray = false;
        for (int i = 0; i < 7; i++){
            if (numeroIntroducido==numeros[i]){
                System.out.println("Tu numero esta en la posición: "+i+".");
                estaArray = true;
            }
        }
        if (!estaArray){
            System.out.println("El número no esta en el array.");
        }
    }

    public void ej5(){
        int[] numeros = new int[10];
        a.arrayIntRandom(10,numeros, 101);
        int contador = 0;
        for(int i = 0; i < 7; i++){
            if (numeros[i]<50){
                contador++;
            }
        }
        a.recorrerArrayInt(10,numeros);
        System.out.println("Números mayores a 50: "+contador);
    }

    public void ej6(){
        double[] numeros = new double[10];
        a.arrayDoubleRandom(10,numeros,10);
        a.recorrerArrayDouble(10,numeros);
        double total = 0.0;
        for (int i = 0; i < 10; i++){
            total += numeros[i];
        }
        System.out.printf("suma total: %.2f%n",total);
        System.out.printf("Promedio: %.2f%n",total/10);
    }

    public void ej7(){
        int[] numeros = new int[7];
        a.arrayIntRandom(7,numeros,50);
        int numMin = 25, numMax = 25;
        for(int i = 0; i < 7; i++){
            if (numeros[i]<numMin){
                numMin = numeros[i];
                continue;
            }
            if (numeros[i]>numMax) {
                numMax = numeros[i];
            }
        }
        a.recorrerArrayInt(7,numeros);
        System.out.println("Número máximo: "+numMax+".\nNúmero mínimo: "+numMin+".");
    }

    public void ej8(){
        String[] animales = {"gato", "perro", "gato", "pájaro", "gato", "pez", "perro", "gato", "conejo", "perro"};
        a.recorrerArrayString(10,animales);
        System.out.print("introduce una palabra: ");
        String palabra = s.nextLine().toLowerCase();
        int contador = 0;
        for (int i = 0; i < 10; i++){
            if(palabra.equals(animales[i])){
                contador++;
            }
        }
        System.out.printf("La palabra aparece %d veces",contador);
    }

    public void ej9(){
        int[] numerosOriginal = new int[10];
        a.arrayIntRandom(numerosOriginal.length,numerosOriginal,31);
        a.recorrerArrayInt(numerosOriginal.length,numerosOriginal);
        int[] numerosInverso = new int[10];
        int contador = 0;
        for (int i = 9; i >= 0; i--){
            numerosInverso[i] = numerosOriginal[contador];
            contador++;
        }
        System.out.println("Array inverso: "+Arrays.toString(numerosInverso));
    }

    public void ej10(){
        System.out.print("¿Cuántos estudiantes hay?: ");
        int estudiantes = s.nextInt();
        double[] notas = new double[estudiantes];
        int contador = 0;

        while (contador<estudiantes){
            System.out.print("Introduce la nota del estudiante "+(contador+1)+": ");
            notas[contador] = s.nextDouble();
            contador++;
        }

        System.out.println("\n--- REPORTE DE CALIFICACIONES ---");

        System.out.println("Calificaciones: "+Arrays.toString(notas));

        int aprobados = 0;
        double total = 0, notaAlta = 5, notaBaja = 5;
        for (int i = 0; i < notas.length; i++){
            total += notas[i];
            if (notas[i]<notaBaja){
                notaBaja=notas[i];
            }
            if (notas[i]>notaAlta){
                notaAlta=notas[i];
            }
            if (notas[i]>=5){
                aprobados++;
            }
        }
        System.out.printf("""
                Promedio de la clase: %.1f
                Estudiantes aprobados: %d
                Nota más alta: %.1f
                Nota más baja: %.1f
                """,
                (total/estudiantes),
                aprobados,
                notaAlta,
                notaBaja);
    }
}
