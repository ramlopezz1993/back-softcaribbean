package co.com.softcaribbean.pruebasoftcaribbean.controller;

import co.com.softcaribbean.pruebasoftcaribbean.model.Arbol;
import co.com.softcaribbean.pruebasoftcaribbean.model.Cliente;
import co.com.softcaribbean.pruebasoftcaribbean.service.ClienteService;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.GeneroEnum;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoNoEncontradoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;

class ClienteControllerTest {

    @Autowired
    Cliente cliente;
    @Autowired
    ClienteController clienteController;
    ClienteService clienteService;
    @Autowired
    Arbol arbol = Mockito.mock(Arbol.class);

    @BeforeEach
    void setUp() throws ObjetoNoEncontradoException, ParseException {
        cliente = new Cliente();
        cliente.setNmid(1L);
        cliente.setCusNmcliente(16);
        cliente.setCusDsnombres("Ricardo Andrés");
        cliente.setCusDsapellidos("Martínez López");
        cliente.setCusDsdireccion("Calle 23 N 50 B 45");
        cliente.setCusDscorreo("ramlopezz93@gmail.com");
        cliente.setCusCdtelefono("5965720");
        cliente.setCusCdtelefonoalter("3719950");
        cliente.setCusCdcelular("3173372270");
        cliente.setCusNmcargo(100);
        cliente.setCusDscargo("Analista de sw");
        cliente.setCusNmciudad(1);
        cliente.setCusDsciudad("Medellín");
        cliente.setCusFenacimiento(new SimpleDateFormat( "dd/MM/yyyy" ).parse( "20/02/1993" ));
        cliente.setCusGenero(GeneroEnum.MASCULINO);
        cliente.setCusNmcomunidad(1);
        cliente.setCusDscomunidad("Caucano");
        cliente.setCusDsempresalabora("Cadena");
        cliente.setCusNmdivision(22);
        cliente.setCusDsdivision("TI");
        cliente.setCusNmpais(1);
        cliente.setCusDspais("Colombia");
        cliente.setCusHobbies("Futbol, Ajederez, tv");
        cliente.setCusFebaja(null);
        cliente.setCusFeregistro(null);

        Mockito.when(arbol.obtenerClientePorCedula(16, arbol.raiz)).thenReturn(cliente);
    }

    @Test
    void obtenerClientePorCedula() throws ObjetoNoEncontradoException {
        var response = clienteController.obtenerClientePorCedula(16);
        System.out.print(response);
    }

}