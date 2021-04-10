package co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions;

public class AplicacionRuntimeException extends RuntimeException {

  private static final long serialVersionUID = -7889011383743308180L;

  public AplicacionRuntimeException() {
  }

  public AplicacionRuntimeException(String mensaje) {
    super(mensaje);
  }

  public AplicacionRuntimeException(Throwable causa) {
    super(causa);
  }

  public AplicacionRuntimeException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }

  public AplicacionRuntimeException(String mensaje, Throwable causa, boolean habilitarSupresion,
                                    boolean escribirTrazaError) {
    super(mensaje, causa, habilitarSupresion, escribirTrazaError);
  }

}
