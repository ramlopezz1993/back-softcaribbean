package co.com.softcaribbean.pruebasoftcaribbean.model.response;

import co.com.softcaribbean.pruebasoftcaribbean.model.Cliente;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.GeneroEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClienteResponse implements Serializable {
    private static final long serialVersionUID = -4286811885109424957L;

    Long nmid;
    Integer cusNmcliente;
    String cusDsnombres;
    String cusDsapellidos;
    String cusDsdireccion;
    String cusDscorreo;
    String cusCdtelefono;
    String cusCdtelefonoalter;
    String cusCdcelular;
    Integer cusNmcargo;
    String cusDscargo;
    Integer cusNmciudad;
    String cusDsciudad;
    String cusGenero;
    Integer cusNmcomunidad;
    String cusDscomunidad;
    String cusDsempresalabora;
    Integer cusNmdivision;
    String cusDsdivision;
    Integer cusNmpais;
    String cusDspais;
    String cusHobbies;
    Date cusFebaja;
    Date cusFeregistro;

    public ClienteResponse () {}

    public ClienteResponse (Cliente cliente) {
        BeanUtils.copyProperties(cliente,this);
        this.cusGenero = GeneroEnum.obtenerGeneroPorCodigo(cliente.getCusGenero().getCodigo()).getDescripcion();
    }
}
