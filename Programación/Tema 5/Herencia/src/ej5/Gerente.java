package ej5;

public class Gerente extends Empleado{

    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Gerente(){
        super();
    }

    public Gerente(String nombre, double salarioBase, double bonus){
        super(nombre, salarioBase);
        this.bonus = bonus;
    }

    @Override
    public void mostrarDatos(){
        System.out.println("Empleado: " + getNombre());
        System.out.println("Puesto: Gerente");
        System.out.println("Salario Base: " + getSalarioBase() + "€");
        System.out.println("Bonus: " + bonus + "€");
        System.out.println("Salario total: " + calcularSalarioTotal() + "€");
    }

    public double calcularSalarioTotal(){
        return getSalarioBase()+bonus;
    }

}
