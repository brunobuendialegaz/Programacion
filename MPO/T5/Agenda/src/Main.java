import controller.Agenda;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion;
        do {
            System.out.println("--- MENÚ AGENDA ---");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Borrar contacto");
            System.out.println("4. Listar contactos");
            System.out.println("5. Salir");
            opcion = s.nextInt();
            switch (opcion){
                case 1 -> {
                    agenda.agregarContacto();
                }
                case 2 -> {
                    System.out.println("Introduce algún dato del contacto a buscar (keysensitive): ");
                    String buscador = s.next();
                    agenda.buscarContacto(buscador);
                }
                case 3 -> {
                    System.out.println("Introduce algún dato del contacto a borrar (keysensitive): ");
                    String buscador = s.next();
                    agenda.borrarContacto(buscador);
                }
                case 4 -> {
                    agenda.listaContactos();
                }
                case 5 -> {
                    System.out.println("Saliendo del programa...");
                }
            }
        }while (opcion!=5);






    }

}
