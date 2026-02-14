package ejemplos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejemplos {
    public void ej1(){
        int puntuacion = 0;
        puntuacion = 5;
        System.out.println("La puntuación es " + puntuacion);
        puntuacion = 10;
        System.out.println("La puntuación es " + puntuacion);
        puntuacion = 15;
        System.out.println("La puntuación final es " + puntuacion);
    }

    public void calculadoraAtributos(int op1, int op2){
        System.out.printf("""
                ----- RESULTADOS -----
                1. Suma: %d
                2. Resta: %d
                3. Multiplicación: %d
                4. División: %.2f             
                """,op1+op2,op1-op2,op1*op2,(double)op1/op2);

    }

    public void calculadoraBasico(){
        Scanner s = new Scanner(System.in);
        System.out.print("Indica el primer operador: ");
        int op1 = s.nextInt();
        s.nextLine();
        System.out.print("Indica el segundo operador: ");
        int op2 = s.nextInt();
        s.nextLine();
        System.out.printf("""
                ----- RESULTADOS -----
                1. Suma: %d
                2. Resta: %d
                3. Multiplicación: %d
                4. División: %.2f             
                """,op1+op2,op1-op2,op1*op2,(double)op1/op2);

    }

    public void calculadoraDescuento(){
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce el precio del producto: ");
        int precio = s.nextInt();
        System.out.print("Introduce el porcentaje de descuento: ");
        int porcentaje = s.nextInt();
        s.nextLine();
        System.out.printf("""
                Precio original: %.2f€
                Descuento (%d%%): %.2f€
                Precio final: %.2f€
                """
        ,(double)precio
        ,porcentaje,(double)precio/100*porcentaje
        ,precio-((double)precio/100*porcentaje));

    }

    public void calculadoraSalario(){
        try {
            Scanner s = new Scanner(System.in);
            System.out.print("Introduce el salario por hora: ");
            float salarioHora = s.nextFloat();
            System.out.print("Introduce horas trabajadas: ");
            int horasTrabajadas = s.nextInt();
            boolean permitidoExtras = horasTrabajadas > 40;
            int horasNormales = Math.min(horasTrabajadas, 40);
            int horasExtra = horasTrabajadas > 40 ? horasTrabajadas - 40 : 0;
            float salarioNormal = horasNormales * salarioHora;
            float salarioExtra = horasExtra * (salarioHora*2);
            System.out.printf("""
                Horas normales (máximo 40): %d
                Horas extra: %d
                ¿Se aplican horas extra? (>40 AND permitido): %b
                Salario por horas normales: %.2f€
                Salario por horas extra (al doble): %.2f€
                Salario total: %.2f€
                """
                    ,horasNormales
                    ,horasExtra
                    ,permitidoExtras
                    ,salarioNormal
                    ,salarioExtra
                    ,salarioNormal+salarioExtra);
        }catch (InputMismatchException e){
            System.out.println("Entrada de datos incorrecta.");
        }catch (Exception e){
            System.out.println("Error no controlado, comunicar al administrador.");
        }

    }


}
