package co.com.softcaribbean.pruebasoftcaribbean.utilidades;

import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoNoEncontradoRuntimeException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.stream.Stream;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public enum GeneroEnum implements CodigoDescripcionEnumsInterface{
    MASCULINO("M", "MASCULINO"),
    FEMENINO("F", "FEMENINO");

    String codigo;
    String descripcion;

    public static GeneroEnum obtenerGeneroPorCodigo(String codigo) {
        try (Stream<GeneroEnum> codDescStream = Stream.of(GeneroEnum.values())) {
            return codDescStream.filter(theEnum -> theEnum.getCodigo().equals(codigo)).findFirst()
                    .orElseThrow(() -> new ObjetoNoEncontradoRuntimeException(
                            String.format("El género con ese código no se encuentra", codigo)));
        }
    }

    public static GeneroEnum obtenerEnumeradoPorDescripcion(String descripcion) {
        try (Stream<GeneroEnum> codDescStream = Stream.of(GeneroEnum.values())) {
            return codDescStream.filter(theEnum -> theEnum.getDescripcion().equals(descripcion)).findFirst()
                    .orElseThrow(() -> new ObjetoNoEncontradoRuntimeException(
                            String.format("El género con esa descripción no se encuentra", descripcion)));
        }
    }
}
