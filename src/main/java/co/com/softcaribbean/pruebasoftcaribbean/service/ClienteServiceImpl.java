package co.com.softcaribbean.pruebasoftcaribbean.service;

import co.com.softcaribbean.pruebasoftcaribbean.model.Arbol;
import co.com.softcaribbean.pruebasoftcaribbean.model.Cliente;
import co.com.softcaribbean.pruebasoftcaribbean.model.request.CrearClienteRequest;
import co.com.softcaribbean.pruebasoftcaribbean.model.request.EditarClienteRequest;
import co.com.softcaribbean.pruebasoftcaribbean.model.response.ClienteResponse;
import co.com.softcaribbean.pruebasoftcaribbean.repository.ClienteRepository;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.common.AplicacionUtility;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.FormatoInvalidoException;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoNoEncontradoException;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoRepetidoException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<ClienteResponse> obtenerTodosLosClientesDesdeElArbol() {
        var listaClientes = arbol.obtenerTodolosNodos(arbol.raiz, new ArrayList<>());
        return listaClientes.stream().map(ClienteResponse::new).collect(Collectors.toList());
    }

    @Override
    public void crearCliente(CrearClienteRequest crearClienteRequest) throws ObjetoRepetidoException, FormatoInvalidoException {
        var cliente = arbol.obtenerClientePorCedula(crearClienteRequest.getCusNmcliente(), arbol.raiz);
        if (cliente == null) {
            cliente = new Cliente(crearClienteRequest);
            arbol.insertar(cliente);
            arbol.recorrerArbol(arbol.raiz);
            clienteRepository.save(cliente);
        } else {
            throw new ObjetoRepetidoException("La cédula ya se encuentra registrada");
        }
    }

    @Override
    public void actualizarArbolYBaseDeDatos(Integer cusNmCliente, EditarClienteRequest editarClienteRequest)
            throws ObjetoNoEncontradoException {
        //var cliente = clienteRepository.findByCusNmcliente(cusNmCliente)
          //      .orElseThrow(() -> new ObjetoNoEncontradoException("El cliente con ese número de cédula no se encuentra en BD"));
       // BeanUtils.copyProperties(editarClienteRequest,cliente, AplicacionUtility.obtenerListapropiedadesNulas(editarClienteRequest));
        var cliente = arbol.obtenerClientePorCedula(cusNmCliente, arbol.raiz);
        BeanUtils.copyProperties(editarClienteRequest,cliente, AplicacionUtility.obtenerListapropiedadesNulas(editarClienteRequest));
        arbol.actualizarNodo(cliente,arbol.raiz);
        arbol.recorrerArbol(arbol.raiz);
        clienteRepository.save(cliente);
    }

    @Override
    public ClienteResponse obtenerClientePorCedula(Integer cusNmCliente) throws ObjetoNoEncontradoException {
        var cliente = arbol.obtenerClientePorCedula(cusNmCliente, arbol.raiz);
        if (cliente !=null) {
            return new ClienteResponse(cliente);
        }
        throw new ObjetoNoEncontradoException("El cliente con ese número de cédula no se encuentra en el árbol");
    }
}



