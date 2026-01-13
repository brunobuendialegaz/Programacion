import controller.RectanguloController;
import model.*;

public class Main {

    public static void main(String[] args) {

        /*
        ej1 y 2
        Persona persona1 = new Persona("Bruno", 30);

        System.out.println("Datos antes de cambiarlos.");
        persona1.mostrarDatos();

        persona1.setNombre("Bruno Buendia");

        persona1.setEdad(35);

        System.out.println("Datos tras cambiarlos.");
        persona1.mostrarDatos();*/

        /*
        ej3
        Rectangulo rectangulo = new Rectangulo(15,10);
        RectanguloController rController = new RectanguloController(rectangulo);

        rController.mostrarDatos();
        */

        /*
        ej4
        Libro libro1 = new Libro();
        libro1.mostrarDatos();

        Libro libro2 = new Libro("Alchemised","SenyiLiu");
        libro2.mostrarDatos();

        Libro libro3 = new Libro("Alchemised","SenyiLiu",1070);
        libro3.mostrarDatos();
        */

        /*
        ej5
        CuentaBancaria bruno = new CuentaBancaria("Bruno",1500);
        CuentaBancaria dioni = new CuentaBancaria("Dioni",1500);
        CuentaBancaria dani = new CuentaBancaria("Dani",1500);

        bruno.depositar(1590.99);
        bruno.retirar(900);
        */

        /*
        ej6
        Estudiante bruno = new Estudiante("Bruno", 19, 8.5);

        bruno.mostrarDatos();

        bruno.setNota(11);

        bruno.mostrarDatos();*/

        /*

        ej7

        Producto jamon = new Producto("Jamon", 19.99, 10);
        System.out.println(jamon.toString());

        Producto ram = new Producto("Memoria Ram", 399.99, 215);
        System.out.println(ram.toString());


        Producto ssd = new Producto("SSD nvme", 199.5, 220);
        System.out.println(ssd.toString());*/


        /*
        ej 7.1
        Direccion rioQuipar = new Direccion("rio Quipar n30", "Librilla", 30892);

        Cliente bruno = new Cliente("Bruno", "bruno.buendia@pccomponentes.com", rioQuipar);

        System.out.println(bruno.toString());*/

        /*
        ej8
        Empleado[] empleados = new Empleado[] {new Empleado("Bruno", "Programador", 29990.00),
                new Empleado("juan", "Programador", 40000),
                new Empleado("alberto", "Programador", 50000),
                new Empleado("maria", "Programador", 19000),
                new Empleado("leonisia", "Programador", 35000.00)
        };

        for (int i = 0; i < empleados.length; i++) {
            System.out.println((i+1) + "- " + empleados[i].toString());
        }

        Empleado empleadoMayorSalario = new Empleado();
        for (Empleado empleado : empleados){
            if (empleado.getSalario()> empleadoMayorSalario.getSalario()){
                empleadoMayorSalario = empleado;
            }
        }

        System.out.println("Empleado con mayor salario: " + empleadoMayorSalario.toString());

        double salarioMedio = 0;
        for (int i = 0; i < empleados.length; i++) {
            salarioMedio += empleados[i].getSalario();
        }

        System.out.println("Salario medio: " + salarioMedio/empleados.length + "€");*/

        /*
        ej0
        System.out.println(Calculadora.suma(1,3));
        System.out.println(Calculadora.resta(5,3));
        System.out.println(Calculadora.multiplicacion(5,3));
        System.out.println(Calculadora.division(5,3));
        System.out.println(Calculadora.potencia(32,4));*/


    }


}
