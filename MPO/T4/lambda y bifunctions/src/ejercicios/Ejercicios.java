package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Producto;

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

    public void ej6(){
        int[] numeros = {1,3,8,16,34};
        Function<Integer, Integer> suma10 = (num) -> num + 10;
        Function<Integer, Integer> duplicar = (num) -> num * 2;
        Function<Integer, String> darSolucion = (num) -> "Tras operar el resultado es " + num;
        Arrays.stream(numeros).boxed() // copia del array, pasamos a Integer
        .map(suma10.andThen(duplicar).andThen(darSolucion)) // en el map hacemos las operaciones
        .forEach(System.out::println); // le decimos que itere la lista y nos imprima el return del map (En este caso el String del mostrardatos)
    }

    public void ej7(){
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("raton", 19.99));
        productos.add(new Producto("grafica", 729.99));
        productos.add(new Producto("teclado", 29.99));
        productos.add(new Producto("monitor", 299.99));
        productos.add(new Producto("procesador", 599.99));

        BiFunction<Producto, Producto, Producto> mayorPrecio = (p1, p2) -> p1.getPrecio() > p2.getPrecio() ? p1 : p2;

        productos.stream().reduce((p1, p2) -> mayorPrecio.apply(p1, p2)) // pilla la lista completa y deja solo 1, con el criterio que tu marques en un BinaryOperator.
        .ifPresent(ganador -> System.out.println("El producto con mayor precio es " + ganador.getNombre() + " y su precio es " + ganador.getPrecio() + "€."));
    }

    public void ej8(){
        int[] numeros = {5,99,125,15,96};

        Predicate<Integer> mayor50 = (num) -> num > 50; 
        Predicate<Integer> par = (num) -> num % 2 == 0;
        Predicate<Integer> div3 = (num) -> num % 3 == 0;

        Arrays.stream(numeros).boxed()
        .forEach(n -> System.out.println("¿Cumple " + n + " con los criterios? " + mayor50.and(div3).and(par).test(n))); // importante el test para los Pedicates o BiPredicates
        //.and() , .or() y .negate(), importantes. En este caso solo uso .and()
    }

    public void ej9(){
        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lista1.add((int)(Math.random()*21));
            lista2.add((int)(Math.random()*21));
        }
        System.out.println(lista1.stream().sorted().map(Object::toString).collect(Collectors.joining(", ")));
        System.out.println(lista2.stream().sorted().map(Object::toString).collect(Collectors.joining(", ")));

        BiFunction<ArrayList<Integer>, ArrayList<Integer>, ArrayList<Integer>> fusionarLista = (l1, l2) -> Stream.concat(l1.stream(), l2.stream())
        .distinct()
        .sorted()
        .collect(Collectors.toCollection(ArrayList::new));
  
        System.out.println(fusionarLista.apply(lista1, lista2).stream().map(Object::toString).collect(Collectors.joining(", ")));
        
    }
}
