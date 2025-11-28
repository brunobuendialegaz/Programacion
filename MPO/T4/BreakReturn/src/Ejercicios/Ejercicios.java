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
    public void ej6(){
        String[] tareas = {"Hacer la compra","Comer patatas fritas", "Programar URGENTE", "Verse la clase de olga"};
        System.out.println(u.procesarTareas(tareas));
    }
    public void ej7(){
        u.generarFibonacci(10000);
    }
    public void ej8(){
        int[] edades = {-80,16,131,8,30,34,180,-5,-199};
        u.mostrarEdadesValidas(edades);
    }
    public void ej9(){
        String texto = "Ahora mismo estoy un poco cansado de este ejercicio";
        String[] palabrasProhibidas = {"Ahora", "solo", "programar"};
        System.out.println("El texto tiene "+u.contarVocales(texto)+" vocales");
        System.out.println("¿El texto contiene alguna palabra prohibida? "+u.contienePalabraProhibida(texto, palabrasProhibidas));
        System.out.println("¿Hay alguna palabra tan larga como el limite? "+u.primeraPalabraLarga(texto, 8));
    }

}
