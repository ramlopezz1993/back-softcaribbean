package co.com.softcaribbean.pruebasoftcaribbean;

import co.com.softcaribbean.pruebasoftcaribbean.service.ClienteService;
import lombok.AllArgsConstructor;
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
        var listaClientes = clienteService.obtenerTodosLosClientes();

    }
}
