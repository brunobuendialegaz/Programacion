import model.Archivo;
import model.Libro;

public class Main {

    public static void main(String[] args) {
        Libro libro = new Libro(15, "El jardin de las palabras", "Makoto Shinkai", "18MB", "epub", 480, "ES109238091");

        libro.mostrarDatos();
    }
}
