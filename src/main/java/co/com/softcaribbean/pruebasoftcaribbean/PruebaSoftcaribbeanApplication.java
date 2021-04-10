package co.com.softcaribbean.pruebasoftcaribbean;

import co.com.softcaribbean.pruebasoftcaribbean.model.Arbol;
import co.com.softcaribbean.pruebasoftcaribbean.model.Cliente;
import co.com.softcaribbean.pruebasoftcaribbean.service.ClienteService;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.GeneroEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class PruebaSoftcaribbeanApplication implements CommandLineRunner {

    ClienteService clienteService;
    public static void main(String[] args) {
        SpringApplication.run(PruebaSoftcaribbeanApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        var arbol = new Arbol();
        var listaDeClientes = clienteService.obtenerTodosLosClientes();
        //cargar árbol
        listaDeClientes.stream().forEach(clienteResponse->{
            var cliente = new Cliente();
            BeanUtils.copyProperties(clienteResponse,cliente);
            cliente.setCus_genero(GeneroEnum.obtenerEnumeradoPorDescripcion(clienteResponse.getCus_genero()));
            arbol.insertar(cliente);
        });
        arbol.recorrerArbol(arbol.raiz);
    }
}
