package model;

public class CuentaBancaria {

    private String titular;
    private double saldo;

    public CuentaBancaria(){}

    public CuentaBancaria(String titular, double saldo){
        this.titular = titular;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void depositar(double cantidad){
        if (cantidad<0){
            System.out.println("No se ha podido depositar, cantidad incorrecta");
        }else {
            setSaldo(saldo+cantidad);
            System.out.println("Saldo tras el ingreso "+getSaldo()+"€");
        }
    }

    public void retirar(double cantidad){
        if (cantidad<0){
            System.out.println("No se ha podido retirar, cantidad incorrecta.");
        } else if (cantidad>saldo) {
            System.out.println("No se puede retirar, saldo insuficiente.");
        }else {
            setSaldo(saldo-cantidad);
            System.out.println("Retirados "+cantidad+"€, saldo restante: "+getSaldo()+"€");
        }
    }
}
