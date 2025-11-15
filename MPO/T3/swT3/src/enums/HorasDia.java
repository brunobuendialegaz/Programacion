package enums;

public enum HorasDia {
    MADRUGADA(new int[]{0, 1, 2, 3, 4, 5}),
    MANIANA(new int[]{6, 7, 8, 9, 10, 11}),
    TARDE(new int[]{12, 13, 14, 15, 16, 17, 18, 19}),
    NOCHE(new int[]{20, 21, 22, 23});

    private final int[] hora;

    HorasDia(int[] horaP){
        hora = horaP;
    }

    public int[] getHora(){
        return hora;
    }

    public static HorasDia getFranja (int horaActual){
        if (horaActual<0 || horaActual>23){
            return null;
        }
        for (HorasDia franja : HorasDia.values()){
            for (int h : franja.getHora()){
                if (h==horaActual){
                    return franja;
                }
            }
        }
        return null;
    }

}
