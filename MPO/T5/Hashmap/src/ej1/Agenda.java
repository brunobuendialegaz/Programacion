package ej1;

import java.util.HashMap;

public class Agenda {

    private HashMap<String, String> contactos;

    public HashMap<String, String> getContactos() {
        return contactos;
    }

    public void setContactos(HashMap<String, String> contactos) {
        this.contactos = contactos;
    }

    public Agenda(){
        contactos = new HashMap<>();
    }

    public Agenda(HashMap<String, String> contacto){
        this.contactos = contacto;
    }

    public void agregarContacto(String nombre, String telefono){
        if (contactos.containsKey(nombre)) {
            String telefonoActual = contactos.get(nombre);
            if (telefonoActual.equals(telefono)) {
                System.out.println("El contacto '" + nombre + "' ya existe con el mismo número.");
            } else {
                contactos.put(nombre, telefono); //
                System.out.println("Contacto '" + nombre + "' actualizado con el nuevo teléfono.");
            }
        } else {
        contactos.put(nombre, telefono);
        System.out.println("Contacto '" + nombre + "' añadido con éxito.");
    }
    }

    public String buscarContacto(String nombre){
        if (contactos.containsKey(nombre)) {
            return contactos.get(nombre);
        } else {
            return "Contacto no encontrado";
        }
    }

    public boolean eliminarContacto(String nombre){
        if (contactos.containsKey(nombre)) {
            contactos.remove(nombre);
            return true;
        }
        return false;
    }

    public void listarContactos(){
        if (contactos.isEmpty()) {
            System.out.println("La agenda esta vacía");
        } else {
            System.out.println("---  CONTACTOS AGENDA  ---");
            for (String nombre : contactos.keySet()) {
                String telefono = contactos.get(nombre);
                System.out.println("Nombre: " + nombre + ", Teléfono: " + telefono);
            }
        }
    }

    public String listarContactosMalo(){
        return contactos.toString();
    }

    public int contarContactos(){
        return contactos.size();
    }

    public boolean existeContacto(String nombre){
        return contactos.containsKey(nombre);
    }

    

}
