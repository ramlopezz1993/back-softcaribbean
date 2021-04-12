package co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions;

/**
 * <p>
 * Excepción para identificar que se realizaba la búsqueda de un objeto y no fue encontrado.
 * </p>
 */
public class ObjetoNoEncontradoException extends AplicacionIOException {

  private static final long serialVersionUID = -2346187414948852798L;

  public ObjetoNoEncontradoException() {
    super();
  }

  public ObjetoNoEncontradoException(String message) {
    super(message);
  }

  public ObjetoNoEncontradoException(String message, Throwable cause) {
    super(message, cause);
  }

  public ObjetoNoEncontradoException(Throwable cause) {
    super(cause);
  }
}
