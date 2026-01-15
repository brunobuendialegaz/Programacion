package ej2;

public class Vehiculo {

    private String marca, modelo;

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Vehiculo(){}

    public Vehiculo(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }

    public void mostrarDatos(){
        System.out.println("Vehiculo: " + marca + " " + modelo);
    }

}
