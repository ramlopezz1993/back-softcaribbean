package co.com.softcaribbean.pruebasoftcaribbean.model.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CrearClienteRequest implements Serializable {
    private static final long serialVersionUID = -4478768369293781829L;

    @NotBlank
    Integer cusNmcliente;
    @NotBlank
    String cusDsnombres;
    @NotBlank
    String cusDsapellidos;
    @NotBlank
    String cusDsdireccion;
    @NotBlank
    String cusDscorreo;
    @NotBlank
    String cusCdtelefono;
    String cusCdtelefonoalter;
    String cusCdcelular;
    @NotBlank
    Integer cusNmcargo;
    @NotBlank
    String cusDscargo;
    @NotBlank
    Integer cusNmciudad;
    @NotBlank
    String cusDsciudad;
    @NotBlank
    String cusGenero;
    @NotBlank
    Integer cusNmcomunidad;
    @NotBlank
    String cusDscomunidad;
    @NotBlank
    String cusDsempresalabora;
    @NotBlank
    Integer cusNmdivision;
    @NotBlank
    String cusDsdivision;
    @NotBlank
    Integer cusNmpais;
    @NotBlank
    String cusDspais;
    @NotBlank
    String cusHobbies;
}
