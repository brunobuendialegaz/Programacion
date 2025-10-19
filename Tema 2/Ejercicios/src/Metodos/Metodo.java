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
    public void ejercicio2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el primer número:");
        int op1 = scanner.nextInt();
        System.out.println("Introduce el segundo número:");
        int op2 = scanner.nextInt();
        boolean mayor = op1>op2;
        boolean menor = op1<op2;
        boolean igual = op1==op2;
        boolean diferente = op1!=op2;
        boolean mayorIgual = op1>=op2;
        boolean menorIgual = op1<=op2;
        System.out.printf("¿%d es mayor que %d?: %b%n" + //puedo concatenar texto con +, pero despues deben ir todas las variables seguidas con comas
                "¿%d es menor que %d?: %b%n"+
                "¿%d es igual a %d?: %b%n"+
                "¿%d es diferente a %d?: %b%n"+
                "¿%d es mayor o igual a %d? %b%n"+
                "¿%d es menor o igual a %d?: %b",
                op1,op2,mayor,
                op1,op2,menor,
                op1,op2,igual,
                op1,op2,diferente,
                op1,op2,mayorIgual,
                op1,op2,menorIgual);
        scanner.close();
    }
    public void ejercicio3(){

    }
}
