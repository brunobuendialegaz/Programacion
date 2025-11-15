package enums;

public enum CategoriaPlato {
    ENTRADA(new String[]{"marineras", "gambas", "ensalada"}),
    PRINCIPAL(new String[]{"paella","pescado","carne"}),
    POSTRE(new String[]{"tarta de queso","arroz con leche","tarta de chocolate"}),
    BEBIDA(new String[]{"vino","refresco","agua"});

    private final String[] plato;

    CategoriaPlato(String[] platoP){
        plato = platoP;
    }

    public String[] getPlato(){
        return plato;
    }
}
