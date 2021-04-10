package co.com.softcaribbean.pruebasoftcaribbean.service;

import co.com.softcaribbean.pruebasoftcaribbean.model.response.ClienteResponse;
import co.com.softcaribbean.pruebasoftcaribbean.repository.ClienteRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClienteServiceImpl implements ClienteService{

    ClienteRepository clienteRepository;

    @Override
    public List<ClienteResponse> obtenerTodosLosClientes() {
        var clientes = clienteRepository.findAll();
        return clientes.stream().map(cliente -> {
            return new ClienteResponse(cliente);
        }).collect(Collectors.toList());
    }
}
