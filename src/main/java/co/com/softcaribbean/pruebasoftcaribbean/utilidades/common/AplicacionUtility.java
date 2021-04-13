package co.com.softcaribbean.pruebasoftcaribbean.utilidades.common;

import co.com.softcaribbean.pruebasoftcaribbean.utilidades.PruebaErrorBean;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.http.HttpStatus;

import java.beans.FeatureDescriptor;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;
import java.util.stream.Stream;

@Slf4j
@UtilityClass
public class AplicacionUtility {

    public PruebaErrorBean generarObjetoRespuestaError(HttpStatus httpStatus, Throwable e, String mensajeError, boolean pintarEnLog) {
        var respuestaError = new PruebaErrorBean();
        respuestaError.setMensajeError(mensajeError);
        respuestaError.setEstadoHttp(httpStatus.getReasonPhrase());
        if (pintarEnLog) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return respuestaError;
    }

    public static String[] obtenerListapropiedadesNulas(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors()).map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null).toArray(String[]::new);
    }

    public static LocalDateTime convertirLongToLocalDateTime(Long fechaLong) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(fechaLong),
                TimeZone.getDefault().toZoneId());
    }

    public static LocalDate convertirStringToLocalDate(String fechaString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        return LocalDate.parse(fechaString, formatter);
    }
}
