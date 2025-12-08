package ej4;

import java.util.*;

public class Ej4 {
    Scanner s = new Scanner(System.in);
    public void ej4(){

        String[] bombo1 = new String[5];
        String[] bombo2 = new String[5];
        int[] random1 = new int[]{-1,-1,-1,-1,-1};
        int[] random2 = new int[]{-1,-1,-1,-1,-1};

        //Rellenamos los bombos
        System.out.println("Introduce las selecciones del primer bombo: ");
        for (int i = 0; i < bombo1.length; i++) {
            System.out.print("Selección "+(i+1)+": ");
            bombo1[i] = s.nextLine();
        }
        System.out.println("Introduce las selecciones del segundo bombo: ");
        for (int i = 0; i < bombo2.length; i++) {
            System.out.print("Selección "+(i+1)+": ");
            bombo2[i] = s.nextLine();
        }

        //Recorremos los bombos con foreach
        mostrarBombo(bombo1);
        mostrarBombo(bombo2);

        /*Los convierto a listas, tengo que investigar sobre estas, pero se pueden usar funcionalidades chulas
        List<String> lista1 = Arrays.asList(bombo1);
        List<String> lista2 = Arrays.asList(bombo2);

        //Funcionalidades de collections, por ejemplo shuffle, esto hace el ejercicio gratis
        Collections.shuffle(lista1);
        Collections.shuffle(lista2);

        System.out.println("\nEnfrentamientos de fase de grupos: ");
        for (int i = 0; i < lista1.size(); i++) {
            System.out.println(lista1.get(i)+" vs "+lista2.get(i));
        }*/

        for (int i = 0; i < random1.length; i++) {
            int temporal;
            do {
                temporal = (int)(Math.random()*5);
            }while (checkNoRepetir(random1, temporal));
            random1[i] = temporal;
        }
        //mostrarArray(random1);

        for (int i = 0; i < random2.length; i++) {
            int temporal;
            do {
                temporal = (int)(Math.random()*5);
            }while (checkNoRepetir(random2, temporal));
            random2[i] = temporal;
        }
        //mostrarArray(random2);
        System.out.println("------- ¡Enfrentamientos! -------");
        for (int i = 0; i < bombo1.length; i++) {
            System.out.println("Partido "+(i+1)+": "+bombo1[random1[i]]+" vs "+bombo2[random2[i]]);
        }

    }

    private boolean checkNoRepetir(int[] array, int numero){
        for (int i = 0; i < array.length; i++) {
            if (numero==array[i]){
                return true;
            }
        }
        return false;
    }

    private void mostrarArray(int[] array){
        System.out.println("\nArray: ");
        for (int item : array) {
            System.out.print(item+"\t");
        }
    }

    private void mostrarBombo(String[] array){
        System.out.println("\nBombo: ");
        for (String item : array) {
            System.out.println(item);
        }
    }
}
