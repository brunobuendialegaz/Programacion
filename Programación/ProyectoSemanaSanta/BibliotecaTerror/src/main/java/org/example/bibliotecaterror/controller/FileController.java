package org.example.bibliotecaterror.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.bibliotecaterror.model.Libro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileController {

    private final String ruta = "src/main/resources/org/example/bibliotecaterror/data/favoritos.obj";

    public void exportarLibros(ObservableList<Libro> librosFavoritos){
        File file = new File(ruta);
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            List<Libro> librosExportar = new ArrayList<>(librosFavoritos);
            //Exportación directamente en formato lista, menos complejo de programar y sin bucles.
            objectOutputStream.writeObject(librosExportar);
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado: " + e);
        } catch (IOException e) {
            System.out.println("Error de IO " + e);
        }
    }

    public ObservableList<Libro> importarFavoritos(){
        File file = new File(ruta);
        List<Libro> librosImportar = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            //Importo directamente la lista
            librosImportar = (List<Libro>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error de lectura " + e);
        } catch (IOException e) {
            System.out.println("Error de IO " + e);
        }
        //Retorno "casteado" a ObservableList
        return FXCollections.observableArrayList(librosImportar);
    }
    }

