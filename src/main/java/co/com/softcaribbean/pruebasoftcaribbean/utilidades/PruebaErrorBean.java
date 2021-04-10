package co.com.softcaribbean.pruebasoftcaribbean.utilidades;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * <p>
 * Objeto que será devuelto en el consumo del API Rest si algo falla.
 * </p>
 */

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PruebaErrorBean implements Serializable {

    private static final long serialVersionUID = -2778719109182199572L;
    @JsonProperty("httpStatus")
    String estadoHttp;

    @JsonProperty("errorMessage")
    String mensajeError;
}
