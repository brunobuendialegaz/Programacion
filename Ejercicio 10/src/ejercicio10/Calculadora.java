package ejercicio10;

import java.util.Scanner;

public class Calculadora {
    Scanner entrada = new Scanner(System.in);
    int celsius;

    public void introducirCelsius(){
        System.out.println("Introduce la temperatura en grados Celsius: ");
        celsius = entrada.nextInt();
    }

    public void salidaFahrenheit(){
        int fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println("La temperatura en grados Fahrenheit es: "+fahrenheit);
    }

    public void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
