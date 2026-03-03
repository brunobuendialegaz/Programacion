import model.CuentaBancaria;
import model.Libro;
import model.Pelicula;

public class Main {

    public static void main(String[] args) {

        /*Libro libro = new Libro("Hyperion", "Dan Simmons", 400, 75.99);
        System.out.println("Tiene el libro mas de 300 paginas?" + libro.esLibroLargo());
        libro.aplicarDescuento(50);
        System.out.println("El nuevo precio es " + libro.getPrecio());*/

        /*CuentaBancaria cuentaBruno = new CuentaBancaria("Bruno", "02139481209348");
        CuentaBancaria cuentaJuanCa = new CuentaBancaria("JuanCa", "304984029209348");

        cuentaBruno.ingresar(9000.50);
        cuentaBruno.mostrarInfo();
        System.out.println("Es posible retirar esta cantidad? 5000: " + (cuentaBruno.retirar(5000)? "si": "no"));
        cuentaBruno.mostrarInfo();
        cuentaBruno.transferir(cuentaJuanCa, 19.99);
        cuentaJuanCa.mostrarInfo();*/

        Pelicula cumbresBorrascosas = new Pelicula("Cumbres Borrascosas", "Emerald Fennell", 136, 1995, 12);
        System.out.println("La pelicula tiene mas de 25 años? " + (cumbresBorrascosas.esClasica()? "si": "no"));
        System.out.println("Es recomendable? " + (cumbresBorrascosas.esRecomendable()? "si": "no"));
        cumbresBorrascosas.mostrarInfo();
    }

}
