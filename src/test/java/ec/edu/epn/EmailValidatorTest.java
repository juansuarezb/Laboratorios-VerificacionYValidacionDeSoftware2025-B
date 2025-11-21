package ec.edu.epn;
import java.util.stream.Stream;
import ec.edu.epn.EmailValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class EmailValidatorTest{
    private EmailValidator emailValidator;
    static Stream<Arguments> emailValidatorData(){
        Stream<Arguments> ret =
          Stream.of(
                Arguments.of("juan.suarez04@epn.edu.ec", true),
                Arguments.of("me.example@gmail.com", true),
                Arguments.of("correo.invalido", false)
            );
            return ret;
    }
    @BeforeEach
    void init(){
        emailValidator = new EmailValidator();
    }
    @ParameterizedTest
    //Esta anotacion espera una cadena (nombre del metodo para genera la info)
    @MethodSource("emailValidatorData")
    //Definimos un conjunto de parametros
    void isValid_MultipleEmails_ShouldReturnTrue(String email, boolean expected){
        boolean result = emailValidator.isValid(email);
        assertEquals(expected, result);
    }
}