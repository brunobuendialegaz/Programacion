package ej3;

public class Estudiante extends Persona {

    private String curso;

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Estudiante(){
        super();
    }

    public Estudiante(String nombre, int edad, String curso){
        super(nombre, edad);
        this.curso = curso;
    }

    public void estudiar(){
        System.out.println("Estoy estudiando " + curso);
    }

}
