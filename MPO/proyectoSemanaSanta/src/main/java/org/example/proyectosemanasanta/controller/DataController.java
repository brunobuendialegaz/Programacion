package org.example.proyectosemanasanta.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.proyectosemanasanta.data.DataUsers;
import org.example.proyectosemanasanta.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataController {

    private final String ruta = "src/main/java/org/example/proyectosemanasanta/resources/dataUser.obj";

    public void exportUsers(){
        File file = new File(ruta);

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(new ArrayList<>(DataUsers.getInstance().getUsers()));

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado o falta depermisos de escritura:" + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<User> importUsers(){
        File file = new File(ruta);

        try (FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return FXCollections.observableArrayList((List<User>)(objectInputStream.readObject()));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
