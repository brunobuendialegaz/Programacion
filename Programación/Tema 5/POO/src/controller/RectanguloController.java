package controller;

import model.Rectangulo;

public class RectanguloController {
    private Rectangulo rectangulo;

    public RectanguloController(){}
    public RectanguloController(Rectangulo rectangulo){
        this.rectangulo = rectangulo;
    }

    public Rectangulo getRectangulo() {
        return rectangulo;
    }

    public void setRectangulo(Rectangulo rectangulo) {
        this.rectangulo = rectangulo;
    }

    public void mostrarDatos(){
        System.out.println("Area = " + calcularArea());
        System.out.println("Perimetro = " + calcularPerimetro());
    }

    private double calcularArea(){
        return rectangulo.getBase()*rectangulo.getAltura();
    }

    private double calcularPerimetro(){
        return (rectangulo.getBase()*2)+(rectangulo.getAltura()*2);
    }



}
