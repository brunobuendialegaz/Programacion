import java.util.HashMap;

import ej1.Agenda;

public class Main {

    public static void main(String[] args) {
        Agenda miAgenda = new Agenda();

        System.out.println("--- PRUEBAS DE LA AGENDA ---");
        
        // 1. Añadir contactos
        miAgenda.agregarContacto("Bruno", "600111222");
        miAgenda.agregarContacto("Ana", "611333444");

        // 2. Probar actualización y duplicado
        miAgenda.agregarContacto("Bruno", "600111222"); // Dirá que ya existe igual
        miAgenda.agregarContacto("Bruno", "700888999"); // Lo actualizará

        // 3. Buscar
        System.out.println("Buscando a Ana: " + miAgenda.buscarContacto("Ana"));
        System.out.println("Buscando a Pedro: " + miAgenda.buscarContacto("Pedro"));

        // 4. Contar y Listar
        System.out.println("Total contactos: " + miAgenda.contarContactos()); //
        miAgenda.listarContactos();

        // 5. Eliminar y verificar
        miAgenda.eliminarContacto("Ana"); //
        System.out.println("¿Existe Ana tras borrarla?: " + miAgenda.existeContacto("Ana"));

        // 6. Lista final
        miAgenda.listarContactos();
    }

    
}
