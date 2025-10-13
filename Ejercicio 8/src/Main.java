import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Esto es una calculadora de area de rectangulos");
        System.out.println("Introduce la base del rectangulo: ");
        int base = entrada.nextInt();
        System.out.println("Introduce la altura del rectangulo: ");
        int altura = entrada.nextInt();
        int area = base * altura;
        System.out.println("Base del rectangulo: "+base);
        System.out.println("Altura del rectangulo: "+altura);
        System.out.println("Area del rectangulo: "+area);
    }
}
