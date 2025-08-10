import com.ejemplos.pruebas.ServicioA;
import com.ejemplos.pruebas.ServicioAImpl;
import com.ejemplos.pruebas.ServicioB;
import com.ejemplos.pruebas.ServicioBImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class TestServicioB {

    @Test
    void testMultiplicar(){
        ServicioB serviciB = new ServicioBImpl();

        // valor real - valor esperado
        Assertions.assertEquals(serviciB.multiplicar(2,3),6);
    }

    @Test
    void testMultiplicarSumar(){
        ServicioA servicioA = Mockito.mock(ServicioA.class);
        Mockito.when(servicioA.sumar(2,3)).thenReturn(5);

        ServicioB servicioB = new ServicioBImpl();
        servicioB.setServicioA(servicioA);

        Assertions.assertEquals(servicioB.multiplicarSumar(2,3,2),10);
    }
}
