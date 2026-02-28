package controler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Agenda;
import model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
public class ControllerAgenda {

    private Agenda agenda;
    private Scanner s;
    private String basePath;




    public ControllerAgenda(){
        s = new Scanner(System.in);
        agenda = new Agenda();
        basePath = "C:\\Users\\bruno\\Documents\\GitHub\\Programacion\\Programación\\Tema 7\\EjercicioAgenda\\src\\main\\java\\ficheros";
        System.out.println("Usuarios importados: " + importarUsuarios());
    }

    public void menuAgenda(){
        int opcion=-1;
        do {
            System.out.print("""
                    Menú:
                    ---------------------
                    
                    1. Añadir Usuario
                    2. Listar Usuarios
                    3. Exportar Usuarios
                    4. Importar Usuarios (sobrescribir)
                    5. Salir
                    
                    ---------------------
                    ¿Que opción quieres utilizar? """);
            try {
                opcion = s.nextInt();
                System.out.println("");
            } catch (InputMismatchException e) {
                opcion = -1;
            }
            switch (opcion){
                case 1->{
                    System.out.print("Indica nombre: ");
                    String nombre = s.next();
                    System.out.print("Indica apellido: ");
                    String apellido = s.next();
                    System.out.print("Indica dni: ");
                    String dni = s.next();
                    anadirUsuario(new Usuario(nombre, apellido, dni));}
                case 2 -> mostrarUsuarios();
                case 3 -> exportarUsuarios();
                case 4 -> importarUsuarios();
                case 5 -> System.out.println("Saliendo del programa...");
                default -> {
                    System.out.println("Caso no contemplado.");
                    s = new Scanner(System.in);
                }
            }
        }while(opcion!=5);
    }

    public boolean anadirUsuario(Usuario usuario){
        return agenda.getAgenda().add(usuario);
    }

    public void mostrarUsuarios(){
        agenda.getAgenda().forEach(System.out::println);
    }

    public boolean exportarUsuarios(){
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(basePath + "\\usuarios.csv");
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()){
                file.delete();
                file.createNewFile();
            }
            bufferedWriter = new BufferedWriter(new FileWriter(file,true));
            bufferedWriter.write("nombre,apellido,dni");
            for (Usuario usuario : agenda.getAgenda()) {
                bufferedWriter.newLine();
                bufferedWriter.write(String.valueOf(usuario));
            }
        }catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado.");
            return false;
        }catch (IOException e) {
            System.out.println("Fallo de IO");
            return false;
        } finally {
            try {
                if (bufferedWriter!=null){
                    bufferedWriter.close();
                }
            } catch (IOException | NullPointerException e) {
                System.out.println("Error de cerrado.");
                return false;
            }
        }
        return true;
    }

    public boolean importarUsuarios(){
        File file = new File(basePath + "\\usuarios.csv");
        agenda.setAgenda(new ArrayList<>());
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            bufferedReader.readLine();
            String linea;
            while ((linea = bufferedReader.readLine())!=null){
                String[] datos = linea.split(",");
                agenda.getAgenda().add(new Usuario(datos[0],datos[1],datos[2]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado.");
            return false;
        } catch (IOException e) {
            System.out.println("Error de lectura.");
            return false;
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Error de cerrado.");;
            }
        }
        return true;
    }


}
