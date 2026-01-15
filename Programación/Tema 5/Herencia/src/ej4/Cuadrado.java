package ej4;

public class Cuadrado extends Figura {

    private int lado;

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public Cuadrado(){}

    public Cuadrado(int lado){
        this.lado = lado;
    }

    @Override
    public void calcularArea(){
        System.out.println("El area del cuadrado es " + lado*lado);
    }

}
