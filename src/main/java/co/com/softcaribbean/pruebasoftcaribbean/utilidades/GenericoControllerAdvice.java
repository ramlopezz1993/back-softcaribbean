package co.com.softcaribbean.pruebasoftcaribbean.utilidades;

import co.com.softcaribbean.pruebasoftcaribbean.utilidades.common.AplicacionUtility;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.FormatoInvalidoException;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoNoEncontradoException;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoNoEncontradoRuntimeException;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoRepetidoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GenericoControllerAdvice extends ResponseEntityExceptionHandler {

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public PruebaErrorBean manejoErrorGenerico(Throwable e) {
        return AplicacionUtility.generarObjetoRespuestaError(HttpStatus.INTERNAL_SERVER_ERROR, e, e.getMessage(), true);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjetoNoEncontradoRuntimeException.class)
    @ResponseBody
    public PruebaErrorBean manejoErrorGenerico(ObjetoNoEncontradoRuntimeException e) {
        return AplicacionUtility.generarObjetoRespuestaError(HttpStatus.NOT_FOUND, e, e.getMessage(), false);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjetoNoEncontradoException.class)
    @ResponseBody
    public PruebaErrorBean manejoErrorGenerico(ObjetoNoEncontradoException e) {
        return AplicacionUtility.generarObjetoRespuestaError(HttpStatus.NOT_FOUND, e, e.getMessage(), false);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ObjetoRepetidoException.class)
    @ResponseBody
    public PruebaErrorBean manejoErrorGenerico(ObjetoRepetidoException e) {
        return AplicacionUtility.generarObjetoRespuestaError(HttpStatus.BAD_REQUEST, e, e.getMessage(), false);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FormatoInvalidoException.class)
    @ResponseBody
    public PruebaErrorBean manejoErrorGenerico(FormatoInvalidoException e) {
        return AplicacionUtility.generarObjetoRespuestaError(HttpStatus.BAD_REQUEST, e, e.getMessage(), false);
    }
}
