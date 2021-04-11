package co.com.softcaribbean.pruebasoftcaribbean.service;

import co.com.softcaribbean.pruebasoftcaribbean.controller.ClienteController;
import co.com.softcaribbean.pruebasoftcaribbean.model.response.ClienteResponse;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoNoEncontradoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

class ClienteServiceImplTest {

    @Autowired
    ClienteResponse clienteResponse;

    ClienteService clienteServiceMock = Mockito.mock(ClienteService.class);

    @Autowired
    ClienteController clienteController = new ClienteController(clienteServiceMock);


    @BeforeEach
    void setUp() throws ObjetoNoEncontradoException {
        clienteResponse = new ClienteResponse();
        clienteResponse.setNmid(1L);
        clienteResponse.setCusNmcliente(16);
        clienteResponse.setCusDsnombres("Ricardo Andrés");
        clienteResponse.setCusDsapellidos("Martínez López");
        clienteResponse.setCusDsdireccion("Calle 23 N 50 B 45");
        clienteResponse.setCusDscorreo("ramlopezz93@gmail.com");
        clienteResponse.setCusCdtelefono("5965720");
        clienteResponse.setCusCdtelefonoalter("3719950");
        clienteResponse.setCusCdcelular("3173372270");
        clienteResponse.setCusNmcargo(100);
        clienteResponse.setCusDscargo("Analista de sw");
        clienteResponse.setCusNmciudad(1);
        clienteResponse.setCusDsciudad("Medellín");
        //clienteResponse.setCusFenacimiento(new SimpleDateFormat( "dd/MM/yyyy" ).parse( "20/02/1993" ));
        clienteResponse.setCusGenero("MACULINO");
        clienteResponse.setCusNmcomunidad(1);
        clienteResponse.setCusDscomunidad("Caucano");
        clienteResponse.setCusDsempresalabora("Cadena");
        clienteResponse.setCusNmdivision(22);
        clienteResponse.setCusDsdivision("TI");
        clienteResponse.setCusNmpais(1);
        clienteResponse.setCusDspais("Colombia");
        clienteResponse.setCusHobbies("Futbol, Ajederez, tv");
        clienteResponse.setCusFebaja(null);
        clienteResponse.setCusFeregistro(null);
        Mockito.when(clienteServiceMock.obtenerClientePorCedula(16)).thenReturn(clienteResponse);
    }
    @Test
    void obtenerClientePorCedula() throws ObjetoNoEncontradoException {
        var response = clienteController.obtenerClientePorCedula(16);
        Assertions.assertEquals("Caucano",response.getBody().getCusDscomunidad());
    }
}