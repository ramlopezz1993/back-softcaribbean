package co.com.softcaribbean.pruebasoftcaribbean.model.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EditarClienteRequest implements Serializable {

    private static final long serialVersionUID = -7286090476055078479L;

    String cusDsdireccion;
    String cusDscorreo;
    String cusCdtelefono;
    String cusCdtelefonoalter;
    String cusCdcelular;
    Integer cusNmcargo;
    String cusDscargo;

}
