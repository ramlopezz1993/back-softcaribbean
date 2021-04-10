package co.com.softcaribbean.pruebasoftcaribbean.utilidades;

import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoNoEncontradoException;
import co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions.ObjetoNoEncontradoRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class GenericoControllerAdvice {

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
}
