package Metodos;

import java.util.Scanner;

public class Metodo {
    public void ejercicio1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el primer número");
        int op1 = scanner.nextInt();
        System.out.println("Introduce el segundo número");
        int op2 = scanner.nextInt();
        int suma = op1+op2;
        int resta = op1-op2;
        int multiplicacion = op1*op2;
        int division = op1/op2;
        int resto = op1%op2;
        System.out.printf("Suma: %d\n" +
                        "Resta: %d\n" +
                        "Multiplicación: %d\n" +
                        "División: %d\n" +
                        "Resto: %d\n",
                suma,
                resta,
                multiplicacion,
                division,
                resto);
        scanner.close();
    }
    public void ejercicio2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el primer número:");
        int op1 = scanner.nextInt();
        System.out.println("Introduce el segundo número:");
        int op2 = scanner.nextInt();
        boolean mayor = op1>op2;
        boolean menor = op1<op2;
        boolean igual = op1==op2;
        boolean diferente = op1!=op2;
        boolean mayorIgual = op1>=op2;
        boolean menorIgual = op1<=op2;
        System.out.printf("¿%d es mayor que %d?: %b%n" + //puedo concatenar texto con +, pero despues deben ir todas las variables seguidas con comas
                "¿%d es menor que %d?: %b%n"+
                "¿%d es igual a %d?: %b%n"+
                "¿%d es diferente a %d?: %b%n"+
                "¿%d es mayor o igual a %d? %b%n"+
                "¿%d es menor o igual a %d?: %b",
                op1,op2,mayor,
                op1,op2,menor,
                op1,op2,igual,
                op1,op2,diferente,
                op1,op2,mayorIgual,
                op1,op2,menorIgual);
        scanner.close();
    }
    public void ejercicio3(){
    int valorInicial = 100;
        System.out.println("Valor inicial: "+valorInicial);
    valorInicial +=50;
        System.out.println("Después de sumar (+=): "+valorInicial);
    valorInicial -=30;
        System.out.println("Después de restar (-=): "+valorInicial);
    valorInicial *=2;
        System.out.println("Después de multiplicar (+=): "+valorInicial);
    valorInicial /=4;
        System.out.println("Después de dividir (+=): "+valorInicial);
    }
    public void ejercicio4(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int op1 = scanner.nextInt();
        int resto = op1%2;
        String parImpar;
        if (resto==0){
            parImpar = "par";
        }
        else {
            parImpar = "impar";
        }
        System.out.println("El número "+op1+" es "+parImpar+" (resto al dividir entre 2: "+resto+")");
        scanner.close();
    }
    public void ejercicio5(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce tu edad:");
        int edad = scanner.nextInt();
        System.out.println("¿Tienes carnet de conducir?");
        boolean carnet = scanner.nextBoolean();
        boolean mayor = edad>=21;
        boolean aptoAlquilar = mayor && carnet;
        System.out.println("¿Eres mayor de 21 años?: "+mayor);
        System.out.println("¿Tienes carnet?: "+carnet);
        System.out.println("¿Puedes alquilar un coche?: "+aptoAlquilar);
        scanner.close();
    }
    public void ejercicio6(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el precio del producto:");
        double precio = scanner.nextDouble();
        System.out.println("Introduce el porcentaje de descuento:");
        int descuento = scanner.nextInt();
        double descontado = precio/100*descuento;
        double precioFinal = precio-descontado;
        System.out.printf("Precio original %.1f €%n",precio);
        System.out.println("Descuento ("+descuento+"%): "+descontado+"€");
        System.out.printf("Precio final: %.2f €", precioFinal);
        scanner.close();
    }
    public void ejercicio7(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce tu edad: ");
        int edad = scanner.nextInt();
        System.out.println("¿Eres estudiante? (true/false)");
        boolean estudiante = scanner.nextBoolean();
        boolean menor = edad<26;
        System.out.println("¿Eres menor de 26 años?: "+menor);
        System.out.println("¿Eres estudiante?: "+estudiante);
        System.out.println("¿NO eres estudiante?: "+!estudiante);
        boolean descuentoEsp = estudiante && menor;
        System.out.println("¿Tienes descuento joven?: "+menor);
        System.out.println("¿Tienes descuento estudiante?: "+estudiante);
        System.out.println("¿Tienes descuento especial?: "+descuentoEsp);

        scanner.close();
    }
    public void ejercicio8(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el primer número:");
        int op1 = scanner.nextInt();
        System.out.println("Introduce el segundo número:");
        int op2 = scanner.nextInt();
        System.out.println("Introduce el tercer número:");
        int op3 = scanner.nextInt();
        int suma = op1+op2+op3;
        double promedio = ((double)op1+op2+op3)/3;
        double operacion = ((double) op1*op2)/op3;
        System.out.println("Suma de los tres números: "+suma);
        System.out.println("Promedio: "+promedio);
        System.out.println("Resultado de (número1 * número2) / número3: "+operacion);
        scanner.close();
    }
    public void ejercicio9(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la nota del primer examen:");
        int nota1 = scanner.nextInt();
        System.out.println("Introduce la nota del segundo examen:");
        int nota2 = scanner.nextInt();
        System.out.println("Introduce la nota del tercer examen:");
        int nota3 = scanner.nextInt();
        double media = ((double)nota1+nota2+nota3)/3;
        System.out.println("Nota media: "+media);
        boolean aprobado = media>=5;
        boolean notable = media>=7 && media<9;
        boolean sobresaliente = media>=9;
        System.out.println("¿Ha aprobado? "+aprobado);
        System.out.println("¿Tiene notable? "+notable);
        System.out.println("¿Tiene sobresaliente? "+sobresaliente);
        scanner.close();
    }
    public void ejercicio10(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el salario por hora:");
        int salario = scanner.nextInt();
        System.out.println("Introduce las horas trabajadas:");
        int horas = scanner.nextInt();
        boolean horasExtra = horas > 40;
        System.out.println("¿Has hecho horas extra?"+horasExtra);
        int horasNormales;
        if (horas>40) {horasNormales = 40;}
        else{horasNormales=horas;}
        System.out.println("Horas normales (Máximo 40): "+horasNormales);
        int cantidadHorasEx = horas - horasNormales;
        System.out.println("Horas extra: "+cantidadHorasEx);
        boolean extrasB = cantidadHorasEx != 0;
        System.out.println("¿Trabajaste más de 40 horas?: "+extrasB);
        System.out.println("¿Tienes derecho a horas extra?: "+extrasB);
        boolean extrasPermitido = horas>40 && horasExtra;
        System.out.println("¿Se aplican horas extra? (>40 AND permitido): "+extrasPermitido);
        int salarioNormal = horasNormales*salario;
        System.out.println("Salario por horas normales: "+salarioNormal+"€");
        int salarioExtra = cantidadHorasEx*(salario*2);
        System.out.println("Salario por horas extra (al doble): "+salarioExtra+"€");
        int salarioTotal = salarioNormal+salarioExtra;
        System.out.println("Salario total: "+salarioTotal+"€");

        scanner.close();
    }







