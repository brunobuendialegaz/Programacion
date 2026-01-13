package model;

public class Libro {

    private String titulo;
    private String autor;
    private int paginas;

    public Libro(){}

    public Libro(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }

    public Libro(String titulo, String autor, int paginas){
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void mostrarDatos(){
        System.out.println("Datos del libro:");
        System.out.println("autor = " + autor);
        System.out.println("titulo = " + titulo);
        System.out.println("paginas = " + paginas);
    }

}
