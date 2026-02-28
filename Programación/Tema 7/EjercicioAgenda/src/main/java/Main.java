import controler.ControllerAgenda;
import model.Usuario;

public class Main {

    public static void main(String[] args) {

        ControllerAgenda controllerAgenda = new ControllerAgenda();

        /*controllerAgenda.anadirUsuario(new Usuario("Dano","DiAlgoTio","1902873"));
        controllerAgenda.anadirUsuario(new Usuario("Dan1","Meco","1902873"));
        controllerAgenda.anadirUsuario(new Usuario("Yago","Kata","1902873"));
        controllerAgenda.anadirUsuario(new Usuario("Borja","Gadea","1902873"));*/

        controllerAgenda.menuAgenda();


    }
}
