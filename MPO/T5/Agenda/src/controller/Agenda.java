package controller;

import agente.Contacto;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

    Scanner s = new Scanner(System.in);
    private ArrayList<Contacto> contactos;

    public Agenda (){
        contactos = new ArrayList<>();
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void agregarContacto(){
        System.out.println("Introduce el nombre: ");
        String nombre = s.next();
        System.out.println("Introduce el apellido: ");
        String apellido = s.next();
        System.out.println("Introduce el dni: ");
        String dni = s.next();
        System.out.println("Introduce el email: ");
        String email = s.next();
        System.out.println("Introduce el telefono: ");
        int telefono = s.nextInt();
        if (existeEmail(email)){
            System.out.println("El correo ya existe, no se ha creado el contacto");
        }else {
            Contacto contacto = new Contacto(nombre, apellido, dni, email, telefono);
            contactos.add(contacto);
            System.out.println("Contacto agregado correctamente.");}
    }

    public void buscarContacto(String buscador){
        boolean encontrado = false;
        for(Contacto contacto: contactos){
            if (contacto.toString().contains(buscador)){
                System.out.println("Contacto encontrado:");
                System.out.println(contacto.toString());
                encontrado = true;
            }
        }
       if (!encontrado){
           System.out.println("Contacto no encontrado.");
       }
    }

    public void borrarContacto(String buscador){
        boolean encontrado = false;
        for(Contacto contacto: contactos){
            if (contacto.toString().contains(buscador)){
                System.out.println("Contacto eliminado.");
                contactos.remove(contacto);
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("Contacto no encontrado.");
        }
    }

    public void listaContactos(){
        System.out.println("Listado de contactos:");

        for(Contacto contacto: contactos){
            System.out.println("Contacto:");
            System.out.println(contacto.toString());
        }
    }

    private boolean existeEmail(String email){
        if (contactos.toString().contains(email)){
            return true;
        }
        return false;
    }
}
