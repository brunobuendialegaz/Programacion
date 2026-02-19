package model;

public class Cuenta {
    private String titular;
    private double saldo;

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cuenta (){

    }

    public Cuenta(String titular, double saldo){
        this.titular = titular;
        this.saldo = saldo;
    }

    public void mostrarDatos(){
        System.out.println("titular = " + titular);
        System.out.println("saldo = " + saldo);
    }
}