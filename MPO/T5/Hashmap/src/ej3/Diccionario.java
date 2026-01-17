package ej3;

import java.util.HashMap;

public class Diccionario {
    private HashMap<String, String> diccionario;

    public Diccionario(){
        diccionario = new HashMap<>();
    }

    public HashMap<String, String> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(HashMap<String, String> diccionario) {
        this.diccionario = diccionario;
    }

    public void agregarTraduccion(String espanol, String ingles){
        diccionario.put(espanol, ingles);
        System.out.println("Traducción añadida.");
    }

    public String traducir(String palabra){
        return diccionario.getOrDefault(palabra, "palabra no encontrada");
    }

    public void agregarVariasTraducciones(String[][] traducciones){
        for (String[] par : traducciones) {
            agregarTraduccion(par[0],par[1]);
        }
    }

    public void listarTraducciones(){
        /*
        Forma que se me ocurre por logica, menos eficiente que la lambda
        System.out.println("---  Palabras en diccionario ---");
        for (String espanol : diccionario.keySet()) {
            System.out.println("Traducción de " + espanol + ": " + diccionario.get(espanol));
        }*/
        //forma lambda
        System.out.println("---  Palabras en diccionario ---");
        diccionario.forEach((espanol, ingles) -> {
            System.out.println("Traducción de " + espanol + ": " + ingles);
        });
    }

    public int tamanioDiccionario(){
        return diccionario.size();
    }

    public void traducirFrase(String frase){
        String[] palabras = frase.split(" ");
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            String palabraTraducida = diccionario.getOrDefault(palabra.toLowerCase(), palabra);
            resultado.append(palabraTraducida);
            resultado.append(" ");
        }
        System.out.println("Frase traducida: "+resultado);

    }


}
