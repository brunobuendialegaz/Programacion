package model;

public class Video extends Archivo{

    private String actores, director;

    public Video() {
    }

    public Video(int identificador, String titulo, String autor, String tamano, String formato) {
        super(identificador, titulo, autor, tamano, formato);
    }

    public Video(int identificador, String titulo, String autor, String tamano, String formato, String actores, String director) {
        super(identificador, titulo, autor, tamano, formato);
        this.actores = actores;
        this.director = director;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("director = " + director);
        System.out.println("actores = " + actores);
    }
}
