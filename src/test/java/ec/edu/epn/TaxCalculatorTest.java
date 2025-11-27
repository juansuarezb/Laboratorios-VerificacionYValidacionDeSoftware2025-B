package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TaxCalculatorTest {

    TaxCalculator tax;

    @BeforeEach
    void setUp() {
        tax = new TaxCalculator();
    }

    // ------------------------------
    // 1. PRUEBAS DE VALORES VÁLIDOS
    // ------------------------------

    static Stream<double[]> validValuesProvider() {
        return Stream.of(
                new double[]{100, 10, 110},   // 10% de 100
                new double[]{200, 15, 230},   // 15% de 200
                new double[]{0, 20, 0},       // monto cero
                new double[]{50, 0, 50},      // sin impuesto
                new double[]{80, 100, 160}    // impuesto máximo permitido
        );
    }

    @ParameterizedTest
    @MethodSource("validValuesProvider")
    void testValidCalculations(double[] data) {
        double amount = data[0];
        double taxRate = data[1];
        double expected = data[2];

        assertEquals(expected, tax.calculateTax(amount, taxRate), 0.0001);
    }


    // -------------------------------------------
    // 2. PRUEBAS PARA MONTOS INVÁLIDOS (< 0)
    // -------------------------------------------

    static Stream<Double> invalidAmountsProvider() {
        return Stream.of(-1.0, -10.0, -0.01);
    }

    @ParameterizedTest
    @MethodSource("invalidAmountsProvider")
    void testInvalidAmounts(double amount) {
        assertThrows(IllegalArgumentException.class, () -> {
            tax.calculateTax(amount, 10);
        });
    }

}