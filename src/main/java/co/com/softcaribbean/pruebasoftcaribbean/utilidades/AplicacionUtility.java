package co.com.softcaribbean.pruebasoftcaribbean.utilidades;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;

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
}
