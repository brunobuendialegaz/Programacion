package Metodos;

import java.util.Scanner;

public class Metodo {
    public void ejercicio1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el primer número");
        int op1 = scanner.nextInt();
        System.out.println("Introduce el segundo número");
        int op2 = scanner.nextInt();
        int suma = op1+op2;
        int resta = op1-op2;
        int multiplicacion = op1*op2;
        int division = op1/op2;
        int resto = op1%op2;
        System.out.printf("Suma: %d\n" +
                        "Resta: %d\n" +
                        "Multiplicación: %d\n" +
                        "División: %d\n" +
                        "Resto: %d\n",
                suma,
                resta,
                multiplicacion,
                division,
                resto);
        scanner.close();
    }




}
