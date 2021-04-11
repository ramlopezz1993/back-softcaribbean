package co.com.softcaribbean.pruebasoftcaribbean.controller;

import co.com.softcaribbean.pruebasoftcaribbean.model.request.CrearClienteRequest;
import co.com.softcaribbean.pruebasoftcaribbean.model.request.EditarClienteRequest;
import co.com.softcaribbean.pruebasoftcaribbean.model.response.ClienteResponse;
import co.com.softcaribbean.pruebasoftcaribbean.service.ClienteService;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoNoEncontradoException;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoRepetidoException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.text.ParseException;
import java.util.List;

@RestController
@AllArgsConstructor
public class ClienteController {

    ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteResponse>> obtenerTodosLosClientes() {
       return new ResponseEntity<>(clienteService.obtenerTodosLosClientes(), HttpStatus.OK);
    }

    @GetMapping("/clientes/{cusNmCliente}")
    public ResponseEntity<ClienteResponse> obtenerClientePorCedula(@PathVariable("cusNmCliente") @NotBlank Integer cusNmCliente) throws ObjetoNoEncontradoException {
        return new ResponseEntity<>(clienteService.obtenerClientePorCedula(cusNmCliente), HttpStatus.OK);
    }

    @PutMapping("/clientes/{cusNmCliente}")
    public ResponseEntity<Void> actualizarArbolYBaseDeDatos(@PathVariable("cusNmCliente") @NotBlank Integer cusNmCliente,
                                                            @Valid @RequestBody EditarClienteRequest editarClienteRequest) throws ObjetoNoEncontradoException {
        clienteService.actualizarArbolYBaseDeDatos(cusNmCliente, editarClienteRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ResponseEntity<Void> crearCliente(@Valid @RequestBody CrearClienteRequest crearClienteRequest)
            throws ParseException, ObjetoRepetidoException {
        clienteService.crearCliente(crearClienteRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