/*
    package Metodos;

import java.util.Scanner;

    public class Metodo {
        // Clase principal para lección de operadores.

        public void ejercicio1(){
            // Operadores Aritméticos: +, -, *, /, %.
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce el primer número");
            int op1 = scanner.nextInt();
            System.out.println("Introduce el segundo número");
            int op2 = scanner.nextInt();
            int suma = op1+op2;             // Suma.
            int resta = op1-op2;            // Resta.
            int multiplicacion = op1*op2;   // Multiplicación.
            int division = op1/op2;         // División.
            int resto = op1%op2;            // Módulo (Resto).
            System.out.printf("Suma: %d\n" +
                            "Resta: %d\n" +
                            "Multiplicación: %d\n" +
                            "División: %d\n" +
                            "Resto: %d\n",
                    suma,
                    resta,
                    multiplicacion,
                    division,
                    resto);
            scanner.close();
        }
        public void ejercicio2(){
            // Operadores Relacionales: >, <, ==, !=, >=, <=.
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce el primer número:");
            int op1 = scanner.nextInt();
            System.out.println("Introduce el segundo número:");
            int op2 = scanner.nextInt();
            boolean mayor = op1>op2;        // Mayor que (>).
            boolean menor = op1<op2;        // Menor que (<).
            boolean igual = op1==op2;       // Igual a (==).
            boolean diferente = op1!=op2;   // Diferente a (!=).
            boolean mayorIgual = op1>=op2;  // Mayor o igual (>=).
            boolean menorIgual = op1<=op2;  // Menor o igual (<=).
            System.out.printf("¿%d es mayor que %d?: %b%n" + //puedo concatenar texto con +, pero despues deben ir todas las variables seguidas con comas
                            "¿%d es menor que %d?: %b%n"+
                            "¿%d es igual a %d?: %b%n"+
                            "¿%d es diferente a %d?: %b%n"+
                            "¿%d es mayor o igual a %d? %b%n"+
                            "¿%d es menor o igual a %d?: %b",
                    op1,op2,mayor,
                    op1,op2,menor,
                    op1,op2,igual,
                    op1,op2,diferente,
                    op1,op2,mayorIgual,
                    op1,op2,menorIgual);
            scanner.close();
        }
        public void ejercicio3(){
            // Operadores de Asignación Compuesta: +=, -=, *=, /=.
            int valorInicial = 100;
            System.out.println("Valor inicial: "+valorInicial);
            valorInicial +=50;      // Asigna valorInicial = valorInicial + 50.
            System.out.println("Después de sumar (+=): "+valorInicial);
            valorInicial -=30;      // Asigna valorInicial = valorInicial - 30.
            System.out.println("Después de restar (-=): "+valorInicial);
            valorInicial *=2;       // Asigna valorInicial = valorInicial * 2.
            System.out.println("Después de multiplicar (+=): "+valorInicial);
            valorInicial /=4;       // Asigna valorInicial = valorInicial / 4.
            System.out.println("Después de dividir (+=): "+valorInicial);
        }
        public void ejercicio4(){
            // Uso del Módulo (%) para Par/Impar.
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce un número: ");
            int op1 = scanner.nextInt();
            int resto = op1%2;      // Módulo: Comprueba divisibilidad por 2.
            String parImpar;
            if (resto==0){
                parImpar = "par";
            }
            else {
                parImpar = "impar";
            }
            System.out.println("El número "+op1+" es "+parImpar+" (resto al dividir entre 2: "+resto+")");
            scanner.close();
        }
        public void ejercicio5(){
            // Operador Lógico AND (&&).
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce tu edad:");
            int edad = scanner.nextInt();
            System.out.println("¿Tienes carnet de conducir?");
            boolean carnet = scanner.nextBoolean();
            boolean mayor = edad>=21;
            boolean aptoAlquilar = mayor && carnet; // AND (&&): True solo si ambas son True.
            System.out.println("¿Eres mayor de 21 años?: "+mayor);
            System.out.println("¿Tienes carnet?: "+carnet);
            System.out.println("¿Puedes alquilar un coche?: "+aptoAlquilar);
            scanner.close();
        }
        public void ejercicio6(){
            // Operaciones aritméticas con tipos double/int.
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce el precio del producto:");
            double precio = scanner.nextDouble();
            System.out.println("Introduce el porcentaje de descuento:");
            int descuento = scanner.nextInt();
            double descontado = precio/100*descuento; // Cálculo de porcentaje.
            double precioFinal = precio-descontado;
            System.out.printf("Precio original %.1f €%n",precio);
            System.out.println("Descuento ("+descuento+"%): "+descontado+"€");
            System.out.printf("Precio final: %.2f €", precioFinal);
            scanner.close();
        }
        public void ejercicio7(){
            // Operadores Lógicos AND (&&) y NOT (!).
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce tu edad: ");
            int edad = scanner.nextInt();
            System.out.println("¿Eres estudiante? (true/false)");
            boolean estudiante = scanner.nextBoolean();
            boolean menor = edad<26;
            System.out.println("¿Eres menor de 26 años?: "+menor);
            System.out.println("¿Eres estudiante?: "+estudiante);
            boolean estudianteDiferente = !estudiante; // NOT (!): Niega la condición.
            System.out.println("¿NO eres estudiante?: "+estudianteDiferente);
            boolean descuentoEsp = estudiante && menor; // AND (&&) usado en la lógica original.
            System.out.println("¿Tienes descuento joven?: "+menor);
            System.out.println("¿Tienes descuento estudiante?: "+estudiante);
            System.out.println("¿Tienes descuento especial?: "+descuentoEsp);

            scanner.close();
        }
        public void ejercicio8(){
            // Promedio y Casting (Conversión de tipos) explícita.
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce el primer número:");
            int op1 = scanner.nextInt();
            System.out.println("Introduce el segundo número:");
            int op2 = scanner.nextInt();
            System.out.println("Introduce el tercer número:");
            int op3 = scanner.nextInt();
            int suma = op1+op2+op3;
            double promedio = ((double)op1+op2+op3)/3; // Casting a double para decimales.
            double operacion = ((double) op1*op2)/op3;
            System.out.println("Suma de los tres números: "+suma);
            System.out.println("Promedio: "+promedio);
            System.out.println("Resultado de (número1 * número2) / número3: "+operacion);
            scanner.close();
        }
        public void ejercicio9(){
            // Lógica AND (&&) para evaluar rangos de notas.
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce la nota del primer examen:");
            int nota1 = scanner.nextInt();
            System.out.println("Introduce la nota del segundo examen:");
            int nota2 = scanner.nextInt();
            System.out.println("Introduce la nota del tercer examen:");
            int nota3 = scanner.nextInt();
            double media = ((double)nota1+nota2+nota3)/3;
            System.out.println("Nota media: "+media);
            boolean aprobado = media>=5;
            boolean notable = media>=7 && media<9;      // AND (&&) para verificar rango.
            boolean sobresaliente = media>=9;
            System.out.println("¿Ha aprobado? "+aprobado);
            System.out.println("¿Tiene notable? "+notable);
            System.out.println("¿Tiene sobresaliente? "+sobresaliente);
            scanner.close();
        }

    }*/

}
