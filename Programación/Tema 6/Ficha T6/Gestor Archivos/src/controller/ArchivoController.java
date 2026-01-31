package controller;

import model.Archivo;
import model.Audio;
import model.Libro;
import model.Video;

import java.util.HashMap;
import java.util.Scanner;

public class ArchivoController {

    private HashMap<Integer, Archivo> archivos;
    private Scanner s;

    public ArchivoController(HashMap<Integer, Archivo> archivos) {
        this.archivos = archivos;
        s = new Scanner(System.in);
    }

    public ArchivoController() {
        this.archivos = new HashMap<>();
        s = new Scanner(System.in);
    }

    public HashMap<Integer, Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(HashMap<Integer, Archivo> archivos) {
        this.archivos = archivos;
    }

    public void menuArchivos(){
        int opcion = 0;
        System.out.println("----- Abriendo Menu -----");

        do {
            System.out.printf("""
                    Menu de archivos:
                    1.- Añadir un archivo.
                    2.- Borrar un archivo.
                    3.- Listar archivos.
                    4.- Listar un tipo de archivo.
                    5.- Buscar por autor.
                    6.- Buscar por actor.
                    7.- Buscar por director.
                    8.- Salir
                    Introduce una opción.
                    """);
            opcion = s.nextInt();
            s.nextLine();
            switch (opcion){
                case 1 -> {
                    String opt = "";
                    System.out.print("¿Que tipo de archivo vas a añadir? a) libro b) video c) audio: ");
                    opt = s.nextLine();
                    crearTipoArchivo(opt);
                }
                case 2 -> {
                    System.out.print("Indica el identificador del archivo a eliminar: ");
                    int id = s.nextInt();
                    System.out.println("¿Archivo eliminado? " + eliminarArchivo(id));
                }
                case 3 -> {
                    System.out.println("Listando elementos: ");
                    listarArchivos();
                }
                case 4 -> {
                    listarTipoArchivo();
                }
                case 5 -> buscarPorAutor();
                case 6 -> buscarPorActor();
                case 7 -> buscarPorDirector();
            }

        }while (opcion!=8);
    }

    private void crearTipoArchivo(String opcion){
        switch (opcion){
            case "a" -> crearLibro();
            case "b" -> crearVideo();
            case "c" -> crearAudio();
            default -> System.out.println("Opción incorrecta");
        }
    }

    private void crearLibro(){
        System.out.print("Introduce el identificador (numeros): ");
        int identificador = s.nextInt();
        s.nextLine();
        if (archivos.containsKey(identificador)) {
            System.out.println("Archivo no introducido, ya existente");
            return;
        }
        System.out.print("Introduce el titulo: ");
        String titulo = s.nextLine();
        System.out.print("Introduce el nombre del autor: ");
        String autor = s.nextLine();
        System.out.print("Introduce el peso del archivo: ");
        String tamano = s.nextLine();
        System.out.print("Introduce el formato: ");
        String formato = s.nextLine();
        System.out.print("Introduce el número de páginas: ");
        int numeroPaginas = s.nextInt();
        s.nextLine();
        System.out.print("Introduce el isbn: ");
        String isbn = s.nextLine();
        archivos.put(identificador,new Libro(identificador, titulo, autor, tamano, formato, numeroPaginas, isbn));
        System.out.println("Archivo añadido correctamente.");
    }

    private void crearVideo(){
        System.out.print("Introduce el identificador (numeros): ");
        int identificador = s.nextInt();
        s.nextLine();
        if (archivos.containsKey(identificador)) {
            System.out.println("Archivo no introducido, ya existente");
            return;
        }
        System.out.print("Introduce el titulo: ");
        String titulo = s.nextLine();
        System.out.print("Introduce el nombre del autor: ");
        String autor = s.nextLine();
        System.out.print("Introduce el peso del archivo: ");
        String tamano = s.nextLine();
        System.out.print("Introduce el formato: ");
        String formato = s.nextLine();
        System.out.print("Introduce los actores: ");
        String actores = s.nextLine();
        System.out.print("Introduce el director: ");
        String director = s.nextLine();
        archivos.put(identificador,new Video(identificador, titulo, autor, tamano, formato, actores, director));
        System.out.println("Archivo añadido correctamente.");
    }

    private void crearAudio(){
        System.out.print("Introduce el identificador (numeros): ");
        int identificador = s.nextInt();
        s.nextLine();
        if (archivos.containsKey(identificador)) {
            System.out.println("Archivo no introducido, ya existente");
            return;
        }
        System.out.print("Introduce el titulo: ");
        String titulo = s.nextLine();
        System.out.print("Introduce el nombre del autor: ");
        String autor = s.nextLine();
        System.out.print("Introduce el peso del archivo: ");
        String tamano = s.nextLine();
        System.out.print("Introduce el formato: ");
        String formato = s.nextLine();
        System.out.print("Introduce la duración(s): ");
        int duracionSegundos = s.nextInt();
        s.nextLine();
        System.out.print("Introduce el soporte: ");
        String soporte = s.nextLine();
        archivos.put(identificador,new Audio(identificador, titulo, autor, tamano, formato, duracionSegundos, soporte));
        System.out.println("Archivo añadido correctamente.");
    }

    private boolean eliminarArchivo(int numero){
        if (archivos.containsKey(numero)){
            archivos.remove(numero);
            return true;
        }
        return false;
    }

    private void listarTipoArchivo(){
        System.out.printf("""
                            ¿Que tipo de archivos quieres listar?
                            a) Libro
                            b) Video
                            c) Audio
                            """);
        String opt = s.nextLine();
        switch (opt){
            case "a" -> {
                System.out.println("Listando elementos: ");
                archivos.values().stream().filter(archivo -> archivo instanceof Libro).forEach(Archivo::mostrarDatos);
            }
            case "b" -> {
                System.out.println("Listando elementos: ");
                archivos.values().stream().filter(archivo -> archivo instanceof Video).forEach(Archivo::mostrarDatos);
            }
            case "c" -> {
                System.out.println("Listando elementos: ");
                archivos.values().stream().filter(archivo -> archivo instanceof Audio).forEach(Archivo::mostrarDatos);
            }
        }
    }

    private void listarArchivos(){
        archivos.values().forEach((Archivo::mostrarDatos));
    }

    private void buscarPorAutor(){
        System.out.print("Introduce el autor a buscar: ");
        String autor = s.nextLine();
        archivos.values().stream().filter(archivo -> archivo.getAutor().equalsIgnoreCase(autor)).forEach(Archivo::mostrarDatos);
    }

    private void buscarPorActor(){
        System.out.print("Introduce el actor a buscar: ");
        String actor = s.nextLine();
        archivos.values().stream().filter(archivo -> archivo instanceof Video)
                .filter(archivo -> ((Video) archivo).getActores().toLowerCase().contains(actor.toLowerCase()))
                .forEach(Archivo::mostrarDatos);
    }

    private void buscarPorDirector(){
        System.out.print("Introduce el director a buscar: ");
        String director = s.nextLine();
        archivos.values().stream().filter(archivo -> archivo instanceof Video)
                .filter(archivo -> ((Video) archivo).getDirector().toLowerCase().contains(director.toLowerCase()))
                .forEach(Archivo::mostrarDatos);
    }
}
