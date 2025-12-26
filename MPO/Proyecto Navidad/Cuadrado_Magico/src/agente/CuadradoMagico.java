package agente;

import java.util.ArrayList;

public class CuadradoMagico {

    private int tamanio;
    private int[][] cuadradoMagico;
    private ArrayList<Integer> pool;
    private int constanteMagica; 

    public CuadradoMagico(){
    }

    public CuadradoMagico(int tamanio){
        this.tamanio = tamanio;
        this.cuadradoMagico = new int[tamanio][tamanio];
        this.constanteMagica = (tamanio*(tamanio*tamanio+1))/2;
        this.pool = new ArrayList<>();
        
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
        pool.clear();
        for (int i = 0; i < tamanio*tamanio; i++) {
            pool.add(i+1);
        }
    }

    private void refrescarCuadrado(){
        for (int i = 0; i < cuadradoMagico.length; i++) {
            for (int j = 0; j < cuadradoMagico.length; j++) {
                cuadradoMagico[i][j] = 0;  
            }
            
        }
    }

    public void rellenarCuadrado(){
        
        long contador =0L;
        do {
            refrescarCuadrado();
            rellenarPool();
            
            rellenarDiagonalPrincipal();
            rellenarDiagonalSecundaria();
            
            if (!comprobarDiagonalPrincipal()||!comprobarDiagonalSecundaria()) {
                continue;
            }

            rellenarFilas();
            contador++;
            if ((contador%1000000)==0) {
                System.out.println("Llevamos "+(contador/1000000)+" millones de intentos... Seguimos...");
            }
            
        } while (!comprobarCuadrado());
        mostrarCuadrado(contador);
    }

    private void rellenarDiagonalPrincipal(){
        int numAleatorio;
        for (int i = 0; i < cuadradoMagico.length; i++) {
            if (i<cuadradoMagico.length-1) {
                numAleatorio = (int)(Math.random()*pool.size());
                cuadradoMagico[i][i] = pool.remove(numAleatorio);
            } else {
                cuadradoMagico[i][i] = ultimoDiagnoalPrincipal();
            }
        }    
    }

    private void rellenarDiagonalSecundaria(){
        int numAleatorio;
        for (int i = 0; i < cuadradoMagico.length; i++) {
            if (cuadradoMagico[(cuadradoMagico.length-1)-i][i]==0) {
                if (i<cuadradoMagico.length-1) {
                    numAleatorio = (int)(Math.random()*pool.size());
                    cuadradoMagico[(cuadradoMagico.length-1)-i][i] = pool.remove(numAleatorio);
                } else {
                    cuadradoMagico[(cuadradoMagico.length-1)-i][i] = ultimoDiagnoalSecundaria();
                }
            }

        }
    }

    private void rellenarFilas(){
        int numAleatorio;
        for (int i = 0; i < cuadradoMagico.length-1; i++) {
            for (int j = 0; j < cuadradoMagico.length; j++) {
                if (cuadradoMagico[i][j]==0) {
                    if (j<cuadradoMagico.length-1) {
                    numAleatorio = (int)(Math.random()*pool.size());
                    cuadradoMagico[i][j] = pool.remove(numAleatorio); 
                    }else{
                        cuadradoMagico[i][j]=ultimoFila(i);
                    } 
                }
            }  

            if(!comprobarFila(i)){
                return;
            }
        }
        for (int i = 0; i < cuadradoMagico.length; i++) {
            if(i!=0&&i!=cuadradoMagico.length-1){
                int numNecesario = ultimoColumnas(i);
                if(numNecesario==-1){
                    return;
                }
                cuadradoMagico[cuadradoMagico.length-1][i] = numNecesario;
            }
        }
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

    private int ultimoColumnas(int f){
        int num = 0;
        for (int i = 0; i < cuadradoMagico.length; i++) {
            num += cuadradoMagico[i][f];
        }
        int index = pool.indexOf(constanteMagica-num);
        if (index!=-1){
            pool.remove(index);
            return constanteMagica-num;
        }
        return -1;
    }

        private int ultimoDiagnoalPrincipal(){
        int num = 0;
        for (int i = 0; i < cuadradoMagico.length-1; i++) {
            num += cuadradoMagico[i][i];
        }
        int index = pool.indexOf(constanteMagica-num);
        if (index!=-1) {
            pool.remove(index);
            return constanteMagica-num;
        }
        return -1;
    }
    
            private int ultimoDiagnoalSecundaria(){
        int num = 0;
        for (int i = 0; i < cuadradoMagico.length-1; i++) {
            num += cuadradoMagico[(cuadradoMagico.length-1)-i][i];
        }
        int index = pool.indexOf(constanteMagica-num);
        if (index!=-1) {
            pool.remove(index);
            return constanteMagica-num;
        }
        return -1;
    }
    

}
