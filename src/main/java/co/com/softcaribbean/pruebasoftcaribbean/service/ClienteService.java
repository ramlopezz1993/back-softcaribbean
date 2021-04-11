package co.com.softcaribbean.pruebasoftcaribbean.service;

import co.com.softcaribbean.pruebasoftcaribbean.model.request.CrearClienteRequest;
import co.com.softcaribbean.pruebasoftcaribbean.model.request.EditarClienteRequest;
import co.com.softcaribbean.pruebasoftcaribbean.model.response.ClienteResponse;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.AplicacionException;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoNoEncontradoException;

import java.text.ParseException;
import java.util.List;

public interface ClienteService {
    List<ClienteResponse> obtenerTodosLosClientes();
    void crearCliente(CrearClienteRequest crearClienteRequest) throws AplicacionException, ParseException;
    void actualizarArbolYBaseDeDatos(Integer cusNmCliente, EditarClienteRequest editarClienteRequest) throws ObjetoNoEncontradoException;
    ClienteResponse obtenerClientePorCedula(Integer cusNmCliente) throws ObjetoNoEncontradoException;
}
