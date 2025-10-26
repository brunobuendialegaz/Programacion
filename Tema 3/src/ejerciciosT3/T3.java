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
    public void ej6(){
        int edad;
        System.out.println("Introduce tu edad: ");
        edad = s.nextInt();
        if(edad>=16){
            System.out.println("Acceso concedido.");
        }else{
            System.out.println("Acceso denegado, debes tener al menos 16 años.");
        }
    }
    public void ej7(){
        double nota;
        System.out.println("Introduce tu nota: ");
        nota = s.nextDouble();
        if(nota<0||nota>10){
            System.out.println("Nota incorrecta, debe estar entre 0 y 10");
        } else if (nota<5) {
            System.out.println("Lastima, has suspendido el examen");
        } else if (nota>=5&&nota<7) {
            System.out.println("Tu nota es: aprobado");
        } else if (nota>=7&&nota<9) {
            System.out.println("Tu nota es: notable");
        } else{
            System.out.println("Tu nota es: sobresaliente.");
        }
    }
    public void ej8(){
        System.out.println("Introduce el primer numero: ");
        int num1 = s.nextInt();
        System.out.println("Introduce el primer segundo: ");
        int num2 = s.nextInt();
        if (num1>num2){
            System.out.println(num1+" es mayor que "+num2);
        } else if (num1==num2) {
            System.out.println(num1+" es igual que "+num2);
        } else {
            System.out.println(num1+" es menor que "+num2);
        }
    }
    public void ej9(){
        System.out.println("Introduce tu peso: ");
        double peso = s.nextDouble();
        System.out.println("Introduce tu altura: ");
        double altura = s.nextDouble();
        System.out.println("Tu IMC es: "+peso/(altura*altura));
        if ((peso/(altura*altura))>=25){
            System.out.println("Tienes sobrepeso segun tu IMC.");
        } else if ((peso/(altura*altura))<18.5) {
            System.out.println("Estas por debajo de tu peso sano segun tu IMC.");
        }else {
            System.out.println("Estas en un peso sano segun tu IMC.");
        }

    }
    public void ej15(){
        System.out.print("Introduce el peso del paquete (kg): ");
        int peso = s.nextInt();
        System.out.print("Introduce la distancia de envío (km): ");
        int distancia = s.nextInt();
        System.out.print("¿El pedido es urgente? (true/false): ");
        boolean urgente = s.nextBoolean();
        double coste1;
        if ((peso-5)>0){
            coste1 = (peso-5)*2;
            System.out.println("Peso: "+peso+". (Excede 5kg en "+(peso-5)+"kg)");
            System.out.println("Coste adicional: "+((double)peso-5)*2+"€");
        } else {
            coste1 = 0;
            System.out.println("El peso no excede los 5kg permitidos, no hay coste adicional.");
        }
        double coste2;
        if (distancia>100){
            coste2 = 10;
            System.out.println("Distancia: "+distancia+"km (mayor que 100)");
            System.out.println("Coste adicional por distancia: "+coste2+"€");
        }else {
            coste2 = 0;
            System.out.println("No se supera la distancia estandar, no hay coste adicional");
        }
        double coste3;
        if (urgente){
            coste3 = (coste1+coste2+5)*0.5;
            System.out.println("El pedido es urgente.");
            System.out.println("Recargo por urgencia: "+coste3+"€");
        }else {
            coste3 = 0;
            System.out.println("El pedido no es urgente, no hay coste adicional.");
        }
        double costeFinal =5+coste1+coste2+coste3;
        System.out.println("El precio final del envio es: "+costeFinal+"€");
    }

    public void scannerClose(){
        s.close();
    }
}
