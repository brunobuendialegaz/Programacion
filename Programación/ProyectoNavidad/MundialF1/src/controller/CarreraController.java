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
        }while (!carreraFinalizada(carrera.getParticipantes()));
        ordenarClasificacionCarrera();
        sumarPuntos();
        mostrarResultadoCarrera();
        ordenarClasificacionPuntos();
    }

    private void mostrarResultadoCarrera(){
        System.out.printf("""
                
                === Podio de %S ===

                """,
                carrera.getNombre()
        );

        int puntos = 10;
        for (int i = 0; i < carrera.getParticipantes().size() && i<3; i++) {
                System.out.printf("""
                    %d.- %s [%d puntos]
                    """,(i+1),
                        carrera.getParticipantes().get(i).getNombre(),
                        puntos

                );
                puntos -=2;
        }
    }


    private void darVuelta(int i){
        int avance = (int)(Math.random()*31)+20;
        carrera.getParticipantes().get(i).setKms(carrera.getParticipantes().get(i).getKms()+avance);
        carrera.getParticipantes().get(i).setKmsTotales(carrera.getParticipantes().get(i).getKmsTotales()+avance);
    }

    // con este metodo me aseguro de que nadie este empatado, en caso de que haya un empate, damos otra vuelta.
    private boolean carreraFinalizada(ArrayList<Coche> participantes) {

        boolean metaCruzada = false;
        for (int i = 0; i < participantes.size(); i++) {
            if (participantes.get(i).getKms() >= carrera.getKms()) {
                metaCruzada = true;
                break;
            }
        }

        if (!metaCruzada) {
            return false;
        }

        for (int i = 0; i < participantes.size(); i++) {
            for (int j = i + 1; j < participantes.size(); j++) {

                if (participantes.get(i).getKms() == participantes.get(j).getKms()) {
                    return false;
                }
            }
        }


        return true;
    }

    private void ordenarClasificacionCarrera (){
        carrera.getParticipantes().sort((c1, c2) -> c2.getKms() - c1.getKms());
    }

    // Con este orden de clasificación, lo que hacemos es que si empatan 2 posiciones a puntos,
    // se pone primero el que tiene mas kms totales en el campeonato
    private void ordenarClasificacionPuntos() {
        carrera.getParticipantes().sort((c1, c2) -> {
            int comparacionPuntos = c2.getPuntos() - c1.getPuntos();
            if (comparacionPuntos != 0) {
                return comparacionPuntos;
            }
            return c2.getKmsTotales() - c1.getKmsTotales();
        });
    }

    private void sumarPuntos(){
        int puntos = 10;
        for (int i = 0; i < carrera.getParticipantes().size(); i++) {
            if (puntos>0){
                carrera.getParticipantes().get(i).setPuntos(carrera.getParticipantes().get(i).getPuntos()+puntos);
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
