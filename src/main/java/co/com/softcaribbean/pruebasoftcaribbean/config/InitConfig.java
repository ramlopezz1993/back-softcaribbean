package co.com.softcaribbean.pruebasoftcaribbean.config;

import co.com.softcaribbean.pruebasoftcaribbean.model.Arbol;
import co.com.softcaribbean.pruebasoftcaribbean.model.Cliente;
import co.com.softcaribbean.pruebasoftcaribbean.service.ClienteService;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.GeneroEnum;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class InitConfig {
    Arbol arbol;
    ClienteService clienteService;

    @Bean
    public void init () {
        var listaDeClientes = clienteService.obtenerTodosLosClientes();
        listaDeClientes.stream().forEach(clienteResponse->{
            var cliente = new Cliente();
            BeanUtils.copyProperties(clienteResponse,cliente);
            cliente.setCusGenero(GeneroEnum.obtenerEnumeradoPorDescripcion(clienteResponse.getCusGenero()));
            arbol.insertar(cliente);
        });
        arbol.recorrerArbol(arbol.raiz);
    }
}
