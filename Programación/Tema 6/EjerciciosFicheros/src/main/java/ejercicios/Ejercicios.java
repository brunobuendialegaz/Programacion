package ejercicios;

import model.Alumno;

import java.io.*;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Ejercicios {
    // BufferedReader br = new BufferedReader(new FileReader(ruta)))
    Scanner s = new Scanner(System.in);

    public void ej1(){

        System.out.print("Indica la ruta completa del archivo que quieres leer: ");
        String ruta = s.nextLine();

        try (FileReader lector = new FileReader(ruta)) {
            int valor;

            while ((valor = lector.read()) != -1){
                System.out.print((char) valor);
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo.");;
        } catch (IOException e) {
            System.out.println("Problema inesperado: " + e);;
        }
    }

    public void ej2(){
        System.out.print("Introduce la ruta del archivo: ");
        String ruta = s.nextLine();
        System.out.print("Introduce la palabra a buscar: ");
        String palabraBuscar = s.nextLine();

        try (BufferedReader buffer = new BufferedReader(new FileReader(ruta))) {
            int contador = 0;
            String linea;
            while ((linea = buffer.readLine()) != null){
                System.out.println(linea);
                if (linea.toLowerCase().contains(palabraBuscar.toLowerCase())) contador++;
            }
            System.out.println("La palabra ha sido encontrada: " + contador + " veces.");
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo.");;
        } catch (IOException e) {
            System.out.println("Problema inesperado: " + e);;
        }

    }

    public void ej3(){
        System.out.print("Introduce la ruta de origen del archivo: ");
        String rutaOrigen = s.nextLine();
        System.out.print("Introduce la ruta de destino de la copia: ");
        String rutaDestino = s.nextLine();

        try (FileReader lectura = new FileReader(rutaOrigen);
        FileWriter escritura = new FileWriter(rutaDestino)) {
            int caracter;

            while ((caracter = lectura.read()) != -1){
                escritura.write(caracter);
            }
            System.out.println("El archivo ha sido copiado correctamente.");

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo.");;
        } catch (IOException e) {
            System.out.println("Problema inesperado: " + e);;
        }

    }

    public void ej4(){
        System.out.print("Introduce la ruta del archivo: ");
        String ruta = s.nextLine();
        File archivo = new File(ruta);

        System.out.printf("""
                - Tamaño: %d bytes (%.2f MB)
                - Última modificación: %s
                - Permisos: Lectura (%s), Escritura (%s), Ejecución (%s)
                - Archivo oculto: %s
                - Ruta absoluta: %s
                """
        , archivo.length(), (double)archivo.length()/(1024*1024)
        , archivo.lastModified()
        , archivo.canRead() ? "si" : "no", archivo.canWrite() ? "si" : "no", archivo.canExecute() ? "si" : "no"
        , archivo.isHidden() ? "si" : "no"
        , archivo.getAbsolutePath());
    }

    public void ej5(){
        System.out.print("Escribe la ruta archivo que quieres revisar: ");
        String ruta = s.nextLine();

        try (BufferedReader buffer = new BufferedReader(new FileReader(ruta))) {
            int contador = 0;
            String linea = "";
            while ((linea = buffer.readLine()) != null){
                contador++;
            }
            System.out.println("El archivo tiene " + contador + " lineas.");

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");;
        } catch (IOException e) {
            System.out.println("Problema inesperado: " + e);;
        }
    }

    public void ej6(List<Alumno> alumnos){
        try (BufferedWriter escritura = new BufferedWriter(new FileWriter("C:\\Users\\bruno\\Documents\\GitHub\\Programacion\\" +
                "Programación\\Tema 6\\EjerciciosFicheros\\src\\main\\java\\ejercicios\\alumnos.csv"));) {
            escritura.write("Nombre,edad,nota");
            for (Alumno a : alumnos) {
                escritura.newLine();
                escritura.write(a.toCsv());
            }
        } catch (IOException e) {
            System.out.println("Error no controlado: " + e);;
        }
    }

    public void ej7(){
        System.out.print("Indica la ruta para mostrar datos: ");
        String ruta = s.nextLine();

        leerFichero(ruta, "\t");

    }

    private void  leerFichero(String path, String tabulacion){
        File file = new File(path);
        System.out.printf("%s[%s] %s (%d bytes) - Última modificación: %s%n",tabulacion,file.isDirectory()?"CARPETA":"ARCHIVO",file.getName(),file.length(), Instant.ofEpochMilli(file.lastModified())); // El Instant.ofEpochMilli es para traducir un timestamp de secs a formato fecha completa
        if (file.isDirectory()) {
            Arrays.stream(Objects.requireNonNull(file.listFiles())).forEach((item) -> leerFichero(item.getPath(), tabulacion + "\t")); // el Objects.requireNonNull me sirve para hacer control de errores not null
        }
    }
}
