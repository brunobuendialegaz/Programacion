package agente;

import java.util.Scanner;

import controller.CuadradoMagico;

public class Menu {

    public void menu(){
        Scanner s = new Scanner(System.in);
        int tamanioMatriz;
        System.out.printf("Introduce el tamaño de la matriz (n): ");
        tamanioMatriz = s.nextInt();
        CuadradoMagico cuadradoMagico = new CuadradoMagico(tamanioMatriz);
        System.out.println("Buscando el cuadrado magico...");
        cuadradoMagico.rellenarCuadrado();
        s.close();
    }

}
