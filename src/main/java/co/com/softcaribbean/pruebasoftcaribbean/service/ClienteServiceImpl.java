package co.com.softcaribbean.pruebasoftcaribbean.service;

import co.com.softcaribbean.pruebasoftcaribbean.model.Arbol;
import co.com.softcaribbean.pruebasoftcaribbean.model.Cliente;
import co.com.softcaribbean.pruebasoftcaribbean.model.request.CrearClienteRequest;
import co.com.softcaribbean.pruebasoftcaribbean.model.request.EditarClienteRequest;
import co.com.softcaribbean.pruebasoftcaribbean.model.response.ClienteResponse;
import co.com.softcaribbean.pruebasoftcaribbean.repository.ClienteRepository;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoNoEncontradoException;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoRepetidoException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClienteServiceImpl implements ClienteService {

    Arbol arbol;
    ClienteRepository clienteRepository;

    @Override
    public List<ClienteResponse> obtenerTodosLosClientes() {
        var clientes = clienteRepository.findAll();
        return clientes.stream().map(ClienteResponse::new).collect(Collectors.toList());
    }

    @Override
    public void crearCliente(CrearClienteRequest crearClienteRequest) throws ParseException, ObjetoRepetidoException {
        var optCliente = clienteRepository.findByCusNmcliente(crearClienteRequest.getCusNmcliente());
        if (optCliente.isPresent()) {
            throw new ObjetoRepetidoException("La cédula ya se encuentra registrada");
        }
        var cliente = new Cliente(crearClienteRequest);
        arbol.insertar(cliente);
        arbol.recorrerArbol(arbol.raiz);
        clienteRepository.save(cliente);
    }

    @Override
    public void actualizarArbolYBaseDeDatos(Integer cusNmCliente, EditarClienteRequest editarClienteRequest)
            throws ObjetoNoEncontradoException {
        var cliente = clienteRepository.findByCusNmcliente(cusNmCliente)
                .orElseThrow(() -> new ObjetoNoEncontradoException("El cliente con ese número de cédula no se encuentra en BD"));
        BeanUtils.copyProperties(editarClienteRequest,cliente);
        arbol.actualizarNodo(cliente,arbol.raiz);
        arbol.recorrerArbol(arbol.raiz);
        clienteRepository.save(cliente);
    }

    @Override
    public ClienteResponse obtenerClientePorCedula(Integer cusNmCliente) throws ObjetoNoEncontradoException {
        return new ClienteResponse(arbol.obtenerClientePorCedula(cusNmCliente, arbol.raiz));
    }
}



