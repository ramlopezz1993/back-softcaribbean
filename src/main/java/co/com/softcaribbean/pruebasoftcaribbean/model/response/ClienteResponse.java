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
    Integer cus_nmcliente;
    String cus_dsnombres;
    String cus_dsapellidos;
    String cus_dsdireccion;
    String cus_dscorreo;
    String cus_cdtelefono;
    String cus_cdtelefonoalter;
    String cus_cdcelular;
    Integer cus_nmcargo;
    String cus_dscargo;
    Integer cus_nmciudad;
    String cus_dsciudad;
    Date cus_fenacimiento;
    String cus_genero;
    Integer cus_nmcomunidad;
    String cus_dscomunidad;
    String cus_dsempresalabora;
    Integer cus_nmdivision;
    String cus_dsdivision;
    Integer cus_nmpais;
    String cus_dspais;
    String cus_hobbies;
    Date cus_febaja;
    Date cus_feregistro;

    public ClienteResponse (Cliente cliente) {
        BeanUtils.copyProperties(cliente,this);
        this.cus_genero = GeneroEnum.obtenerGeneroPorCodigo(cliente.getCus_genero().getCodigo()).getDescripcion();
    }
}
