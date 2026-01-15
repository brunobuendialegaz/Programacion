package ej5;

public class Desarrollador extends Empleado {

    
    private String lenguajePrincipal;

    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    public void setLenguajePrincipal(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public Desarrollador(){
        super();
    }

    public Desarrollador(String nombre, double salarioBase, String lenguajePrincipal){
        super(nombre, salarioBase);
        this.lenguajePrincipal = lenguajePrincipal;
    }

    @Override
    public void mostrarDatos(){
        System.out.println("Empleado: " + getNombre());
        System.out.println("Puesto: Desarrollador");
        System.out.println("Salario Base: " + getSalarioBase() + "€");
        System.out.println("Lenguaje principal: " + lenguajePrincipal);
    }

}
