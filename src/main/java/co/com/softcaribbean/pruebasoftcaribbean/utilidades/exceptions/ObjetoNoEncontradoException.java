package co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions;

/**
 * <p>
 * Excepción para identificar que se realizaba la búsqueda de un objeto y no fue encontrado.
 * </p>
 */
public class ObjetoNoEncontradoException extends Exception {

  private static final long serialVersionUID = -2346187414948852798L;

  public ObjetoNoEncontradoException() {
  }

  public ObjetoNoEncontradoException(String mensaje) {
    super(mensaje);
  }

  public ObjetoNoEncontradoException(Throwable causa) {
    super(causa);
  }

  public ObjetoNoEncontradoException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }

  public ObjetoNoEncontradoException(String mensaje, Throwable causa, boolean habilitarSupresion,
                                     boolean escribirTrazaError) {
    super(mensaje, causa, habilitarSupresion, escribirTrazaError);
  }

}
