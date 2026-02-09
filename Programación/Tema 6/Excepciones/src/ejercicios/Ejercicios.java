package ejercicios;

import exceptions.EdadInvalidaException;
import exceptions.OperacionInvalidaException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicios {

    Scanner s = new Scanner(System.in);

    public void ej1(){
        System.out.print("Introduce el primer número: ");
        int sum1 = s.nextInt();
        s.nextLine();
        System.out.print("Introduce el segundo número: ");
        int sum2 = s.nextInt();
        s.nextLine();
        try {
            int validacion = sum1 / sum2;
            double division = (double) sum1 / sum2;
            System.out.println("El resultado es: " + division);
        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir por 0");
        }
    }

    public void ej2(){
        int[] numeros = {1, 2, 3, 4, 5};
        System.out.print("Introduce el numero del array que quieres ver (0 al 4): ");
        int posicion = s.nextInt();
        s.nextLine();
        try {
            System.out.println("El numero guardado en la posición " + posicion + " es " + numeros[posicion]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: la posición seleccionada esta fuera de los limites del array.");
        }

    }

    public void ej3(){
        System.out.print("Introduce un número: ");
        String numero = s.nextLine();
        try {
            System.out.println("El numero es " + Integer.parseInt(numero));
        } catch (NumberFormatException e) {
            System.out.println("Error: Eso no es un número válido. Inténtalo de nuevo.");
        }

    }

    public void ej4(){
        System.out.print("Introduce la edad que tienes: ");
        try {
            int edad = s.nextInt();
            s.nextLine();
            if (edad<0) throw new EdadInvalidaException("Error: La edad no puede ser inferior a 0");
            if (edad>120) throw new EdadInvalidaException("Error: La edad no puede ser superior a 120");
            System.out.println("Edad valida: " + edad);
        } catch (EdadInvalidaException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("No has introducido un numero valido");
        }
    }

    public void ej5(){
        int op1 = 0, op2 = 0;
        try {
            System.out.print("Introduce el primer operando: ");
            op1 = s.nextInt();
            s.nextLine();
            System.out.print("Introduce el segundo operando: ");
            op2 = s.nextInt();
            s.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Input no valido.");
            return;
        }
        try {
            System.out.println("Introduce la operación: (+, -, *, /): ");
            String operacion = s.nextLine();
            if (!operacion.equals("+") && !operacion.equals("-") &&
                    !operacion.equals("*") && !operacion.equals("/")) {
                throw new OperacionInvalidaException("El operador no es correcto.");
            }

            switch (operacion){
                case "+" -> System.out.println("El resultado es: " + (op1 + op2));
                case "-" -> System.out.println("El resultado es: " + (op1 - op2));
                case "*" -> System.out.println("El resultado es: " + (op1 * op2));
                case "/" -> {
                    int comprobacion = op1 / op2;
                    System.out.println("El resultado es: " + ((double) op1 / op2));
                }
            }
        } catch (OperacionInvalidaException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por 0.");
        }


    }
}
