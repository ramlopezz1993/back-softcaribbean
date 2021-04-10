package co.com.softcaribbean.pruebasoftcaribbean.service;

import co.com.softcaribbean.pruebasoftcaribbean.model.response.ClienteResponse;

import java.util.List;

public interface ClienteService {

    List<ClienteResponse> obtenerTodosLosClientes();
}
