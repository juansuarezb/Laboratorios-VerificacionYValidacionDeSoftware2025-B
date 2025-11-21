package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;



//Se crea una clase con el nombre de la clase a probar mas "Test" -> ESTANDAR
public class CalculatorTest {
	private Calculator calculator;
	//El patron de testin AAA (Arrange, Act y Assert) es un estandar para estructurar tests
	@BeforeEach
	void init() {
		//Se crea una instancia de la clase a realizar los test
		//ya que necesitamos un objeto para que JUnit pueda trabajar con los metodos de la clase
		calculator = new Calculator(); //se ejecuta antes de cada prueba
	}
	
	//Indica al momento de realizar las pruebas que este metodo esta asociado a una prueba unitaria
	@Test
	//metodo_caso_resultadoEsperado -->Estandar para nombrar metodos
	void add_TwoPositiveNumbers_ReturnCorrectSum() {
		//ARRANGE PROPIO DE ESTE CASO DE PRUEBA -->SE PREPARAN LOS DATOS
		int a =3, b=5;
		//ACT -->EJECUCION DEL METODO ASOCIADO A LA PRUEBA UNITARIA
		int result = calculator.add(a, b);
		//ASSERT --> VALIDAR EL RESULTADO DE LA EJECUCIÓN
		assertEquals(8, result);
		
	}
	//No importa el cambio que se haga en el codigo, se espera que el resultado
	//se comporte de la manera esperada y se comprueba mediante la prueba unitaria.
	
	@Test
	void substract_TwoPositiveNumbers_ReturnCorrectResult() {
		//ARRANGE PROPIO
		int a = 5, b=2;
		
		//ACT
		int result = calculator.subtract(a, b);
		
		//ASSERT
		assertEquals(3, result);
	}
	
	
	//Con las pruebas unitarias blindamos al codigo de cmabios futuros
	//El cambio en la logica afecta los resultados cuando un cambio "daña" al metodo o parte de codigo


	@Test
	void divide_PositiveNumbers_ReturnsCorrectQuotient(){
		double result = calculator.divide(10, 4);

		assertEquals(2.5,result,0.0001, "10 divido entre 4 debe ser 2.5");
	}

	@Test
	void divide_ByZero_ThrowsException(){
		//Arrange
		int a = 3;
		int b = 0;
		//Act - Assert
		//1 argumento -> clase de la excepcion
		assertThrows(IllegalArgumentException.class, 
			()-> calculator.divide(a,b),
			"Dividir por cero debe lanzar una excepcion"
		);
	}

	@Test
	void divide_ByZero_AssertsExceptionMessage() {
    	IllegalArgumentException exception = assertThrows(
        	IllegalArgumentException.class,
        	() -> calculator.divide(3, 0)
    	);
    	assertEquals("The divisor cannot be zero.", exception.getMessage());
	}
	//Las pruebas unitarias no deberian arrojar excepciones

	@Test
	void isEven_EvenNumber_ReturnTrue() {
    	assertTrue(calculator.isEven(20), "El numero 20 es par");
	}


	@ParameterizedTest
	@ValueSource(ints = {2, 30, -6, 0})
	void isEven_MultipleNumbers_ShouldReturnTrue(int number) {
    	assertTrue(calculator.isEven(number));
	}

	@ParameterizedTest
	@CsvSource({"1, 2, 3",
				"5, 7, 12",
				"1,-2,-1"})
	void add_MultipleValues_ReturnsCorrectValue(int a, int b, int expected){
		assertEquals(expected, calculator.add(a,b));
	}

	@ParameterizedTest
	@CsvSource({"5,3,2",
				"10,9,1",
				"-4,-5,1"})
	void substract_MultipleValues_ReturnsCorrectValue(int a, int b, int expected){
		assertEquals(expected, calculator.subtract(a,b));
	}
	
	@ParameterizedTest
	@CsvSource({
    	"2, 3, 6",
    	"5, 0, 0",
    	"-4, 2, -8",
    	"-3, -3, 9"
	})
	void multiply_MultipleValues_ReturnsCorrectValue(int a, int b, int expected) {
    	assertEquals(expected, calculator.multiply(a, b));
	}

	@ParameterizedTest
	@CsvSource({
    	"10, 2, 5.0",
    	"9, 3, 3.0",
    	"7, 2, 3.5",
    	"-6, 3, -2.0"})
	void divide_MultipleValues_ReturnsCorrectQuotient(int a, int b, double expected) {
    	assertEquals(expected, calculator.divide(a, b), 0.0001);
	}

}
