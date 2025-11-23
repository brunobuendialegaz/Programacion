import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String[] palabraSecreta = {"leona", "casas", "jugar", "risas", "coches"};
        String palabraRandom = palabraSecreta[(int)(Math.random()*5)];
        System.out.println("Palabra secreta: "+palabraRandom);

        int aciertos;
        int acercamientos;
        int intentos = 5;
        boolean pAcertada = false;
        do {
            aciertos = 0;
            acercamientos = 0;
            System.out.print("Introduce una palabra de 5 caracteres: ");
            String palabraUsuario = s.nextLine().toLowerCase();
            while (palabraUsuario.length()!=5){
                System.out.print("La palabra no es valida, introduce otra: ");
                palabraUsuario = s.nextLine().toLowerCase();
            }
            for (int i=0; i<5 ; i++){
                if (palabraUsuario.equalsIgnoreCase(palabraRandom)){
                    System.out.println("Felicidades, has acertado");
                    pAcertada = true;
                    break;
                } else if (palabraUsuario.charAt(i) == palabraRandom.charAt(i)) {
                    aciertos++;
                } else if (palabraUsuario.contains(String.valueOf(palabraRandom.charAt(i)))) {
                    acercamientos++;
                }
            }
            intentos--;
            System.out.printf("Intentos disponibles %d, aciertos %d, acercamientos %d.%n",intentos,aciertos,acercamientos);
        }while (intentos>0&&!pAcertada);
        if (!pAcertada){
            System.out.println("No lo has conseguido");
        }
        System.out.println("Programa terminado");
    }
}
