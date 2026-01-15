package ej4;

    public class Circulo extends Figura {

    private int radio;

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }
    
    public Circulo(){}

    public Circulo(int radio){
        this.radio = radio;
    }

    @Override
    public void calcularArea(){
        System.out.println("El area del circulo es " + Math.PI*(radio*radio));
    }


}
