package co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions;

public class ObjetoNoEncontradoRuntimeException extends AplicacionRuntimeException {
    private static final long serialVersionUID = -4183350821761930497L;

    public ObjetoNoEncontradoRuntimeException(String mensaje) {
        super(mensaje);
    }

    public ObjetoNoEncontradoRuntimeException(Throwable causa) {
        super(causa);
    }

    public ObjetoNoEncontradoRuntimeException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public ObjetoNoEncontradoRuntimeException(String mensaje, Throwable causa, boolean habilitarSupresion,
                                              boolean escribirTrazaError) {
        super(mensaje, causa, habilitarSupresion, escribirTrazaError);
    }
}
