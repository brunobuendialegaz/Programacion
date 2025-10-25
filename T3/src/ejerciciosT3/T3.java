package ejerciciosT3;

import java.util.Scanner;

public class T3 {
    Scanner s = new Scanner(System.in);
    public void ej1(){
        int edad;
        System.out.println("Introduce tu edad: ");
        edad = s.nextInt();
        if(edad>=18){
            System.out.println("Eres mayor de edad, puedes votar.");
        }else{
            System.out.println("Eres menor de edad, no puedes votar.");
        }
    }
    public void ej2(){
        int numero;
        System.out.println("Introduce un numero: ");
        numero = s.nextInt();
        if(numero<0) {
            System.out.println("El número es menor que 0.");
        } else if (numero==0){
            System.out.println("El número es 0.");
        }else{
            System.out.println("El numero es mayor que 0.");
        }
    }
    public void ej3(){
        double nota;
        System.out.println("Introduce tu nota: ");
        nota = s.nextDouble();
        if(nota>=5){
            System.out.println("Enhorabuena!!, has aprobado");
        }else{
            System.out.println("Lastima... has suspendido.");
        }
    }
    public void ej4(){
        double precio;
        System.out.println("¿Cuanto cuesta el artículo?: ");
        precio = s.nextDouble();
        System.out.println("Precio inicial: "+precio);
        if (precio>=100){
            System.out.printf("""
                    El importe neto es %.2f€
                    El descuento aplicado (10%%) es de %.2f€,
                    """,
                    precio-(precio*0.1),
                    precio*0.1);
        }else {
            System.out.println("No se aplica ningun descuendo. El precio final es "+precio+"€");}
    }
    public void ej5(){
        int numero;
        System.out.println("Introduce un número:");
        numero = s.nextInt();
        if ((numero%2)==0){
            System.out.println("Tu número es par.");
        }else {
            System.out.println("Tu número es impar.");
        }
    }

    public void scannerClose(){
        s.close();
    }
}
