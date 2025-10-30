package ejerciciosT3;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;
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
    public void ej10(){
        System.out.print("Introduce tu altura en cm: ");
        int altura = s.nextInt();
        if (altura>=120&&altura<=200){
            System.out.println("Puedes subirte, la altura minima es 120");
        } else if (altura<120) {
            System.out.println("No puedes subirte, la latura mínima es 120");
        }else
        {
            System.out.println("No puedes subirte, la altura máxima es 200");
        }
    }
    public void ej11(){
        System.out.print("Introduce el importe de la compra: ");
        double valor1 = s.nextDouble();
        System.out.println("¿Eres socio (true/false)?: ");
        boolean socio = s.nextBoolean();
        s.nextLine();
        System.out.println("Importe original: "+valor1);
        double valor2 = 0;
        if (valor1>=200&&socio){
            valor2=valor1*0.2;
            System.out.println("Eres socio y tu compra es >= 200€");
            System.out.printf("Descuento aplicado (20%%): %.2f%n",valor2);
        } else if (valor2<200&&socio) {
            valor2=valor1*0.1;
            System.out.println("Eres socio y tu compra es <200");
            System.out.printf("Descuento aplciado (10%%): %.2f%n",valor2);
        } else if (valor2>=300&&!socio) {
            valor2=valor1*0.05;
            System.out.println("No eres socio pero tu compra es >=300");
            System.out.printf("Descuento aplicado (5%%): %.2f%n",valor2);
        }else {
            System.out.println("No cumples ningun requisito, no se aplica descuento.");
        }
        System.out.printf("Importe final: %.2f€",valor1-valor2);
    }
    public void ej12(){
        System.out.print("introduce una contraseña: ");
        String contrasena = s.nextLine();
        System.out.println("Longitud decontraseña: "+contrasena.length());
        boolean longitud = contrasena.length()>=8;
        System.out.println("¿Tiene al menos 8 caracteres? "+longitud);
        boolean numero = contrasena.matches(".*[0-9].*");
        System.out.println("¿La contraseña tiene al menos 1 número? "+numero);
        //boolean prohibida = contrasena.contains("12345678")||contrasena.contains("password");
        boolean prohibida = contrasena.equals("12345678")||contrasena.equals("password");
        System.out.println("¿Es una contraseña prohibida? "+prohibida);
        boolean valida = longitud&&numero&&!prohibida;
        System.out.println("¿Es una contraseña valida? "+valida);
        if (valida){
            System.out.println("Es una contraseña valida. ");
        } else {
            System.out.print("La contraseña no es valida. ");
            if (!longitud){
                System.out.print("Debe tener al menos 8 caracteres. ");
            }
            if (!numero){
                System.out.print("Debe contener 1 número.");
            }
            if (prohibida){
                System.out.print("Debe ser distinta de 12345678 y password.");
            }
        }
    }
    public void ej13(){
        System.out.print("Introduce tu edad: ");
        int edad = s.nextInt();
        System.out.print("introduce dia de la semana (1-7): ");
        int dia = s.nextInt();
        System.out.println("Edad: "+edad+" años");
        if (dia>0&&dia<8){
            DayOfWeek diaNombre = DayOfWeek.of(dia);
            TextStyle estilo = TextStyle.FULL;
            Locale espanol = new Locale("es","ES");
            String nombreDiaEspañol = diaNombre.getDisplayName(estilo, espanol);
            System.out.println("Dia de la semana: "+dia+" "+nombreDiaEspañol);
            double precio;
            if (edad<12){
                precio=0;
                System.out.printf("Precio de entrada: %.2f€. Entrada gratis para menores de 12 años",precio);
            } else if (edad>12&&edad<18&&dia==2) {
                precio=0;
                System.out.printf("Precio de entrada: %.2f€. Entrada gratis para menores los martes",precio);
            }else if (edad>12&&edad<18&&dia!=2) {
                precio=5;
                System.out.printf("Precio de entrada: %.2f€.",precio);
            }else if (edad>18&&edad<=65&&dia==4) {
                precio=7;
                System.out.printf("Precio de entrada: %.2f€. Precio reducido los jueves",precio);
            }else if (edad>18&&edad<=65&&dia!=4) {
                precio=10;
                System.out.printf("Precio de entrada: %.2f€.",precio);
            }else if (edad>65) {
                precio=6;
                System.out.printf("Precio de entrada: %.2f€.",precio);
            }

        }else {
            System.out.println("El dia seleccionado no es valido.");
        }

    }
    public void ej14(){
        System.out.print("Introduce tu edad: ");
        int edad = s.nextInt();
        System.out.print("Introduce tus ingresos mensuales: ");
        double ingresos = s.nextDouble();
        System.out.print("¿Tienes deudas pendientes? (true/false): ");
        boolean deudas = s.nextBoolean();
        boolean edadApto = edad>=21&&edad<=65;
        System.out.println("¿Edad entre 21 y 65?: "+edadApto);
        boolean ingresosApto = ingresos>=1000;
        System.out.println("¿Ingresos >= 1000€?: "+ingresosApto);
        System.out.println("¿Sin deudas pendientes?: "+!deudas);
        if (edadApto&&ingresosApto&&!deudas){
            System.out.println("Felicidades, eres apto para el prestamo.");
        }else {
            System.out.print("Lastima, no eres apto. ");
            if (!edadApto){
                System.out.print("No estas dentro del rango de edad. ");
            }
            if (!ingresosApto){
                System.out.print("No tienes los ingresos minimos. ");
            }
            if (deudas){
                System.out.println("Tienes deudas pendientes con otras entidades. ");
            }
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
