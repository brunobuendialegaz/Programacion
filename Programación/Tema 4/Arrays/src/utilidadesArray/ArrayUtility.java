package utilidadesArray;

import java.util.Scanner;

public class ArrayUtility {
    Scanner s = new Scanner(System.in);

    /*public void recorrerArrayString(int bucles, String[] array) {
        for (int i = 0; i < bucles; i++) {
            System.out.println(array[i]);
        }
    }*/

    /*public void recorrerArrayInt(int bucles, int[] array) {
        for (int i = 0; i < bucles; i++) {
            System.out.println("Posición "+i+": "+array[i]);
        }
    }*/

    public void recorrerArrayString(int bucles, String[] array) {
        System.out.printf("[");
        for (int i = 0; i < bucles; i++) {
            if(i==bucles-1){
                System.out.printf("%s]%n",array[i]);
                break;
            }
            System.out.printf("%s; ",array[i]);
        }
    }

    public void recorrerArrayDouble(int bucles, double[] array) {
        System.out.printf("[");
        for (int i = 0; i < bucles; i++) {
            if(i==bucles-1){
                System.out.printf("%.2f]%n",array[i]);
                break;
            }
            System.out.printf("%.2f; ",array[i]);
        }
    }

    public void recorrerArrayInt(int bucles, int[] array) {
        System.out.print("Array: ");
        System.out.printf("[");
        for (int i = 0; i < bucles; i++) {
            if(i==bucles-1){
                System.out.printf("%d]%n",array[i]);
                break;
            }
            System.out.printf("%d; ",array[i]);
        }
    }

    public void arrayIntRandom(int tamanio,int[] array, int rango){
        for (int i = 0; i < tamanio; i++){
            array[i] = (int) (Math.random()*rango);
        }
    }

    public void arrayDoubleRandom(int tamanio,double[] array, int rango){
        for (int i = 0; i < tamanio; i++){
            array[i] = Math.random()*rango;
        }
    }

    public void arrayStringScanner(int tamanio,String[] array){
        for (int i = 0; i < tamanio ; i++){
            System.out.printf("%nIntroduce el nombre de la posición %d: ",i);
            array[i] = s.nextLine();
        }
        System.out.println("El array esta lleno...");
    }

}
