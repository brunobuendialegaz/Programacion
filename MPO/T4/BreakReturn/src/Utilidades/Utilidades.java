package Utilidades;

import java.util.Objects;
import java.util.Scanner;

public class Utilidades {
    Scanner s = new Scanner(System.in);

    public boolean validarContrasena(String contrasenia){
        if(contrasenia.length()<8){
            System.out.println("Contraseña mas corta de 8 caracteres");
            return false;
        }
        if (contrasenia.equals(contrasenia.toLowerCase())){
            System.out.println("Contraseña sin caracteres en mayuscula");
            return false;
        }
        if (contrasenia.matches(".*(0-9).*")){
            System.out.println("Contraseña sin numeros");
            return false;
        }
        System.out.println("Contraseña valida");
        return true;
    }

    public int buscarNumero(int[] numeros, int objetivo){

        int lugar = -1;
        for (int i = 0; i < numeros.length; i++){
            if (numeros[i]==objetivo){
                lugar = i;
                break;
            }
        }
        return lugar;
    }

    public void mostrarPares(int[] numeros){
        for (int i = 0; i < numeros.length; i++){
            if (numeros[i]%2!=0){
                continue;
            }
            System.out.println(numeros[i]);
        }

    }

    public double calcularPromedio(double[] notas){
        double total = 0;
        int notasValidas = 0;
        for (int i = 0; i < notas.length; i++){
            if (notas[i]>10||notas[i]<0){
                continue;
            }
            total+=notas[i];
            notasValidas++;
        }
        return (total/notasValidas);
    }

    public boolean intentarLogin(String usuarioCorrecto, String passwordCorrecta){
        String usuario = "", contraseña = "";
        while(!usuario.equals(usuarioCorrecto)){
            System.out.printf("Introduce un usuario registrado: ");
            usuario = s.nextLine();
            if (usuario.equals(usuarioCorrecto)){
                for (int i = 0; i < 3; i++){
                    System.out.println("Intentos: "+i);
                    System.out.print("Introduce la contraseña: ");
                    contraseña = s.nextLine();
                    if (contraseña.equals(passwordCorrecta)){
                        return true;
                    }
                }
                System.out.println("Contraseña incorrecta, 3 intentos, usuario bloqueado.");
            }
        }

        return false;
    }

}
