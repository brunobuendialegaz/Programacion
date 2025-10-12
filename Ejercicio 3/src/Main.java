public class Main {
    public static void main(String[] args) {
        String nombre = "Carlos";
        int edad = 30;
        boolean estudiante = true;
        double altura = 1.75;
        char inicial = 'C';
        System.out.println("Nombre: "+nombre+" - Tipo: "+nombre.getClass().getSimpleName());
        System.out.println("Edad: "+edad+" - Tipo: "+Integer.TYPE.getSimpleName());
        System.out.println("¿Es estudiante?: "+estudiante+" - Tipo: "+Boolean.TYPE.getSimpleName());
        System.out.println("Altura: "+altura+" - Tipo: "+Double.TYPE.getSimpleName());
        System.out.println("Inicial: "+inicial+" - Tipo: "+Character.TYPE.getSimpleName());
    }
}
