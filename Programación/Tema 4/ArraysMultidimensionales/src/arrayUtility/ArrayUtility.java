package arrayUtility;

import java.util.Scanner;

public class ArrayUtility {

    Scanner s = new Scanner(System.in);

    public void crearArrayInt( int[][] array, int rango){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random()*rango);
            }
        }
    }

    public void crearArrayDouble( double[][] array, int rango){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = Math.random()*rango;
            }
        }
    }

    public void recorrerArrayBidimensional(int[][] array){
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+" ");
                if (j==array[i].length-1){
                    System.out.print("\n");
                }
            }
        }
    }

    public void recorrerArrayBidDouble(double[][] array){
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%.2f ",array[i][j]);
                if (j==array[i].length-1){
                    System.out.print("\n");
                }
            }
        }
    }

    public void rellenarArrayBidScanner(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%nIntroduce el numero de la posición [%d][%d]: ",i,j);
                array[i][j] = s.nextInt();
            }
        }
    }

    public int sumaArrayBidimensional (int[][] array, int total){

        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++) {
                total += array[i][j];
                }
            }
        return total;
    }

    public String buscarEnArrayBid (int[][] array, int numObjetivo){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (numObjetivo==array[i][j]){
                    return "El número "+numObjetivo+" se encuentra en la posición ["+i+"]["+j+"]";
                }
            }
        }
        return "El número "+numObjetivo+" no se encuentra en la matriz";
    }

    public void mediaFila(double[][] array){
        double total = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                total+=array[i][j];
                if (j==array[i].length-1){
                    System.out.printf("La media de la fila %d es %.2f%n",i,total/array[i].length);
                    total=0;
                }
            }
        }
    }
        
    public void numAltoColumna(int[][] array){
        int numAlto;
        for (int i = 0; i < array[0].length; i++) {
            numAlto = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j][i]>numAlto) {
                    numAlto=array[j][i];
                }
            }
            System.out.printf("Numero alto de la columna %d: %d%n",i,numAlto);
        }
    }

    public void transponerMatriz(int[][] array){
        int[][] arrayTras = new int[array[0].length][array.length];
        for (int i = 0; i < arrayTras.length; i++) {
            for (int j = 0; j < arrayTras[i].length; j++) {
                arrayTras[i][j]=array[j][i];
            }
        }
        recorrerArrayBidimensional(arrayTras);
    }

        

}
