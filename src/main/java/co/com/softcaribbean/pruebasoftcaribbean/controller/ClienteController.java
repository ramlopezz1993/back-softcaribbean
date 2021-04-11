package co.com.softcaribbean.pruebasoftcaribbean.controller;

import co.com.softcaribbean.pruebasoftcaribbean.model.request.CrearClienteRequest;
import co.com.softcaribbean.pruebasoftcaribbean.model.request.EditarClienteRequest;
import co.com.softcaribbean.pruebasoftcaribbean.model.response.ClienteResponse;
import co.com.softcaribbean.pruebasoftcaribbean.service.ClienteService;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.AplicacionException;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoNoEncontradoException;
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

    @PutMapping("/clientes/{cus_nmcliente}")
    public ResponseEntity<Void> actualizarArbolYBaseDeDatos(@PathVariable("cus_nmcliente") @NotBlank Integer cus_nmcliente,
                                                            @Valid @RequestBody EditarClienteRequest editarClienteRequest) throws ObjetoNoEncontradoException {
        clienteService.actualizarArbolYBaseDeDatos(cus_nmcliente, editarClienteRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ResponseEntity<Void> crearActivoFijo(@Valid @RequestBody CrearClienteRequest crearClienteRequest)
            throws AplicacionException, ParseException {
        clienteService.crearCliente(crearClienteRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
