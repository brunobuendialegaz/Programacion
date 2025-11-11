package enums;

public enum Moneda {

    DOLAR(1.1565),LIBRA(0.8732),YEN(172.95),PESO(20.78);

    double valorConversion;

    Moneda(Double valorConversionP) {
        valorConversion = valorConversionP;
    }

    public double getValorConversion(){
        return valorConversion;
    }
}



