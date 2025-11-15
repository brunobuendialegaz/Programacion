package enums;

public enum ClasificacionJugador {
    PRINCIPIANTE(0,100, "Ticket de repetir intento"),
    INTERMEDIO(101,500,"Botellin de bebida"),
    AVANZADO(501,1000,"Psp pirata"),
    EXPERTO(1001,5000,"Macbook air"),
    MAESTRO(5001,999999999,"850i bmw");

    private final int valorMin;
    private final int valorMax;
    private final String premio;

    ClasificacionJugador(int valorMinP, int valorMaxP, String premioP){
        valorMin = valorMinP;
        valorMax = valorMaxP;
        premio = premioP;
    }

    public int getMin(){
        return valorMin;
    }

    public int getMax(){
        return valorMax;
    }

    public String getPremio(){
        return premio;
    }

    public static String getClasificacionJugador(int clasificacion){
        if (clasificacion<101){
            System.out.println("Sigue probando suerte...");
            return PRINCIPIANTE.toString();
        }else if (clasificacion<501){
            System.out.println("Poco a poco...");
            return INTERMEDIO.toString();
        }else if (clasificacion<1001){
            System.out.println("Nada mal!!");
            return AVANZADO.toString();
        }else if (clasificacion<5001){
            System.out.println("Eres un experto!");
            return EXPERTO.toString();
        }else {
            System.out.println("Eres el puto amo!");
            return MAESTRO.toString();
        }
    }


}
