package controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Campeonato;

import java.util.Scanner;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CampeonatoController {

    private Campeonato campeonato;



    public void simularCampeonato(){
        for (int i = 0; i < campeonato.getCarreras().size(); i++) {
            CarreraController c = new CarreraController(campeonato.getCarreras().get(i));
            c.simularCarrera();
            if ((i!=(campeonato.getCarreras().size()-1))){
                mostrarResultadoCampeonato();
            }

        }
        mostrarResultadoCampeonatoFinal();

    }

    private void mostrarResultadoCampeonato() {
        Scanner s = new Scanner(System.in);
        String opcion = "";
        while (!opcion.toLowerCase().equals("no") && !opcion.toLowerCase().equals("si")){
            System.out.print("¿Quieres ver la clasificación actual? (si/no)");
            opcion = s.nextLine();
            if (!opcion.toLowerCase().equals("no") && !opcion.toLowerCase().equals("si")) {
                System.out.println("Opción no valida, por favor introduce si o no.");
            }
        }

        switch (opcion) {
            case "no" -> {
                System.out.println("Continuamos con la siguiente carrera...");
            }
            case "si" -> {
                System.out.printf("""
                                
                                === CLASIFICACIÓN CAMPEONATO %S ===
                                1.- %s [%d puntos]
                                2.- %s [%d puntos]
                                3.- %s [%d puntos]
                                
                                """, campeonato.getNombre(),
                        campeonato.getCarreras().get(0).getParticipantes().get(0).getNombre(), campeonato.getCarreras().get(0).getParticipantes().get(0).getPuntos(),
                        campeonato.getCarreras().get(1).getParticipantes().get(1).getNombre(), campeonato.getCarreras().get(1).getParticipantes().get(1).getPuntos(),
                        campeonato.getCarreras().get(2).getParticipantes().get(2).getNombre(), campeonato.getCarreras().get(2).getParticipantes().get(2).getPuntos()
                );
            }
        }
    }

    private void mostrarResultadoCampeonatoFinal(){
        System.out.printf("""
                
                === CLASIFICACIÓN CAMPEONATO %S ===
                1.- %s [%d puntos]
                2.- %s [%d puntos]
                3.- %s [%d puntos]
                
                Enhorabuena al CAMPEON %s!!!
                """,
                campeonato.getNombre(),
                campeonato.getCarreras().get(0).getParticipantes().get(0).getNombre(),campeonato.getCarreras().get(0).getParticipantes().get(0).getPuntos(),
                campeonato.getCarreras().get(1).getParticipantes().get(1).getNombre(),campeonato.getCarreras().get(1).getParticipantes().get(1).getPuntos(),
                campeonato.getCarreras().get(2).getParticipantes().get(2).getNombre(),campeonato.getCarreras().get(2).getParticipantes().get(2).getPuntos(),
                campeonato.getCarreras().get(0).getParticipantes().get(0).getNombre()
                    );
    }

}
