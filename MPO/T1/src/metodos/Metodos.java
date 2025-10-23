package metodos;

import java.util.Scanner;


public class Metodos {
    Scanner s = new Scanner(System.in);
    public void ejercicioMpo1(){

        //recogida de datos
        System.out.println("Número de bebidas (entre 0 y 20):");
        int bebidasCompradas = s.nextInt();
        System.out.println("Número de bocadillos (entre 0 y 20):");
        int bocadillosComprados = s.nextInt();
        System.out.println("Precio de cada bebida (entre 0,00 y 3,00):");
        double valorBocadillos = s.nextDouble();
        System.out.println("Precio de cada bocadillo (entre 0,00 y 5,00):");
        double valorBebidas = s.nextDouble();
        System.out.println("Número de alumnos (entre 1 y 10): 5");
        int alumnos = s.nextInt();

        //calculos matematicos de costes
        double totalBebidas = bebidasCompradas*valorBebidas;
        double totalBocadillos = bocadillosComprados*valorBocadillos;
        double totalCompra = totalBebidas+totalBocadillos;
        double precioAlumno = totalCompra/alumnos;

        //printf para ahorrar lineas y codgo, asi se salta de linea "" +
        System.out.printf("Subtotal bebidas: %.2f€%n" +
                "Subtotal bocadillos: %.2f€%n" +
                "Total de la compra: %.2f€%n" +
                "Cantidad por alumno: %.2f€%n",
                totalBebidas,
                totalBocadillos,
                totalCompra,
                precioAlumno
        );

    }
    public void ejercicioMpo2(){
        System.out.println("Valor de la compra (entre 0.00 y 500.00):");
        double valorBruto = s.nextDouble();
        System.out.println("IVA (entre 0 y 25%):");
        int iva = s.nextInt();
        double ivaAplicado = valorBruto*((double)iva/100);
        double valorNeto = valorBruto+ivaAplicado;

        System.out.printf("Compra: %.2f%n€" +
                "Iva: %.2f€",
                valorNeto,
                ivaAplicado);
    }
    public void ejercicioMpo3(){
        System.out.println("introduce un numero de 5 dígitos");
        int numero = s.nextInt();
        int decenasDeMil =numero/10000;
        int unidadesDeMil =numero/1000-(numero/10000*10);
        int centenas =numero/100-(numero/1000*10);
        int decenas =numero/10-(numero/100*10);
        int unidades =numero-(numero/10*10);

        System.out.printf("Decenas de mil: %d%n" +
                "Unidades de mil: %d%n" +
                "Centenas: %d%n" +
                "Decenas: %d%n" +
                "Unidades: %d%n" +
                "Numero introducido: %d",
                decenasDeMil,
                unidadesDeMil,
                centenas,
                decenas,
                unidades,
                numero
                );

    }
    public void ejercicioMpo35(){
        System.out.println("introduce un numero de 5 dígitos");
        int numero = s.nextInt();
        int decenasDeMil =numero/10000;
        int unidadesDeMil =numero/1000%10;
        int centenas =numero/100%10;
        int decenas =numero/10%10;
        int unidades =numero%10;

        System.out.printf("Decenas de mil: %d%n" +
                        "Unidades de mil: %d%n" +
                        "Centenas: %d%n" +
                        "Decenas: %d%n" +
                        "Unidades: %d%n" +
                        "Numero introducido: %d",
                decenasDeMil,
                unidadesDeMil,
                centenas,
                decenas,
                unidades,
                numero
        );

    }








}
