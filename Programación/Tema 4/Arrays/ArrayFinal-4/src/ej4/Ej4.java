package ej4;

import java.util.*;

public class Ej4 {
    Scanner s = new Scanner(System.in);
    public void ej4(){

        String[] bombo1 = new String[5];
        String[] bombo2 = new String[5];

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
        System.out.println("Primer bombo: ");
        for (String item : bombo1) {
            System.out.print(item+"\t");
        }
        System.out.println("\nSegundo bombo: ");
        for (String item : bombo2) {
            System.out.print(item +"\t");
        }

        //Los convierto a listas, tengo que investigar sobre estas, pero se pueden usar funcionalidades chulas
        List<String> lista1 = Arrays.asList(bombo1);
        List<String> lista2 = Arrays.asList(bombo2);

        //Funcionalidades de collections, por ejemplo shuffle, esto hace el ejercicio gratis
        Collections.shuffle(lista1);
        Collections.shuffle(lista2);

        System.out.println("\nEnfrentamientos de fase de grupos: ");
        for (int i = 0; i < lista1.size(); i++) {
            System.out.println(lista1.get(i)+" vs "+lista2.get(i));
        }

    }
}
