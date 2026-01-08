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
        System.out.println("¡¡¡Resultado final!!");
        mostrarResultadoCampeonatoFinal();
        System.out.println("\n¡¡¡Felicidades al campeon!!!");

    }

    private void mostrarResultadoCampeonato() {
        Scanner s = new Scanner(System.in);
        String opcion = "";
        while (!opcion.toLowerCase().equals("no") && !opcion.toLowerCase().equals("si")){
            System.out.print("¿Quieres ver la clasificación actual? (si/no) ");
            opcion = s.nextLine();
            if (!opcion.toLowerCase().equals("no") && !opcion.toLowerCase().equals("si")) {
                System.out.print("Opción no valida, por favor introduce si o no. ");
            }
        }

        switch (opcion.toLowerCase()) {
            case "no" -> {
                System.out.println("Continuamos con la siguiente carrera...");
            }
            case "si" -> {
                mostrarResultadoCampeonatoFinal();
            }
        }
    }

    private void mostrarResultadoCampeonatoFinal(){
        System.out.printf("""
                
                === CLASIFICACIÓN CAMPEONATO %S ===

                """,
                campeonato.getNombre()
                    );

        for (int i = 0; i < campeonato.getCarreras().get(0).getParticipantes().size(); i++) {
            System.out.printf("""
                    %d.- %s [%d puntos]
                    """,(i+1),
                    campeonato.getCarreras().get(i).getParticipantes().get(i).getNombre(),
                    campeonato.getCarreras().get(i).getParticipantes().get(i).getPuntos()
            );
        }
    }

}
