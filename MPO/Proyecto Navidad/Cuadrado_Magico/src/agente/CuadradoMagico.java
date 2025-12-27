package agente;

import java.util.ArrayList;

public class CuadradoMagico {

    /*
    Este algoritmo es una "mejora" del anterior, saca mucho mas rapido el 5x5, en torno a unos 5 minutos, algunas veces
    mucho menos, el problema es que es algo mas lento en los 3x3 y los 4x4, aunque no demasiado.
    Para mi gusto lo peor es que he tenido que retocar todos los metodos de comprobación y finales,
    haciendo para mi el codigo mucho menos legible.

    https://github.com/brunobuendialegaz/Programacion/tree/main/MPO/Proyecto%20Navidad/Cuadrado_Magico

     */

    //objeto cuadrado mágico, toda la lógica y ejecuciones van aqui

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
    public ArrayList<Integer> getPool() {
        return pool;
    }
    public void setCuadradoMagico(int[][] cuadradoMagico) {
        this.cuadradoMagico = cuadradoMagico;
    }
    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    public void setPool(ArrayList<Integer> pull) {
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

    //Funciona como controller de la lógica mas especifica. Utiliza comprobaciones intermedias y trata de desechar los bucles lo más rápido posible.
    //En caso de que el cuadrado sea correcto tambien llama al metodo mostrarCuadrado.
    public void rellenarCuadrado(){
        
        long contador =0L;
        do {
            contador++;
            refrescarCuadrado();
            rellenarPool();
            
            rellenarDiagonalPrincipal();
            rellenarDiagonalSecundaria();
            
            if (!comprobarDiagonalPrincipal(cuadradoMagico)||!comprobarDiagonalSecundaria(cuadradoMagico)) {
                continue;
            }
            int contadorSecundario = 0;
            //tras darle una vuelta he añadido este bucle para aprovechar cuando estan bien las diagonales y hacer intentos
            //por esto, he tenido que meter argumentos a todos los metodos de comprobación y de "ultimo"
            //ya que para hacerlo tengo que hacer copias de la pool y del cuadrado magico. Por tanto necesito saber que comprobar
            // en cada caso
            while (contadorSecundario<1000&&!comprobarCuadrado(cuadradoMagico)){
                cuadradoMagico = rellenarFilas(cuadradoMagico,pool);
                contadorSecundario++;
            }
            contador += contadorSecundario;

            if ((contador%10000000)<=999) {
                System.out.println("Llevamos "+(contador/1000000)+" millones de intentos... Seguimos...");
            }
            
        } while (!comprobarCuadrado(cuadradoMagico));
        mostrarCuadrado(contador);
    }

    //Método para la primera diagonal, termina siempre con un número que de la constante magica
    private void rellenarDiagonalPrincipal(){
        int numAleatorio;
        for (int i = 0; i < cuadradoMagico.length; i++) {
            if (i<cuadradoMagico.length-1) {
                numAleatorio = (int)(Math.random()*pool.size());
                cuadradoMagico[i][i] = pool.remove(numAleatorio);
            } else {
                cuadradoMagico[i][i] = ultimoDiagonalPrincipal(pool,cuadradoMagico);
            }
        }    
    }

    //Método para la segunda diagonal, termina siempre con un número que de la constante mágica
    //tiene en cuenta que uno de los numeros puede ser distinto de 0 por que ya esta relleno en la primera Diagonal.
    private void rellenarDiagonalSecundaria(){
        int numAleatorio;
        for (int i = 0; i < cuadradoMagico.length; i++) {
            if (cuadradoMagico[(cuadradoMagico.length-1)-i][i]==0) {
                if (i<cuadradoMagico.length-1) {
                    numAleatorio = (int)(Math.random()*pool.size());
                    cuadradoMagico[(cuadradoMagico.length-1)-i][i] = pool.remove(numAleatorio);
                } else {
                    cuadradoMagico[(cuadradoMagico.length-1)-i][i] = ultimoDiagonalSecundaria(pool, cuadradoMagico);
                }
            }

        }
    }

    //Rellena las filas, lo uso despues de las 2 diagonales. Mete todas las filas salvo la ultima buscando el número necesario para que den la constante mágica.
    //En el caso de la última fila uso un comprobador de columnas para todas las columnas centrales (la primera y la última ya estan completas por las diagonales)
    private int[][] rellenarFilas(int [][] matriz, ArrayList<Integer> pool){
        int[][] matrizCopia = clonarMatriz(matriz);
        ArrayList<Integer> poolCopia = new ArrayList<>(pool);
        int numAleatorio;
        for (int i = 0; i < matriz.length-1; i++) {
            for (int j = 0; j < matrizCopia.length; j++) {
                if (matrizCopia[i][j]==0) {
                    if (j<matrizCopia.length-1) {
                        numAleatorio = (int)(Math.random()*poolCopia.size());
                        matrizCopia[i][j] = poolCopia.remove(numAleatorio);
                    }else {
                        int numNecesario = ultimoFila(i, poolCopia, matrizCopia);
                        if (numNecesario == -1) {
                            return matriz;
                        }
                        matrizCopia[i][j] = numNecesario;
                    }
                }
            }

            if(!comprobarFila(i,matrizCopia)){
                return matriz;
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            if(i!=0&&i!=matrizCopia.length-1){
                int numNecesario = ultimoColumnas(i,poolCopia,matrizCopia);
                if(numNecesario==-1){
                    return matriz;
                }
                matrizCopia[matrizCopia.length-1][i] = numNecesario;
            }
        }
        return matrizCopia;
    }

    // clona la matriz para hacer sucesivas pruebas sin alterar las diagonales.
    private int[][] clonarMatriz(int[][] matriz){
        int[][] copia = new int[matriz.length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                copia[i][j] = matriz[i][j];
            }
        }
        return copia;
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

    //métodos de comprobación
    private boolean comprobarFila(int i, int[][] matriz){
        int num = 0;
        for (int j = 0; j < matriz.length; j++) {
            num += matriz[i][j];
        }
        if (num==constanteMagica) {
            return true;
        }else{
            return false;
        }
    }

    private boolean comprobarColumna(int j, int[][] matriz){
        int num = 0;
        for (int i = 0; i < matriz.length; i++) {
            num += matriz[i][j];
        }
        if (num==constanteMagica) {
            return true;
        }else{
            return false;
        }
    }

    private boolean comprobarDiagonalPrincipal(int[][] matriz){
        int num = 0;
        for (int i = 0; i < matriz.length; i++) {
            num += matriz[i][i];
        }
        if (num==constanteMagica) {
            return true;
        }else{
            return false;
        }
    }

    private boolean comprobarDiagonalSecundaria(int[][] matriz){
        int num = 0;
        for (int i = 0; i < matriz.length; i++) {
            num += matriz[(matriz.length-1)-i][i];
        }
        if (num==constanteMagica) {
            return true;
        }else{
            return false;
        }
    }

    //método de comprobación general
    private boolean comprobarCuadrado(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            if(!comprobarColumna(i,matriz)||!comprobarFila(i,matriz)){
                return false;
            }
        }
        if(!comprobarDiagonalPrincipal(matriz)||!comprobarDiagonalSecundaria(matriz)){
                return false;
        }
        return true;
    }

    //buscadores de lus últimos números de filas, columna y diagonales.
    private int ultimoFila(int i, ArrayList<Integer> pool,int[][] matriz){
        int[][] matrizCopia = clonarMatriz(matriz);
        int num = 0;
        for (int j = 0; j < matrizCopia.length-1; j++) {
            num += matrizCopia[i][j];
        }
        int index = pool.indexOf(constanteMagica-num);
        if (index!=-1) {
            pool.remove(index);
            return constanteMagica-num;
        }
        return -1;
    }

    private int ultimoColumnas(int f, ArrayList<Integer> pool,int[][] matriz){
        int[][] matrizCopia = clonarMatriz(matriz);
        int num = 0;
        for (int i = 0; i < matrizCopia.length; i++) {
            num += matrizCopia[i][f];
        }
        int index = pool.indexOf(constanteMagica-num);
        if (index!=-1){
            pool.remove(index);
            return constanteMagica-num;
        }
        return -1;
    }

    private int ultimoDiagonalPrincipal(ArrayList<Integer> pool, int[][] matriz){
        int[][] matrizCopia = clonarMatriz(matriz);
        int num = 0;
        for (int i = 0; i < matrizCopia.length-1; i++) {
            num += matrizCopia[i][i];
        }
        int index = pool.indexOf(constanteMagica-num);
        if (index!=-1) {
            pool.remove(index);
            return constanteMagica-num;
        }
        return -1;
    }
    
    private int ultimoDiagonalSecundaria(ArrayList<Integer> pool, int[][] matriz){
        int[][] matrizCopia = clonarMatriz(matriz);
        int num = 0;
        for (int i = 0; i < matrizCopia.length-1; i++) {
            num += matrizCopia[(matrizCopia.length-1)-i][i];
        }
        int index = pool.indexOf(constanteMagica-num);
        if (index!=-1) {
            pool.remove(index);
            return constanteMagica-num;
        }
        return -1;
    }
    

}
