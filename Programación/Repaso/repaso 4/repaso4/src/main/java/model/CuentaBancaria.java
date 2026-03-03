package model;

public class CuentaBancaria {

    private String titular, numeroCuenta;
    private double saldo;

    public CuentaBancaria(String titular, String numeroCuenta) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
    }

    public CuentaBancaria() {
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingresar(double cantidad){
        if (cantidad>0) setSaldo(saldo+cantidad);
    }

    public boolean retirar (double cantidad){
        boolean operacionPosible = cantidad>0 && cantidad<=saldo;
        if (operacionPosible){
            saldo = saldo - cantidad;
            return true;
        }
        return false;
    }

    public void transferir(CuentaBancaria destino, double cantidad){
        if (cantidad<=saldo){
            saldo = saldo - cantidad;
            destino.ingresar(cantidad);
        }
    }

    public void mostrarInfo(){
        System.out.println("titular = " + titular);
        System.out.println("numeroCuenta = " + numeroCuenta);
        System.out.println("saldo = " + saldo);
    }


}
