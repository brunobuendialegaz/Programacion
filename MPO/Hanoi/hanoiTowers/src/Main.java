public class Main {


    public static void main(String[] args) {

        hanoi(3,'a', 'b', 'c');

    }

    private static void hanoi(int discos,char origen, char destino, char auxiliar) {
        if (discos == 1){
            System.out.println("Movimiento del disco 1 desde " + origen + " hasta " + destino);
            return;
        }
        hanoi(discos-1, origen,auxiliar,destino);
        System.out.println("Movimiento del disco "+discos+" desde "+origen+" hasta "+destino);

        hanoi(discos-1, auxiliar,destino,origen);
    }


}
