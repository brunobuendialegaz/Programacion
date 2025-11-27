package Ejercicios;

import Utilidades.Utilidades;

public class Ejercicios {

    Utilidades u = new Utilidades();

    public void ej1(){
        u.validarContrasena("camion0");
        u.validarContrasena("camioneta");
        u.validarContrasena("Camioneta1");
    }
    public void ej2(){
        int[] numeros = {1, 2, 3, 4, 5};
        System.out.println(u.buscarNumero(numeros,3));
        System.out.println(u.buscarNumero(numeros,6));
        System.out.println(u.buscarNumero(numeros,1));
    }
    public void ej3(){
        int[] numeros = {8, 5, 9, 6, 6, 3, 8, 7, 9, 2, 4, 1, 0};
        u.mostrarPares(numeros);
    }
    public void ej4(){
        double[] notas = {7.5, 8.6, -8, -12, 19, 9, 3};
        System.out.printf("Nota media: %.2f",u.calcularPromedio(notas));
    }
    public void ej5(){
        System.out.println("¿Has podido acceder?: "+u.intentarLogin("Bruno", "Pepito"));
    }

}
