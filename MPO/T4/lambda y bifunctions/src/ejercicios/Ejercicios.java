package ejercicios;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.*;

public class Ejercicios {

    public void ej1(){
        int[] lista = {1, 2, 3, 4, 5};
        Function<Integer,Integer> cuadrado = (Integer numero) -> numero*numero;
        /*
        Forma clasica con foreach
        for (int numero : lista) {
            System.out.println("Numero que estamos potenciando al cuadrado: " + numero);
            System.out.println("Resultado: " + cuadrado.apply(numero));
        }*/

        // Foreach avanzado en funciones lambda, se le da el nombre del integer a iterar,
        // el boxed convierte los ints en Integers, al solo tener una linea, no hacen falta llaves
        Arrays.stream(lista).boxed().forEach(num ->
                System.out.println("Numero: " + num + "\nResultado: " + cuadrado.apply(num))
        );
    }

    public void ej2(){
        int[] lista = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Predicate<Integer> testPar = (numero) -> numero%2==0;
        Arrays.stream(lista).boxed().filter(testPar)
                .forEach(num -> System.out.println(num + " es par."));
    }

    public void ej3(){
        int num1 = 6, num2 = 2;
        BiFunction<Integer, Integer, Integer> suma = (sum1, sum2) -> sum1 + sum2;
        System.out.println("Resultado de la suma: " + suma.apply(num1,num2));
        BiFunction<Integer, Integer, Integer> resta = (sum1, sum2) -> sum1 - sum2;
        System.out.println("Resultado de la resta: " + resta.apply(num1,num2));
        BiFunction<Integer, Integer, Integer> multiplicacion = (sum1, sum2) -> sum1 * sum2;
        System.out.println("Resultado de la multiplicación: " + multiplicacion.apply(num1,num2));
        BiFunction<Integer, Integer, Integer> division = (sum1, sum2) -> sum1 / sum2;
        System.out.println("Resultado de la división: " + division.apply(num1,num2));
    }

    public void ej4(){
        HashMap<String, String> paresPalabras = new HashMap<>();
        paresPalabras.put("casa","perro");
        paresPalabras.put("avion","jauria");
        paresPalabras.put("apartamento","partidos");
        paresPalabras.put("madre","padre");

        BiPredicate<String, String> comprobarLongitud = (str1, str2) -> str1.length()==str2.length();
        paresPalabras.forEach((palabra1, palabra2) -> System.out.println("¿Tienen " + palabra1 + " y " + palabra2 + " la misma longitud? " + comprobarLongitud.test(palabra1, palabra2)));
    }

    public void ej5(){
        HashMap<String, Integer> estudiantes = new HashMap<>();
        estudiantes.put("Bruno", 30);
        estudiantes.put("Dioni", 34);
        estudiantes.put("Daniel", 35);
        estudiantes.put("Nathan", 19);
        BiConsumer<String, Integer> mostrarDatos = (nombre, edad) -> System.out.println("Nombre: [" + nombre + "], Edad: [" + edad + "]");
        estudiantes.forEach(mostrarDatos::accept);
    }
}
