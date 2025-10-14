package ejercicio9;

import java.util.Scanner;

public class ScanerInfoArticulo {
    String nombreArt;
    int precio;
    String codigo;
    boolean disponible;
    Scanner entrada = new Scanner(System.in);

    public void añadir(){
        System.out.println("Introduce los datos del artículo.");
        System.out.println("Nombre:");
        nombreArt = entrada.nextLine();
        System.out.println("Precio:");
        precio = entrada.nextInt();
        System.out.println("Codigo:");
        codigo = entrada.nextLine();
        System.out.println("Disponibilidad: (true or false only)");
        disponible = entrada.nextBoolean();
    }
    public void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    public void mostrar(){
        System.out.println("INFORMACIÓN DEL ARTÍCULO:");
        System.out.println("--------------------------");
        System.out.println("Nombre: "+nombreArt);
        System.out.println("Precio: "+precio+" €");
        System.out.println("Código de artículo: "+codigo);
        System.out.println("Disponibilidad: "+disponible);
    }
}
