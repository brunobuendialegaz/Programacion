package metodos;

import com.sun.jdi.Value;
import enums.Archivos;
import enums.CategoriaPlato;
import enums.HorasDia;
import enums.Moneda;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Locale;
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

    public int horaActual(){
        LocalTime ahora = LocalTime.now();
        int ahoraH = ahora.getHour();
        return ahoraH;
    }

}
