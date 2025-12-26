package agente;

import java.util.ArrayList;

public class CuadradoMagico {

    //objeto cuadrado magico, toda la logica y ejecuciones van aqui

    private int tamanio;
    private int[][] cuadradoMagico;
    private ArrayList<Integer> pool; // utilizo una pool para ahorrar tiempo de ejecución tirando randoms sin sentido.
    private int constanteMagica; 

    public CuadradoMagico(){
    }

    //Constructor utilizado en el ejercicio, solo tomo el tamaño de la matriz e inicializo todo en base a ese valor.

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


    //Inicializa la pool, tanto la primera vez como cada vez que falla el cuadrado
    private void rellenarPool(){
        pool.clear();
        for (int i = 0; i < tamanio*tamanio; i++) {
            pool.add(i+1);
        }
    }

    //cada vez que el cuadrado falla se reinician todos los valores a 0, es importante por que uso comprobaciones en base al 0.
    private void refrescarCuadrado(){
        for (int i = 0; i < cuadradoMagico.length; i++) {
            for (int j = 0; j < cuadradoMagico.length; j++) {
                cuadradoMagico[i][j] = 0;  
            }
            
        }
    }

    //Funciona como controller de la logica mas especifica. Utiliza comprobaciones intermedias y trata de desechar los bucles lo mas rapido posible.
    //En caso de que el cuadrado sea correcto tambien llama al metodo mostrarCuadrado.
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

    //Metodo para la primera diagonal, termina siempre con un numero que de la constante magica
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

    //Metodo para la segunda diagonal, termina siempre con un numero que de la constante magica
    //tiene en cuenta que uno de los numeros puede ser distinto de 0.
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

    //Rellena las filas, lo uso despues de las 2 diagonales. Mete todas las filas salvo la ultima buscando el numero necesario para que den la constante magica.
    //En el caso de la ultima fila uso un comprobador de columnas para todas las columnas centrales (la primera y la ultima ya estan completas por las diagonales)
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

    //Muestra el cuadrado con el formato indicado en el ejercicio. Solo se ejecuta una vez es correcto.
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

    //metodos de comprobación
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

    //metodo de comprobación general
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

    //buscadores de lus ultimos numeros de filas, columna y diagonales.
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
