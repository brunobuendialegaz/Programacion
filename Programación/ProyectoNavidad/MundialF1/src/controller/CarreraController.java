package controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Carrera;
import model.Coche;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarreraController {

    private Carrera carrera;

    public void simularCarrera(){
        System.out.println("Comenzamos con la carrera de "+carrera.getNombre()+"...");
        resetearKms();
        do {
            for (int i = 0; i < carrera.getParticipantes().size(); i++) {
                darVuelta(i);
            }
        }while (!hayGanador(carrera.getParticipantes()));
        ordenarClasificacionCarrera();
        sumarPuntos();
        mostrarResultadoCarrera();
        ordenarClasificacionPuntos();
    }

    private void mostrarResultadoCarrera(){
        System.out.printf("""
                
                === PODIO DE %s ===
                1.- %s [+10 puntos]
                2.- %s [+8 puntos]
                3.- %s [+6 puntos]
                
                """, carrera.getNombre(),
                carrera.getParticipantes().get(0).getNombre(),
                carrera.getParticipantes().get(1).getNombre(),
                carrera.getParticipantes().get(2).getNombre()
        );

    }


    private void darVuelta(int i){
        int avance = (int)(Math.random()*31)+20;
        carrera.getParticipantes().get(i).setKms(carrera.getParticipantes().get(i).getKms()+avance);
    }

    private boolean hayGanador(ArrayList<Coche> participantes){
        for (int i = 0; i < participantes.size(); i++) {
            if (participantes.get(i).getKms()>= carrera.getKms()){
                return true;
            }
        }
        return false;
    }

    private void ordenarClasificacionCarrera (){
        carrera.getParticipantes().sort((c1, c2) -> c2.getKms() - c1.getKms());
    }

    private void ordenarClasificacionPuntos (){
        carrera.getParticipantes().sort((c1, c2) -> c2.getPuntos() - c1.getPuntos());
    }

    private void sumarPuntos(){
        int puntos = 10;
        for (int i = 0; i < carrera.getParticipantes().size(); i++) {
            if (puntos>0){
                int puntosSumar = carrera.getParticipantes().get(i).getPuntos() + puntos;
                carrera.getParticipantes().get(i).setPuntos(puntosSumar);
                puntos -= 2;
            }

        }
    }

    private void resetearKms(){
        for (int i = 0; i < carrera.getParticipantes().size(); i++) {
            carrera.getParticipantes().get(i).setKms(0);
        }
    }


}
