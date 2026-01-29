package controller;

import model.Archivo;
import model.Libro;

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
                    4.- Buscar archivos.
                    5.- Salir
                    Introduce una opción.
                    """);
            opcion = s.nextInt();
            s.nextLine();
            switch (opcion){
                case 1 -> {

                }
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
            }

        }while (opcion!=5);
    }

    private boolean anadirArchivo(Archivo archivo){
        if (archivos.containsKey(archivo.getIdentificador())){
            return false;
        }
        archivos.put(archivo.getIdentificador(), archivo);
        return true;
    }

    private Libro crearLibro(){
        return new Libro();
    }

    private boolean eliminarArchivo(int numero){
        if (archivos.containsKey(numero)){
            archivos.remove(numero);
            return true;
        }
        return false;
    }

    private void listarArchivos(){
        archivos.forEach((id, archivo) -> {
        archivo.mostrarDatos();
        });
    }

    private void buscarPorAutor(){}

    private void buscarPorActor(){}

    private void buscarPorDirector(){}
}
