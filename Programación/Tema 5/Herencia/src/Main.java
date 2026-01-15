public class Main {
    
    public static void main(String[] args) {
        Perro perro = new Perro("Rex",5);

        perro.mostrarDatos();
        perro.hacerSonido();

        Gato gato = new Gato("Misifus", 5);

        gato.mostrarDatos();
        gato.hacerSonido();
    }
    
}

