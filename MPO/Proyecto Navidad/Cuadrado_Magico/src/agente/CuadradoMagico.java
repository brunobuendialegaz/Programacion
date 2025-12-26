package agente;

import java.util.ArrayList;

public class CuadradoMagico {

    private int tamanio;
    private int[][] cuadradoMagico;
    private ArrayList<Integer> pool;
    private int constanteMagica; 

    public CuadradoMagico(){
        this.cuadradoMagico = new int[tamanio][tamanio];
        this.constanteMagica = (tamanio*(tamanio*tamanio+1))/2;
        rellenarPool();
    }

    public CuadradoMagico(int tamanio){
        this.tamanio = tamanio;
        this.cuadradoMagico = new int[tamanio][tamanio];
        this.constanteMagica = (tamanio*(tamanio*tamanio+1))/2;
        rellenarPool();
    }

    public int getTamanio() {
        return tamanio;
    }
    public int[][] getCuadradoMagico() {
        return cuadradoMagico;
    }
    public ArrayList<Integer> getPull() {
        return pool;
    }
    public void setCuadradoMagico(int[][] cuadradoMagico) {
        this.cuadradoMagico = cuadradoMagico;
    }
    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    public void setPull(ArrayList<Integer> pull) {
        this.pool = pull;
    }


    private void rellenarPool(){
    this.pool = new ArrayList<>();
    int numero = 1;
    for (int i = 0; i < tamanio*tamanio; i++) {
        pool.add(numero);
        numero++;
    }
    }

    public void rellenarCuadrado(){
        int numAleatorio;
        long contador =0L;
        do {

            for (int i = 0; i < cuadradoMagico.length; i++) {
                for (int j = 0; j < cuadradoMagico.length; j++) {
                    if (j<cuadradoMagico.length-1) {
                    numAleatorio = (int)(Math.random()*pool.size());
                    cuadradoMagico[i][j] = pool.get(numAleatorio);
                    pool.remove(numAleatorio);  
                    }else{
                        cuadradoMagico[i][j]=ultimoFila(i);
                    }

                }
                if(!comprobarFila(i)){
                    rellenarPool();
                    break;
                }
            }
            rellenarPool();
            contador++;
            if ((contador%1000000)==0) {
                System.out.println("Llevamos "+(contador/1000000)+" millones de intentos... Seguimos...");
                
            }

        } while (!comprobarCuadrado());
        mostrarCuadrado(contador);
    }

    private void mostrarCuadrado(long intentos){
        System.out.print("=== CUADRADO MÁGICO ENCONTRADO ===");
        for (int i = 0; i < cuadradoMagico.length; i++) {
            System.out.println();
                for (int j = 0; j < cuadradoMagico.length; j++) {
                    System.out.print("\t"+cuadradoMagico[i][j]);
                }
        }        
        System.out.println("\nConstante mágica: "+constanteMagica);
        System.out.println("Intentos realizados: "+intentos);
    }

    private boolean comprobarFila(int i){
        int num = 0;
        for (int j = 0; j < cuadradoMagico.length; j++) {
            num += cuadradoMagico[i][j];
        }
        if (num==constanteMagica) {
            return true;
        }else{
            return false;
        }
    }

    private int ultimoFila(int i){
        int num = 0;
        for (int j = 0; j < cuadradoMagico.length-1; j++) {
            num += cuadradoMagico[i][j];
        }
        int index = pool.indexOf(constanteMagica-num);
        if (index!=-1) {
            pool.remove(index);
            return constanteMagica-num;
        }
        return -1;
    }

    

    private boolean comprobarColumna(int j){
        int num = 0;
        for (int i = 0; i < cuadradoMagico.length; i++) {
            num += cuadradoMagico[i][j];
        }
        if (num==constanteMagica) {
            return true;
        }else{
            return false;
        }
    }

    private boolean comprobarDiagonalPrincipal(){
        int num = 0;
        for (int i = 0; i < cuadradoMagico.length; i++) {
            num += cuadradoMagico[i][i];
        }
        if (num==constanteMagica) {
            return true;
        }else{
            return false;
        }
    }

    private boolean comprobarDiagonalSecundaria(){
        int num = 0;
        for (int i = 0; i < cuadradoMagico.length; i++) {
            num += cuadradoMagico[(cuadradoMagico.length-1)-i][i];
        }
        if (num==constanteMagica) {
            return true;
        }else{
            return false;
        }
    }

    private boolean comprobarCuadrado(){
        for (int i = 0; i < cuadradoMagico.length; i++) {
            if(!comprobarColumna(i)||!comprobarFila(i)){
                return false;
            }
        }
        if(!comprobarDiagonalPrincipal()||!comprobarDiagonalSecundaria()){
                return false;
        }
        return true;
    }
}
