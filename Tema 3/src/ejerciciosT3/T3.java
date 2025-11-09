package ejerciciosT3;

import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
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
    public void ej16(){
        for (int i = 1; i <= 10; i++) {
            System.out.println("\n------ Tabla del "+i+" ------\n");
            for (int y = 0; y <= 10; y++) {
                System.out.printf("       %d * %d = %d%n",i,y,i*y);
            }
        }
    }
    public void ej17(){
        System.out.println("Introduce el numero de la primera tabla que quieras: ");
        int tabla1 = s.nextInt();
        System.out.println("Introduce el numero de la segunda tabla que quieras: ");
        int tabla2 = s.nextInt();
        if (tabla1 > tabla2) {
            for (int i = tabla2; i <= tabla1; i++) {
                System.out.println("\n------ Tabla del "+i+" ------\n");
                for (int y = 0; y <= 10; y++) {
                    System.out.printf("       %d * %d = %d%n", i, y, i * y);
                }
            }
        } else if (tabla1 < tabla2) {

            for (int i = tabla1; i <= tabla2; i++) {
                System.out.println("\n------ Tabla del "+i+" ------\n");
                for (int y = 0; y <= 10; y++) {
                    System.out.printf("       %d * %d = %d%n", i, y, i * y);
                }
            }
        } else {
            System.out.println("\n------ Tabla del "+tabla1+" ------\n");
            for (int y = 0; y <= 10; y++) {
                System.out.printf("       %d * %d = %d%n", tabla1, y, tabla1 * y);
            }
        }
    }
    public void ejSw1(){
        System.out.print("Introduce un numero (1-7): ");
        int dia = s.nextInt();
        String diaNombre = "dia no valido";
        /*switch (dia){
            case 1:
                diaNombre = "Lunes";
            break;
            case 2:
                diaNombre = "Martes";
            break;
            case 3:
                diaNombre = "Miercoles";
            break;
            case 4:
                diaNombre = "Jueves";
            break;
            case 5:
                diaNombre = "Viernes";
            break;
            case 6:
                diaNombre = "Sábado";
            break;
            case 7:
                diaNombre = "Domingo";
            break;
        }*/
        switch (dia){
            case 1 -> diaNombre="lunes";
            case 2 -> diaNombre="martes";
            case 3 -> diaNombre="miércoles";
            case 4 -> diaNombre="jueves";
            case 5 -> diaNombre="viernes";
            case 6 -> diaNombre="sábado";
            case 7 -> diaNombre="domingo";
        }
        System.out.println("El dia "+dia+" es "+diaNombre+".");
    }
    public void ejSw2(){
        System.out.print("Introduce tu nota (A-F): ");
        String nota = s.next();
        String notaNombre = "Nota no valida";
        switch (nota.toLowerCase()){
            case "a" -> notaNombre="Excelente";
            case "b" -> notaNombre="Muy bien";
            case "c" -> notaNombre="Bien";
            case "d" -> notaNombre="Suficiente";
            case "f" -> notaNombre="Insuficiente";
            default -> {
                System.out.println("Calificación no valida");
            return;}
        }
        System.out.println("Tu nota es "+nota+", has sacado un "+notaNombre+".");
    }
    public void ejSw3(){
        System.out.print("Introduce el primer número: ");
        int num1 = s.nextInt();
        System.out.print("Introduce el segundo número: ");
        int num2 = s.nextInt();
        System.out.print("introduce el operador: ");
        String operador = s.next();
        switch (operador){
            case "+" -> System.out.println("El resultado es: "+(num1+num2));
            case "-" -> System.out.println("El resultado es: "+(num1-num2));
            case "*" -> System.out.println("El resultado es: "+(num1*num2));
            case "/" -> System.out.println("El resultado es: "+((double)num1/num2));
            default -> System.out.println("operador no valido.");
        }
    }
    public void ejSw4(){
        System.out.printf("""
                --- MENÚ ---
                1. Ver perfil
                2. Configuración
                3. Ayuda
                4. Salir%n
                """);
        System.out.print("Elige una opción: ");
        int opt = s.nextInt();
        switch (opt){
            case 1 -> System.out.println("Has seleccionado: Ver perfil.");
            case 2 -> System.out.println("Has seleccionado: Configuración.");
            case 3 -> System.out.println("Has seleccionado: Ayuda.");
            case 4 -> System.out.println("Has seleccionado: Salir.");
            default -> System.out.println("Selección no valida.");
        }
    }
    public void ejSw5(){
        System.out.print("Introduce el numero del mes: ");
        int mes = s.nextInt();
        switch (mes){
            case 12,1,2 -> System.out.println("El mes "+mes+" corresponde a: Invierno");
            case 3,4,5 -> System.out.println("El mes "+mes+" corresponde a: Primavera");
            case 6,7,8 -> System.out.println("El mes "+mes+" corresponde a: Verano");
            case 9,10,11 -> System.out.println("El mes "+mes+" corresponde a: Otoño");
            default -> System.out.println("El mes que has elegido no es valido");
        }
    }
    public void ejSw6(){
        System.out.print("Introduce un número del 1 al 10: ");
        int tabla = s.nextInt();
        switch (tabla){
            case 1,2,3,4,5,6,7,8,9,10 ->{
                System.out.println("------Tabla del "+tabla+"------\n");
                for (int i = 0; i <= 10; i++) {
                    System.out.printf("       %d * %d = %d%n", tabla, i, i * i);
                }
            }
            default -> System.out.println("Has elegido un numero no valido");
        }/*
        System.out.print("Introduce un número del 1 al 10: ");
        int tabla = s.nextInt();
            if (tabla>0&&tabla<=10){
                System.out.println("------Tabla del "+tabla+"------\n");
                for (int i = 0; i <= 10; i++) {
                    System.out.printf("       %d * %d = %d%n", tabla, i, i * i);
                }
            } else {
            System.out.println("Has elegido un numero no valido");
        }*/
    }
    public void ejSw7(){
        System.out.print("Introduce un número: ");
        int num = s.nextInt(), resultado = 0;
        System.out.print("Sumando: ");
        for (int i = 1; i <= num; i++) {
            switch (i) {
                case 1 -> System.out.print(i);
                default -> System.out.print(" + " + i);
            }
            resultado += i;
        }
        System.out.println("\nLa suma de los números del 1 al "+num+" es: "+resultado+". (Dani pesaaaaaao)");
    }
    public void ejSw8(){
        System.out.print("Introduce un número: ");
        int numero = s.nextInt();
        int par = 0, impar = 0;
        for (int i = 1; i <=numero; i++) {
            if ((i%2)==0){
                par++;
            }else {
                impar++;
            }
        }
        System.out.printf("""
                \nRecorriendo números del 1 al %d...
                Números pares encontrados: %d.
                Números impares encontrados: %d.             
                """,numero, par, impar
                );
    }
    public void ejSw9(){
        System.out.print("Introduce un numero positivo: ");
        int num = s.nextInt();
        BigInteger calculo = BigInteger.valueOf(num);
        String factorial = String.valueOf(num);
        System.out.printf("Calculando %d!",num);
        for (int i = num; i > 0 ; i--) {
            if (i!=num){
                calculo=calculo.multiply(BigInteger.valueOf(i));
                factorial +=" x "+i;
            }
        }
        System.out.println("\n"+factorial);
        System.out.println("El factorial de "+num+" es: "+calculo);
    }
    public void ejSw10(){
        System.out.printf("""
                --- EJERCICIOS ---
                  1. Flexiones.
                  2. Abdominales.
                  3. Sentadillas.\n
                """);
        System.out.print("Elije un ejercicio (1-3): ");
        int ej = s.nextInt();
        String ejercicio = "ejercicio no valido";
        switch (ej){
            case 1 -> ejercicio = " Flexiones ";
            case 2 -> ejercicio = " Flexiones ";
            case 3 -> ejercicio = " Flexiones ";
            default -> {System.out.println("Has elegido un "+ejercicio); return;}
        }
        System.out.print("\n¿Cuantas repeticiones ");
        int rep = s.nextInt();
        System.out.println("");
        for (int i = 1; i <= rep; i++) {
            if (i==1){
                System.out.println("Has elegido:"+ejercicio+"\nRepetición "+i+" completada.");
            }else {
                System.out.println("Repetición "+i+" completada.");
            }
        }
        System.out.printf("¡Ejercicio completado! Has hecho %d%s", rep, ejercicio);
    }
    public void ejDw1(){
        System.out.print("Indica un numero hasta el que quieras contar: ");
        int num = s.nextInt(), contador = 1;
        while(contador<=num){
            System.out.println(contador);
            contador++;
        }
        System.out.println("Fin del conteo.");
    }
    public void ejDw2(){
        String contrasenia = "1234",contraseniaIntento;
        do {
            System.out.print("Introduce tu contraseña: ");
            contraseniaIntento = s.next();
            if (!contrasenia.equals(contraseniaIntento)){
                System.out.println("Contraseña incorrecta. Intentelo de nuevo.");
            }
        }while (!contrasenia.equals(contraseniaIntento));
        System.out.println("Contraseña correcta, acceso permitido.");
    }
    public void ejDw3(){
        System.out.print("Introduce un numero (para terminar el programa introduce 0 o negativo): ");
        int num = s.nextInt(), suma = 0;
        while (num>0){
            suma = num+suma;
            System.out.println("Suma actual: "+suma);
            System.out.print("Introduce un numero (para terminar el programa introduce 0 o negativo): ");
            num = s.nextInt();
        }
        System.out.println("Fin del programa, el resultado es : "+suma);
    }
    public void ejDw4(){
        int min = 1, max = 10, numSecreto = (int) (Math.random()* (max - min + 1)) + min, numIntento, intentos = 0;
        System.out.print("Intenta adivinar un numero del 1 al 10: ");
        numIntento = s.nextInt(); intentos++;
        do {
            if (numIntento>numSecreto){
                System.out.print("El número es mayor que tu objetivo. Intentalo de nuevo: ");
                numIntento = s.nextInt(); intentos++;
            } else if (numIntento<numSecreto) {
                System.out.print("El numero es menor que tu objetivo. Intentalo de nuevo: ");
                numIntento = s.nextInt(); intentos++;
            }
        }while (numSecreto!=numIntento);
        System.out.println("¡Correcto! Has adivinado el numero en "+ intentos+" intentos.");
    }
    public void ejDw5(){
        int opcion;
        LocalTime hora = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        do {
            System.out.printf("---- MENÚ ----%n1. Saludar%n2. Despedirse%n3. Ver hora%n4. Salir%n");
            opcion = s.nextInt();
            switch (opcion){
                case 1 -> System.out.println("Hola, ¿Como estas?");
                case 2 -> System.out.println("¡¡No te despidas aun!!");
                case 3 -> {
                    String horaFormateada = hora.format(formato);
                    System.out.println("Son las "+horaFormateada+".");
                }
                case 4 -> System.out.println("¡hasta luego!");
                default -> System.out.println("Opción no valida.");
            }
        }while (opcion!=4);
    }
    public void ejDw6(){
        System.out.print("Introduce un número para hacer una cuenta regresiva: ");
        int num = s.nextInt();
        System.out.println("Cuenta atras:");
            while (num>0){
                System.out.println(num);
                num--;
            }
            System.out.println("¡Despegue!");
    }
    public void ejDw7(){
        System.out.print("¿Cuantas calificaciones vas a introducir? ");
        int cMedia = s.nextInt(), cantidad = 1;
        double nota=0;
        while (cantidad<=cMedia){
            System.out.printf("Introduce la calificación %d: ",cantidad);
            nota += s.nextDouble();
            cantidad++;
        }
        System.out.printf("Suma total: %.1f%nPromedio calificaciones: %.2f",nota,nota/cMedia);
    }
    public void ejDw8(){
        System.out.print("Introduce tu edad: ");
        int edad = s.nextInt();
        do {
            if (edad<0||edad>120){
                System.out.print("edad no valida, debe estar entre 0 y 120\nIntroduce tu edad: ");
                edad = s.nextInt();
            }
        }while (edad<0||edad>120);
        System.out.printf("Edad válida: %d años. ¡Gracias!",edad);
    }
    public void ejDw9(){
        System.out.print("¿Cuantos estudiantes hay?: ");
        int nEstudiante = s.nextInt(), estudiante = 0;
        String calificacion = "F";
        int[] nota = new int[nEstudiante];
        while (estudiante<nEstudiante){
            System.out.printf("Introduce la nota del estudiante %d (0-10): ",estudiante);
            nota[estudiante] = s.nextInt();
            estudiante++;
        }
        System.out.println("--------------CALIFICACIONES--------------");
        for (int i = 0; i <nEstudiante; i++){
            switch (nota[i]){
                case 1,2 -> calificacion = "F";
                case 3,4 -> calificacion = "D";
                case 5,6 -> calificacion = "C";
                case 7,8 -> calificacion = "B";
                case 9,10 -> calificacion = "A";
            }
            System.out.printf("Estudiante %d: %d puntos = Calificación: %s%n",i+1,nota[i],calificacion);
        }
    }
    public void ejDw10(){
        int saldo = 1000,opcion,modificacion;
        System.out.printf("--- CAJERO AUTOMÁTICO ---%nSaldo Inicial: %d€",saldo);
        do {
            System.out.printf("%n--- Menu ---%n1. Consultar saldo%n2. Retirar dinero%n3. Depositar dinero%n4. Salir%n");
            opcion = s.nextInt();
            switch (opcion){
                case 1 -> System.out.print("Tu saldo actual es: "+saldo);
                case 2 -> {
                    System.out.print("¿Cuánto deseas retirar?: ");
                    modificacion = s.nextInt();
                    while (saldo<modificacion){
                        System.out.print("El saldo no es suficiente, ¿Cuánto deseas retirar?: ");
                        modificacion = s.nextInt();
                    }
                    saldo -= modificacion;
                    System.out.println("Tras la retirada, tu saldo es de "+saldo+"€");
                }
                case 3 -> {
                    System.out.print("¿Cuánto deseas ingresar?: ");
                    modificacion = s.nextInt();
                    saldo += modificacion;
                    System.out.printf("Depósito exitoso. Has depositado: %d€%nNuevo saldo: %d€",modificacion,saldo);
                }
            }
        }while (opcion>0&&opcion<4);
        System.out.println("Gracias por usar el cajero. ¡Hasta luego!");
    }
    public void scannerClose(){
        s.close();
    }
}
