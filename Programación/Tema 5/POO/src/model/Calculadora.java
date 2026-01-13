package model;

public class Calculadora {

    public static String suma (int num1, int num2){
        return "Suma: " + num1 + " + " + num2 + " = " + (num1+num2);
    }
    public static String resta (int num1, int num2){
        return "Resta: " + num1 + " - " + num2 + " = " + (num1-num2);
    }
    public static String multiplicacion (int num1, int num2){
        return "Multiplicación: " + num1 + " * " + num2 + " = " + (num1*num2);
    }
    public static String division (int num1, int num2){
        return "División: " + num1 + " / " + num2 + " = " + ((double)num1/num2);
    }
    public static String potencia (int num1, int num2){
        int num1Origen = num1;
        for (int i = 0; i < num2-1; i++) {
            num1 *= num1Origen;
        }
        return "Potencia: " + num1Origen + " ^ " + num2 + " = " + ((double)num1);
    }


}
