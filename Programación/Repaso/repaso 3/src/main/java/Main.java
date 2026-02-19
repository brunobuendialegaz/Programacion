import model.Cuenta;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {


        /*BiFunction<Producto, Producto, Producto> comparador = (item1, item2) -> item1.getPrecio() > item2.getPrecio()? item1: item2;

        Producto[] productos = {
                new Producto("Ratón", 19.99),
                new Producto("Teclado", 39.99),
                new Producto("Ram", 99999.00),
                new Producto("Pantalla", 399.99),
                new Producto("Web Cam", 18),
        };

        //Arrays.stream(productos)
        // .sorted(Comparator.comparingDouble(Producto::getPrecio)
        // .reversed()).toList().stream().limit(1)
        // .forEach(item -> System.out.println("el producto con mayo precio es: " + item.getNombre()));

        //Arrays.stream(productos).reduce(comparador::apply)
          //      .ifPresent(caro -> System.out.println("El producto mas caro es " + caro.getNombre() + " su precio es " + caro.getPrecio()));


        //System.out.println("El producto con el precio mas alto es: " +comparador.apply(new Producto("Ratón", 19.99), new Producto("Teclado", 39.99)).getNombre() );


        Producto productoMasCaro = productos[0];

        for (Producto p :productos) {
            productoMasCaro =  comparador.apply(productoMasCaro, p);
        }

        System.out.println("El producto mas caro es " + productoMasCaro.getNombre() + " su precio es " + productoMasCaro.getPrecio());


        System.out.println(Arrays.stream(productos).filter(producto -> producto.getPrecio()>9000).toList().getFirst().getNombre());





*/

        List<Cuenta> cuentas = new ArrayList<>();

        cuentas.add(new Cuenta("Dano",1000));
        cuentas.add(new Cuenta("Bruno",3000));
        cuentas.add(new Cuenta("Pablo",5000));
        cuentas.add(new Cuenta("Belén",-10000));
        cuentas.add(new Cuenta("Dani",15000));

        System.out.println("Cuentas originales: ");

        mostrarCuentas(cuentas);

        Consumer<Cuenta> aplicarComision = cuenta -> {
            if(cuenta.getSaldo() < 0){
                cuenta.setSaldo(cuenta.getSaldo()*1.05);
            }
        };

        cuentas.forEach(cuenta -> aplicarComision.accept(cuenta));

        System.out.println("Cuentas despues de la comision: ");

        mostrarCuentas(cuentas);

    }

    public static void mostrarCuentas (List<Cuenta> lista){
        for (Cuenta cuenta : lista) {
            cuenta.mostrarDatos();
        }

    }
}
