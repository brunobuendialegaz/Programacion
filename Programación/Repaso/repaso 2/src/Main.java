import model.Ingredientes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Ingredientes> ingredientes = new ArrayList<>();
        int opcion;
        int contador = 0;

        try {
            do {
                System.out.printf("""
                    --- Configura tu pizza ---
                    ¿Que ingrediente quieres añadir?
                    0. Salir
                    1. Tomate
                    2. Queso
                    3. Bacon
                    4. Piña
                    5. Pepperoni
                    6. Jamón
                  """);
                opcion = s.nextInt();
                switch (opcion){
                    case 0 -> {
                        System.out.println("Saliendo");
                        System.out.println("La pizza actualmente tiene " + contador + " ingredientes.");
                        System.out.print("ingredientes: ");
                        mostrarDatosPizza(ingredientes);
                        System.out.println("Valor actual de la pizza: " + calcularPrecioAcumulado(ingredientes) + "€");
                    }
                    case 1 -> ingredientes.add(Ingredientes.TOMATE);
                    case 2 -> ingredientes.add(Ingredientes.QUESO);
                    case 3 -> ingredientes.add(Ingredientes.BACON);
                    case 4 -> ingredientes.add(Ingredientes.PINIA);
                    case 5 -> ingredientes.add(Ingredientes.PEPPERONI);
                    case 6 -> ingredientes.add(Ingredientes.JAMON);
                    default -> System.out.println("Ingrediente no encontrado.");
                }
                if (opcion>0&&opcion<=6){
                    contador++;
                    System.out.println("La pizza actualmente tiene " + contador + " ingredientes.");
                    System.out.print("ingredientes: ");
                    mostrarDatosPizza(ingredientes);
                    System.out.println("Valor actual de la pizza: " + calcularPrecioAcumulado(ingredientes) + "€");
                }

            } while (opcion!=0&&contador<5);
        } catch (InputMismatchException e) {
            System.out.println("Input de teclado incorrecto.");
        } catch (Exception e) {
            System.out.println("Error inesperado, avisar al administrador.");
        }
    }

    public static void mostrarDatosPizza(List<Ingredientes> pizza){
        for (int i = 0; i < pizza.size(); i++) {
            System.out.print(pizza.get(i).getNombre().toLowerCase());
            if (pizza.size()>1 && i < pizza.size()-1){
                System.out.print(", ");
            }
        }
        System.out.println(".");
    }

    public static double calcularPrecioAcumulado(List<Ingredientes> pizza){
        /*double precioAcumulado = 0;
        return pizza.forEach((ingredientes -> precioAcumulado += ingredientes.getPrecio()));
        for (Ingredientes ingredientes : pizza) {
            precioAcumulado += ingredientes.getPrecio();
        }
        return precioAcumulado;*/
        return pizza.stream().mapToDouble(Ingredientes::getPrecio).sum();
    }


}
