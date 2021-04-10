package co.com.softcaribbean.pruebasoftcaribbean.model;

import co.com.softcaribbean.pruebasoftcaribbean.utilidades.GeneroConverter;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.GeneroEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "tcus_clientes")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //@GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "nmid")
    Long nmid;

    @Column(name = "cus_nmcliente")
    Integer cus_nmcliente;

    @Column(name = "cus_dsnombres")
    String cus_dsnombres;

    @Column(name = "cus_dsapellidos")
    String cus_dsapellidos;

    @Column(name = "cus_dsdireccion")
    String cus_dsdireccion;

    @Column(name = "cus_dscorreo")
    String cus_dscorreo;

    @Column(name = "cus_cdtelefono")
    String cus_cdtelefono;

    @Column(name = "cus_cdtelefonoalter")
    String cus_cdtelefonoalter;

    @Column(name = "cus_cdcelular")
    String cus_cdcelular;

    @Column(name = "cus_nmcargo")
    Integer cus_nmcargo;

    @Column(name = "cus_dscargo")
    String cus_dscargo;

    @Column(name = "cus_nmciudad")
    Integer cus_nmciudad;

    @Column(name = "cus_dsciudad")
    String cus_dsciudad;

    @Column(name = "cus_fenacimiento")
    Date cus_fenacimiento;

    @Column(name = "cus_genero")
    @Convert(converter = GeneroConverter.class)
    GeneroEnum cus_genero;

    @Column(name = "cus_nmcomunidad")
    Integer cus_nmcomunidad;

    @Column(name = "cus_dscomunidad")
    String cus_dscomunidad;

    @Column(name = "cus_dsempresalabora")
    String cus_dsempresalabora;

    @Column(name = "cus_nmdivision")
    Integer cus_nmdivision;

    @Column(name = "cus_dsdivision")
    String cus_dsdivision;

    @Column(name = "cus_nmpais")
    Integer cus_nmpais;

    @Column(name = "cus_dspais")
    String cus_dspais;

    @Column(name = "cus_hobbies")
    String cus_hobbies;

    @Column(name = "cus_febaja")
    Date cus_febaja;

    @Column(name = "cus_feregistro")
    Date cus_feregistro;
}
