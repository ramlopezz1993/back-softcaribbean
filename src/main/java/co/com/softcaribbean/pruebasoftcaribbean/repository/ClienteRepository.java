package co.com.softcaribbean.pruebasoftcaribbean.repository;

import co.com.softcaribbean.pruebasoftcaribbean.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
