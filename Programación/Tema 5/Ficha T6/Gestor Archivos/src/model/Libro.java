package model;

public class Libro extends Archivo {

    private int numeroPaginas;
    private String isbn;

    public Libro(int identificador, String titulo, String autor, String tamano, String formato) {
        super(identificador, titulo, autor, tamano, formato);
    }

    public Libro() {
    }

    public Libro(int identificador, String titulo, String autor, String tamano, String formato, int numeroPaginas, String isbn) {
        super(identificador, titulo, autor, tamano, formato);
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("numeroPaginas = " + numeroPaginas);
        System.out.println("isbn = " + isbn);
    }
}
