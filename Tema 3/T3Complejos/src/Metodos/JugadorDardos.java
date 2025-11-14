package Metodos;

import java.util.Random;

public class JugadorDardos {

    private String nombre;
    private int puntacionTotal;
    private int ultimoLanzamiento;

    public JugadorDardos(String nombreP){
        this.nombre = nombreP;
        this.puntacionTotal = 301;
        this.ultimoLanzamiento = 0;
    }

    public int lanzarDardo(){
        int contador = 3;
        Random lanzar = new Random();
        this.ultimoLanzamiento = 0;
        do {
            ultimoLanzamiento += lanzar.nextInt(61);
            contador--;
        }while(contador>0);
        if (ultimoLanzamiento<=puntacionTotal) {
            puntacionTotal -= ultimoLanzamiento;
        }
        return puntacionTotal;
    }

    public int getPuntacionTotal(){
        return puntacionTotal;
    }

    public String getNombre(){
        return nombre;
    }

    public int getUltimoLanzamiento(){
        return ultimoLanzamiento;
    }

}
