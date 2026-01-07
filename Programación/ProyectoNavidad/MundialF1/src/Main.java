import controller.CampeonatoController;
import model.Campeonato;
import model.Carrera;
import model.Coche;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int cantidadCoches = 0, cantidadCarreras = 0;
        ArrayList<Coche> coches = new ArrayList<>();
        ArrayList<Carrera> carreras = new ArrayList<>();

        System.out.print("¿Cuantos coches participan en el Campeonato? ");
        while (cantidadCoches<1||cantidadCoches>20){
            cantidadCoches = s.nextInt();
            if (cantidadCoches<0||cantidadCoches>20){
                System.out.println("Cantidad de coches erronea, introduce un numero del 1 al 20:");
            }
        }
        s.nextLine();
        for (int i = 0; i < cantidadCoches; i++) {
            String nombre = "";
            System.out.print("Introduce el nombre del piloto numero "+(i+1)+": ");
            nombre = s.nextLine();
            coches.add(new Coche(nombre));
        }

        System.out.print("Cuantas carreras hay? ");
        while (cantidadCarreras<1||cantidadCarreras>10){
            cantidadCarreras = s.nextInt();
            if (cantidadCarreras<0||cantidadCarreras>10){
                System.out.print("Cantidad de coches erronea, introduce un numero del 1 al 10:");
            }
        }
        s.nextLine();
        for (int i = 0; i < cantidadCarreras; i++) {
            String nombre = "";
            int kms = 0;
            System.out.print("Introduce el nombre de la carrera "+(i+1)+": ");
            nombre = s.nextLine();
            System.out.print("Introduce los kms que tiene: ");
            while (kms<21||kms>9999){
                kms = s.nextInt();

                if (kms<21||kms>9999){
                    System.out.println("Kms del circuito erroneos, introduce un numero entre 21 y 9999 ");
                }
            }
            s.nextLine();
            carreras.add(new Carrera(nombre,kms,coches));
        }

        System.out.println("¿Como se llama el campeonato? ");
        String nombreCampeonato = s.nextLine();

        Campeonato campeonato = new Campeonato(carreras,nombreCampeonato);

        CampeonatoController controller = new CampeonatoController(campeonato);

        controller.simularCampeonato();

    }

}
