package ej2;

import java.util.HashMap;

public class Stock {
    private HashMap<String, Integer> stock;

    public HashMap<String, Integer> getStock() {
        return stock;
    }

    public void setStock(HashMap<String, Integer> stock) {
        this.stock = stock;
    }

    public Stock(){
        stock = new HashMap<>();
    }

    public void agregarProducto(String codigoProducto, int cantidad){
            stock.merge(codigoProducto, cantidad, Integer::sum);
            System.out.println("Stock actualizado.");
    }

    public boolean venderProducto(String codigoProducto, int cantidad){
        Integer stockActual = stock.get(codigoProducto);
        if (stockActual==null){
            System.out.println("El articulo no existe.");
        } else if (stockActual>=cantidad) {
            stock.merge(codigoProducto, -cantidad, Integer::sum);
            return true;
        }else {
            System.out.println("No hay suficientes unidades.");
        }
        return false;
    }

    public Integer consultarStock(String codigo){
        return stock.getOrDefault(codigo,null);
    }

    public void listarInventario(){
        if (stock.isEmpty()){
            System.out.println("No hay ningun stock disponible.");
        } else {
            System.out.println("---  Stock disponible  ---");
            for (String codigo : stock.keySet()) {
                int cantidad = stock.get(codigo);
                System.out.println("Articulo " + codigo + ", disponible: " + cantidad);
            }
        }
    }

    public void listarProductosBajoStock(int stockObjetivo){
        if (stock.isEmpty()){
            System.out.println("No hay ningun stock disponible.");
        } else {
            System.out.println("---  Stock disponible con bajo Stock  ---");
            for (String codigo : stock.keySet()) {
                int cantidad = stock.get(codigo);
                if (cantidad<=stockObjetivo){
                System.out.println("Articulo " + codigo + ", disponible: " + cantidad);
                }
            }
        }
    }

    public int calcularStockTotal(){
        if (stock.isEmpty()){
            System.out.println("No hay ningun stock disponible.");
            return 0;
        } else {
            int stockTotal = 0;
            for (int cantidad : stock.values()) {
                stockTotal += cantidad;
            }
            return stockTotal;
        }
    }

    public int productoConMasStock(){
        if (stock.isEmpty()){
            System.out.println("No hay ningun stock disponible.");
            return 0;
        } else {
            int mayorStock = 0;
            for (int cantidad : stock.values()) {
                if (cantidad>mayorStock){
                    mayorStock = cantidad;
                }
            }
            return mayorStock;
        }
    }






}
