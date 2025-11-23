import Metodos.JugadorDardos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce el nombre del primer jugador: ");
        JugadorDardos j1 = new JugadorDardos(s.nextLine());
        System.out.print("Introduce el nombre del segundo jugador: ");
        JugadorDardos j2 = new JugadorDardos(s.nextLine());
        System.out.println("Comenzamos el juego!!!");
        int pj1, pj2, jugada = 0;

        do {
            jugada++;
            System.out.printf("%nProcedemos con los lanzamientos de la jugada %d... %n%n", jugada);
            System.out.printf("Lanzamiento de %s, puntuación actual %d.%n",j1.getNombre(),j1.getPuntacionTotal());
            j1.lanzarDardo();
            System.out.printf("Puntuación del lanzamiento %d, nueva puntuación %d.%n",j1.getUltimoLanzamiento(), j1.getPuntacionTotal());
            System.out.printf("Lanzamiento de %s, puntuación actual %d.%n",j2.getNombre(),j2.getPuntacionTotal());
            j2.lanzarDardo();
            System.out.printf("Puntuación del lanzamiento %d, nueva puntuación %d.%n",j2.getUltimoLanzamiento(), j2.getPuntacionTotal());
        }while (j1.getPuntacionTotal()>0 && j2.getPuntacionTotal()>0);

        if (j1.getPuntacionTotal()==0){
            System.out.printf("Felicidades %s, has humillado a %s, tu puntuación ha llegado a 0 en %d jugadas.",j1.getNombre(), j2.getNombre(), jugada);
        } else if (j2.getPuntacionTotal()==0) {
            System.out.printf("Felicidades %s, has humillado a %s, tu puntuación ha llegado a 0 en %d jugadas.",j2.getNombre(), j1.getNombre(), jugada);
        }
    }
}
