import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    void pruebaSuma() {
        Calculadora calc = new Calculadora();
        // Sentencia principal de prueba: assert para comparar (esperado, actual)
        assertEquals(5, calc.Sumar(2, 3), "La suma de 2 + 3 debería ser 5");
    }

    @Test
    void pruebaResta() {
        Calculadora calc = new Calculadora();
        assertEquals(10, calc.Restar(20, 10), "La resta debería ser 10");
    }

}