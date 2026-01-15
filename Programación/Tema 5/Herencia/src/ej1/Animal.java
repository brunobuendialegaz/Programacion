package ej1;
public abstract class Animal {

    private String nombre;
    private int edad;

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Animal(){}

    public Animal(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public void mostrarDatos(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }

    
    public abstract void hacerSonido();

}
