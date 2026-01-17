import ej1.Agenda;
import ej2.Stock;
import ej3.Diccionario;

public class Main {

    public static void main(String[] args) {
        

        //ej1
        /*
        

        
        Agenda miAgenda = new Agenda();

        System.out.println("--- PRUEBAS DE LA AGENDA ---");
        
        miAgenda.agregarContacto("Bruno", "600111222");
        miAgenda.agregarContacto("Ana", "611333444");

        miAgenda.agregarContacto("Bruno", "600111222"); // Dirá que ya existe igual
        miAgenda.agregarContacto("Bruno", "700888999"); // Lo actualizará

        System.out.println("Buscando a Ana: " + miAgenda.buscarContacto("Ana"));
        System.out.println("Buscando a Pedro: " + miAgenda.buscarContacto("Pedro"));

        System.out.println("Total contactos: " + miAgenda.contarContactos()); //
        miAgenda.listarContactos();

        System.out.println(miAgenda.listarContactosMalo());

        miAgenda.eliminarContacto("Ana"); //
        System.out.println("¿Existe Ana tras borrarla?: " + miAgenda.existeContacto("Ana"));

        miAgenda.listarContactos();
        */

        //ej2
        /*


        Stock stock = new Stock();

        stock.agregarProducto("p10000", 8);
        stock.agregarProducto("p10000", 8);

        stock.consultarStock("p10000");

        stock.agregarProducto("p12000", 8);
        stock.agregarProducto("p12000", 8);

        stock.listarInventario();

        System.out.println("Producto vendido? " + stock.venderProducto("p10000", 18));
        System.out.println("Producto vendido? " + stock.venderProducto("p10000", 15));

        stock.listarInventario();
        stock.listarProductosBajoStock(5);

        System.out.println("Cantidad total de stock: " + stock.calcularStockTotal());
        System.out.println("Producto con mas stock: " + stock.productoConMasStock());

         */

        //ej3
        /*Diccionario diccionario = new Diccionario();
        String[][] datos = {
                {"el", "the"},
                {"la", "the"},
                {"gato", "cat"},
                {"perro", "dog"},
                {"juega", "plays"},
                {"come", "eats"},
                {"corre", "runs"},
                {"grande", "big"},
                {"pequeño", "small"},
                {"en", "in"},
                {"parque", "park"},
                {"casa", "house"},
                {"y", "and"},
                {"feliz", "happy"},
                {"rápido", "fast"},
                {"duerme", "sleeps"}
        };

        diccionario.agregarVariasTraducciones(datos);

        diccionario.tamanioDiccionario();

        System.out.println("la palabra gato traducida es "+diccionario.traducir("gato"));

        diccionario.listarTraducciones();

        diccionario.traducirFrase("El gato pequeño come y duerme siesta");*/






        

    }

    
}
