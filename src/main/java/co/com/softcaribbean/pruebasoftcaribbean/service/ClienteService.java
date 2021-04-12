package co.com.softcaribbean.pruebasoftcaribbean.service;

import co.com.softcaribbean.pruebasoftcaribbean.model.request.CrearClienteRequest;
import co.com.softcaribbean.pruebasoftcaribbean.model.request.EditarClienteRequest;
import co.com.softcaribbean.pruebasoftcaribbean.model.response.ClienteResponse;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.FormatoInvalidoException;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoNoEncontradoException;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoRepetidoException;

import java.util.List;

public interface ClienteService {
    List<ClienteResponse> obtenerTodosLosClientes();
    void crearCliente(CrearClienteRequest crearClienteRequest) throws ObjetoRepetidoException, FormatoInvalidoException;
    void actualizarArbolYBaseDeDatos(Integer cusNmCliente, EditarClienteRequest editarClienteRequest) throws ObjetoNoEncontradoException;
    ClienteResponse obtenerClientePorCedula(Integer cusNmCliente) throws ObjetoNoEncontradoException;
}
