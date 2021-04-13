package co.com.softcaribbean.pruebasoftcaribbean.model;

import co.com.softcaribbean.pruebasoftcaribbean.model.request.CrearClienteRequest;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.GeneroConverter;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.GeneroEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "tcus_clientes")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "nmid")
    Long nmid;

    @Column(name = "cus_nmcliente", unique = true)
    Integer cusNmcliente;

    @Column(name = "cus_dsnombres")
    String cusDsnombres;

    @Column(name = "cus_dsapellidos")
    String cusDsapellidos;

    @Column(name = "cus_dsdireccion")
    String cusDsdireccion;

    @Column(name = "cus_dscorreo")
    String cusDscorreo;

    @Column(name = "cus_cdtelefono")
    String cusCdtelefono;

    @Column(name = "cus_cdtelefonoalter")
    String cusCdtelefonoalter;

    @Column(name = "cus_cdcelular")
    String cusCdcelular;

    @Column(name = "cus_nmcargo")
    Integer cusNmcargo;

    @Column(name = "cus_dscargo")
    String cusDscargo;

    @Column(name = "cus_nmciudad")
    Integer cusNmciudad;

    @Column(name = "cus_dsciudad")
    String cusDsciudad;

    @Column(name = "cus_fenacimiento")
    LocalDate cusFenacimiento;

    @Column(name = "cus_genero")
    @Convert(converter = GeneroConverter.class)
    GeneroEnum cusGenero;

    @Column(name = "cus_nmcomunidad")
    Integer cusNmcomunidad;

    @Column(name = "cus_dscomunidad")
    String cusDscomunidad;

    @Column(name = "cus_dsempresalabora")
    String cusDsempresalabora;

    @Column(name = "cus_nmdivision")
    Integer cusNmdivision;

    @Column(name = "cus_dsdivision")
    String cusDsdivision;

    @Column(name = "cus_nmpais")
    Integer cusNmpais;

    @Column(name = "cus_dspais")
    String cusDspais;

    @Column(name = "cus_hobbies")
    String cusHobbies;

    @Column(name = "cus_febaja")
    LocalDateTime cusFebaja;

    @Column(name = "cus_feregistro")
    LocalDateTime cusFeregistro;

    public Cliente(){}

    public Cliente(CrearClienteRequest crearClienteRequest) {
            BeanUtils.copyProperties(crearClienteRequest,this);
            this.setCusGenero(GeneroEnum.obtenerGeneroPorCodigo(crearClienteRequest.getCusGenero()));
            this.setCusFenacimiento(LocalDate.now());
            this.setCusFebaja(LocalDateTime.now());
            this.setCusFeregistro(LocalDateTime.now());
    }
}
