package ec.edu.epn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Se crea una clase con el nombre de la clase a probar mas "Test" -> ESTANDAR
public class CalculatorTest {
	private Calculator calculator;
	//El patron de testin AAA (Arrange, Act y Assert) es un estandar para estructurar tests
	@BeforeEach
	void init() {
		//Se crea una instancia de la clase a realizar los test
		//ya que necesitamos un objeto para que JUnit pueda trabajar con los metodos de la clase
		//ARRANGE COMUN
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
}
