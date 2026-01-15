package ej2;

public class Coche extends Vehiculo {

    private int numeroPuertas;

    public Coche(){
        super();
    }

    public Coche(String marca, String modelo, int numeroPuertas){
        super(marca, modelo);
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public void mostrarDatos(){
        System.out.println("Coche: " + getMarca() + " " + getModelo() + ", numero de puertas: " + numeroPuertas);
    }

}
