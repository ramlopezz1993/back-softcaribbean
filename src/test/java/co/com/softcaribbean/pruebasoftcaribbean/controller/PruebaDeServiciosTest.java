package co.com.softcaribbean.pruebasoftcaribbean.controller;

import co.com.softcaribbean.pruebasoftcaribbean.model.Arbol;
import co.com.softcaribbean.pruebasoftcaribbean.model.Cliente;
import co.com.softcaribbean.pruebasoftcaribbean.model.request.CrearClienteRequest;
import co.com.softcaribbean.pruebasoftcaribbean.model.request.EditarClienteRequest;
import co.com.softcaribbean.pruebasoftcaribbean.service.ClienteService;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.GeneroEnum;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoNoEncontradoException;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoRepetidoException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

@SpringBootTest
@Slf4j
class PruebaDeServiciosTest {

    @MockBean
    Arbol arbol;

    @Autowired
    ClienteService clienteService;


    //-------------------actualizar datos desde el árbol
   @Test
    void actualizarArbolYBaseDeDatos () {
        var cliente = crearClientePrueba();
        var clienteRequest = crearObjetoEditar();
        Mockito.when(arbol.obtenerClientePorCedula(cliente.getCusNmcliente(),arbol.raiz)).thenReturn(cliente);
        Assertions.assertDoesNotThrow(()->clienteService.actualizarArbolYBaseDeDatos(cliente.getCusNmcliente(),clienteRequest));
    }

    //--------------------obtener todos los clientes
    @Test
    void obtenerTodosLosClientes () {
        Mockito.when(arbol.obtenerTodolosNodos(arbol.raiz, new ArrayList<>())).thenReturn(new ArrayList<>());
        Assertions.assertDoesNotThrow(()->clienteService.obtenerTodosLosClientesDesdeElArbol());
    }

    //---------------------Insertar cliente en arbol y db

    @Test
    void crearCliente() {
        var clienteRequest = crearClienteInsercion();
        Mockito.when(arbol.obtenerClientePorCedula(clienteRequest.getCusNmcliente(),arbol.raiz)).thenReturn(null);
        Assertions.assertDoesNotThrow(()->clienteService.crearCliente(clienteRequest));
    }

    @Test
    void crearClienteYaRegistrado() {
        var cliente = crearClientePrueba();
        var clienteRequest = crearClienteInsercion();
        Mockito.when(arbol.obtenerClientePorCedula(clienteRequest.getCusNmcliente(),arbol.raiz)).thenReturn(cliente);
        Exception exception = Assertions.assertThrows(ObjetoRepetidoException.class, () -> {
            clienteService.crearCliente(clienteRequest);
        });
        String mensajeEsperado = "La cédula ya se encuentra registrada";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertTrue(mensajeObtenido.contains(mensajeEsperado));
    }

    //-------------------Consulta de cliente por cedula desde el árbol
    @Test
    void obtenerClientePorCedula() throws ObjetoNoEncontradoException {
        var cliente = crearClientePrueba();
        Mockito.when(arbol.obtenerClientePorCedula(cliente.getCusNmcliente(),arbol.raiz)).thenReturn(cliente);
        var clienteEncontrado = clienteService.obtenerClientePorCedula(cliente.getCusNmcliente());
        Assertions.assertEquals(37,clienteEncontrado.getCusNmcliente());
    }

    @Test
    void obtenerClientePorCedulaObjetoNoEncontrado() {
        var cliente = crearClientePrueba();
        Mockito.when(arbol.obtenerClientePorCedula(cliente.getCusNmcliente(),arbol.raiz)).thenReturn(null);
        Exception exception = Assertions.assertThrows(ObjetoNoEncontradoException.class, () -> {
            clienteService.obtenerClientePorCedula(cliente.getCusNmcliente());
        });
        String mensajeEsperado = "El cliente con ese número de cédula no se encuentra en el árbol";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertTrue(mensajeObtenido.contains(mensajeEsperado));
    }

    private Cliente crearClientePrueba() {
        var cliente = new Cliente();
        cliente.setNmid(11L);
        cliente.setCusNmcliente(37);
        cliente.setCusDsnombres("Alfonso");
        cliente.setCusDsapellidos("Echeverry Maldonado");
        cliente.setCusDsdireccion("Carrera 100 Avn nutibara");
        cliente.setCusDscorreo("ralfondo@mail.com");
        cliente.setCusCdtelefono("3762947");
        cliente.setCusCdtelefonoalter(null);
        cliente.setCusCdcelular(null);
        cliente.setCusNmcargo(105);
        cliente.setCusDscargo("Ingenieria");
        cliente.setCusNmciudad(7);
        cliente.setCusDsciudad("Pereira");
        cliente.setCusFenacimiento(null);
        cliente.setCusGenero(GeneroEnum.MASCULINO);
        cliente.setCusNmcomunidad(10);
        cliente.setCusDscomunidad("Pereirano");
        cliente.setCusDsempresalabora("Confenalco");
        cliente.setCusNmdivision(24);
        cliente.setCusDsdivision("Deportista");
        cliente.setCusNmpais(7);
        cliente.setCusDspais("Canada");
        cliente.setCusHobbies("Cocinar");
        cliente.setCusFebaja(null);
        cliente.setCusFeregistro(null);
        return cliente;
    }

    private CrearClienteRequest crearClienteInsercion() {
        var cliente = new CrearClienteRequest();
        cliente.setCusNmcliente(38);
        cliente.setCusDsnombres("Ricardo");
        cliente.setCusDsapellidos("Martinez Lopez");
        cliente.setCusDsdireccion("Calle 23 n 50 b 45");
        cliente.setCusDscorreo("ricardo@mail.com");
        cliente.setCusCdtelefono("5965720");
        cliente.setCusCdtelefonoalter(null);
        cliente.setCusCdcelular(null);
        cliente.setCusNmcargo(105);
        cliente.setCusDscargo("Ingenieria");
        cliente.setCusNmciudad(8);
        cliente.setCusDsciudad("Cauca");
        cliente.setCusGenero("M");
        cliente.setCusNmcomunidad(11);
        cliente.setCusDscomunidad("Caucano");
        cliente.setCusDsempresalabora("Cadena");
        cliente.setCusNmdivision(25);
        cliente.setCusDsdivision("Deportista");
        cliente.setCusNmpais(1);
        cliente.setCusDspais("Colombia");
        cliente.setCusHobbies("Deporte");
        return cliente;
    }

    private EditarClienteRequest crearObjetoEditar() {
        var cliente = new EditarClienteRequest();
        cliente.setCusDsdireccion("Calle nueva");
        cliente.setCusDscorreo("correoNuevo@mail.com");
        cliente.setCusCdtelefono("0000000");
        cliente.setCusCdtelefonoalter("1111111");
        cliente.setCusCdcelular("2222222222");
        cliente.setCusNmcargo(105);
        cliente.setCusDscargo("Ingenieria");
        return cliente;
    }
}
