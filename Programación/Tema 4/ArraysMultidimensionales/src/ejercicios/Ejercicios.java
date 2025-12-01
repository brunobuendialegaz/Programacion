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
}
