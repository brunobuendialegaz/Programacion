package metodos;

import com.sun.jdi.Value;
import enums.*;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Metodos {
    Scanner s = new Scanner(System.in);
    public void ejSwMpo1(){
        double calificacion = 7.85;
        char calChar;

        switch (calificacion){
            case double n when n>=0 && n<4 -> {
                calChar = 'F';
            }
            case double n when n>=4 && n<5 -> {
                calChar = 'D';
            }
            case double n when n>=5 && n<7 -> {
                calChar = 'C';
            }
            case double n when n>=7 && n<9 -> {
                calChar = 'B';
            }
            case double n when n>=9 && n<=10 -> {
                calChar = 'A';
            }
            default -> {calChar = '?';}
        }
        System.out.println("Tu nota es "+calificacion+" corresponde a una calificación "+calChar);
    }
    public void ejSwMpo2(){
        double euros = 10;
        Moneda moneda = Moneda.DOLAR;

        switch (moneda){
            case DOLAR -> {
                System.out.printf("Tienes %.2f€ y esto corresponde a %.2f Dolares",euros,euros*Moneda.DOLAR.getValorConversion());
            }
            case LIBRA -> {
                System.out.printf("Tienes %.2f€ y esto corresponde a %.2f Libras",euros,euros*Moneda.LIBRA.getValorConversion());
            }
            case YEN -> {
                System.out.printf("Tienes %.2f€ y esto corresponde a %.2f Yens",euros,euros*Moneda.YEN.getValorConversion());
            }
            case PESO -> {
                System.out.printf("Tienes %.2f€ y esto corresponde a %.2f Pesos",euros,euros*Moneda.PESO.getValorConversion());
            }
            default -> System.out.println("valor no soportado");
        }
    }
    public void ejSwMpo3(){
        int temperatura = 35;
        switch (temperatura){
            case int n when n<0 -> {
                System.out.println("El tiempo esta helado");
            }
            case int n when n<15 -> {
                System.out.println("Hace frio");
            }
            case int n when n<25 -> {
                System.out.println("El tiempo es templado");
            }
            case int n when n<35 -> {
                System.out.println("Hace calor");
            }
            case int n when n>=35 -> {
                System.out.println("Hay calor extremo");
            }
            default -> System.out.println("Valor no contemplado.");
        }
    }
    public void ejSwMpo4(){
        CategoriaPlato platos = CategoriaPlato.PRINCIPAL;
        switch (platos) {
            case ENTRADA -> System.out.println("Las entradas que tenemos son: "+Arrays.toString(platos.getPlato()));
            case PRINCIPAL -> System.out.println("Los platos principales que tenemos son: "+Arrays.toString(platos.getPlato()));
            case POSTRE -> System.out.println("Los postres que tenemos son: "+Arrays.toString(platos.getPlato()));
            case BEBIDA -> System.out.println("Las bebidas que tenemos son: "+Arrays.toString(platos.getPlato()));
        }
    }
    public void ejSwMpo5(){
        double num1 = 10, num2 = 5;
        char operador = '/';
        switch (operador) {
            case '+' -> {
                System.out.println("El resultado de la suma es: " + (num1 + num2));
            }
            case '-' -> {
                System.out.println("El resultado de la resta es: " + (num1 - num2));
            }
            case '*' -> {
                System.out.println("El resultado de la multiplicación es: " + (num1 * num2));
            }
            case '/' -> {
                if (num2 == 0) {
                    System.out.println("el valor de la división es indeterminado");
                } else {
                    System.out.println("El resultado de la división es: " + (num1 / num2));
                }
            }
        }
    }
    public void ejSwMpo6(){

        int hora = horaActual();
        HorasDia horasEnum = HorasDia.getFranja(hora);
        switch (horasEnum){
            case MADRUGADA -> {
                System.out.println("Feliz madrugada!!");
            }
            case MANIANA -> {
                System.out.println("Buenos dias!!");
            }
            case TARDE -> {
                System.out.println("Buenas tardes!!");
            }
            case NOCHE -> {
                System.out.println("Buenas noches!!");
            }
        }
        System.out.printf("son las %d de la %s!!",hora, horasEnum.toString());
    }
    public void ejSwMpo7(){
        ClasificacionJugador jugador = ClasificacionJugador.valueOf(ClasificacionJugador.getClasificacionJugador(50));
        switch (jugador){
            case PRINCIPIANTE -> System.out.printf("Tu premio es: %s por que eres un %s.", jugador.getPremio(),jugador.toString().toLowerCase());
            case INTERMEDIO -> System.out.printf("Tu premio es: %s por que eres un %s.", jugador.getPremio(),jugador.toString().toLowerCase());
            case AVANZADO -> System.out.printf("Tu premio es: %s por que eres un %s.", jugador.getPremio(),jugador.toString().toLowerCase());
            case EXPERTO -> System.out.printf("Tu premio es: %s por que eres un %s.", jugador.getPremio(),jugador.toString().toLowerCase());
            case MAESTRO -> System.out.printf("Tu premio es: %s por que eres un %s.", jugador.getPremio(),jugador.toString().toLowerCase());
        }
    }
    public void ejSwMpo8(){
        String extension = "jpg";
        Archivos tipoArchivo = Archivos.getPorExtension(extension);
        /*switch (tipoArchivo){
            case IMAGENES -> {
                System.out.printf("El archivo es %s y se puede abrir con %s.",extension,tipoArchivo.getPrograma());
            }
            case DOCUMENTOS -> {
                System.out.printf("El archivo es %s y se puede abrir con %s.",extension,tipoArchivo.getPrograma());
            }
            case AUDIO -> {
                System.out.printf("El archivo es %s y se puede abrir con %s.",extension,tipoArchivo.getPrograma());
            }
            case VIDEO -> {
                System.out.printf("El archivo es %s y se puede abrir con %s.",extension,tipoArchivo.getPrograma());
            }
        }*/
        System.out.printf("El archivo es %s y se puede abrir con %s.",extension,tipoArchivo.getPrograma());
    }
    public void ejSwMpo9(){
        double peso = 85.9;
        double altura = 1.90;
        double imc = peso/(altura*altura);
        switch (imc){
            case double n when n<18.5 -> {
                System.out.printf("Tu imc es de %.2f por tanto estas bajo peso.", imc);
            }
            case double n when n<25 -> {
                System.out.printf("Tu imc es de %.2f por tanto tienes un imc normal.", imc);
            }
            case double n when n<30 -> {
                System.out.printf("Tu imc es de %.2f por tanto tienes sobrepeso.", imc);
            }
            case double n when n>=30 -> {
                System.out.printf("Tu imc es de %.2f por tanto tienes obesidad.", imc);
            }
            default -> System.out.println("valor fuera de los parametros...");
        }
    }
    public void ejSwMpo10(){
        Random r = new Random();
        int estadoPedido = r.nextInt(6)+1;
        EstadoEnvio estadoEnum = EstadoEnvio.valueOf(EstadoEnvio.getNombreEstado(estadoPedido));
        System.out.println("El estado de tu pedido es "+estadoEnum.toString().toLowerCase()+".");
    }
    public int horaActual(){
        LocalTime ahora = LocalTime.now();
        int ahoraH = ahora.getHour();
        return ahoraH;
    }

}
