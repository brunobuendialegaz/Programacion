package model;

public class Archivo {

    private int identificador;
    private String titulo, autor, tamano, formato;

    public Archivo(){
    }

    public Archivo(int identificador, String titulo, String autor, String tamano, String formato) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.autor = autor;
        this.tamano = tamano;
        this.formato = formato;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void mostrarDatos(){
        System.out.println("identificador = " + identificador);
        System.out.println("titulo = " + titulo);
        System.out.println("autor = " + autor);
        System.out.println("tamano = " + tamano);
        System.out.println("formato = " + formato);
    }
}
