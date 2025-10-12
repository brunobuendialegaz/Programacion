public class Main {
    public static void main(String[] args) {
        String usuario = "Laura";
        int nivel = 1;
        int puntuacion = 0;
        Constantes.version();
        System.out.println("Valor de PI: "+Constantes.PI);
        System.out.println("Usuario actual: "+usuario);
        System.out.println("Nivel: "+nivel);
        System.out.println("Puntuación: "+puntuacion);
        usuario = "Miguel";
        nivel = 15;
        puntuacion = 150;
        System.out.println("Usuario actualizado: "+usuario);
        System.out.println("Nivel: "+nivel);
        System.out.println("Puntuación: "+puntuacion);


    }
}
