package ej1;
public class Gato extends Animal {

        public Gato(){
        super();
    }

    public Gato(String nombre, int edad){
        super(nombre,edad);
    }

    @Override
    public void hacerSonido(){
        System.out.println(getNombre() + " hace: Miau miau");
    }

}
