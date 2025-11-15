package enums;

public enum EstadoEnvio {

    PENDIENTE(1),
    PROCESANDO(2),
    ENVIADO(3),
    EN_TRANSITO(4),
    ENTREGADO(5),
    CANCELADO(6);

    private final int estadoNum;

    EstadoEnvio(int estadoNumP){
        estadoNum = estadoNumP;
    }

    public int getEstadoNum(){
        return estadoNum;
    }

    public static String getNombreEstado(int estado){
        for (EstadoEnvio tipo : EstadoEnvio.values()){
                if (tipo.getEstadoNum() == estado){
                    return String.valueOf(tipo);
                }
        }
        return null;
    }
}
