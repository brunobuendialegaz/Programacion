package model;

public class Audio extends Archivo {

    private int duracionSegundos;
    private String soporte;

    public Audio() {
    }

    public Audio(int identificador, String titulo, String autor, String tamano, String formato) {
        super(identificador, titulo, autor, tamano, formato);
    }

    public Audio(int identificador, String titulo, String autor, String tamano, String formato, int duracionSegundos, String soporte) {
        super(identificador, titulo, autor, tamano, formato);
        this.duracionSegundos = duracionSegundos;
        this.soporte = soporte;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(int duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

    public String getSoporte() {
        return soporte;
    }

    public void setSoporte(String soporte) {
        this.soporte = soporte;
    }

    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("duracionSegundos = " + duracionSegundos);
        System.out.println("soporte = " + soporte);
    }

}
