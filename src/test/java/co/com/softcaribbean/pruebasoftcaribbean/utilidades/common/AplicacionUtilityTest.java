package co.com.softcaribbean.pruebasoftcaribbean.utilidades.common;

import co.com.softcaribbean.pruebasoftcaribbean.model.request.EditarClienteRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AplicacionUtilityTest {

    @Test
    @DisplayName("Test para comprobar que el método no arroja ninguna excepcion")
    void obtenerListapropiedadesNulas() {
        var editarClienteRequest = new EditarClienteRequest();
        editarClienteRequest.setCusCdcelular("3173372270");
        editarClienteRequest.setCusCdtelefono("5965720");
        editarClienteRequest.setCusNmcargo(201);
        Assertions.assertDoesNotThrow(()->AplicacionUtility.obtenerListapropiedadesNulas(editarClienteRequest));
    }

    @Test
    @DisplayName("Test para comprobar si la fecha en Long trae correctamente la fecha en LocalDateTime")
    void convertirLongToLocalDateTime() {
        var fechaLong = 1618171033L;
        var fechaLocalDateTime = AplicacionUtility.convertirLongToLocalDateTime(1618171033L).toString();
        System.out.println(fechaLocalDateTime);
        Assertions.assertEquals("1970-01-19T12:29:31.033", fechaLocalDateTime);
    }
}