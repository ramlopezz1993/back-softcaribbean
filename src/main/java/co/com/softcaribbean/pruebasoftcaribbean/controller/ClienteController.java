package co.com.softcaribbean.pruebasoftcaribbean.controller;

import co.com.softcaribbean.pruebasoftcaribbean.model.response.ClienteResponse;
import co.com.softcaribbean.pruebasoftcaribbean.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("http://localhost:8080")
public class ClienteController {

    ClienteService clienteService;

    @GetMapping("/obtener-clientes")
    public ResponseEntity<List<ClienteResponse>> obtenerTodosLosClientes() {
       return new ResponseEntity<>(clienteService.obtenerTodosLosClientes(), HttpStatus.OK);
    }
}
