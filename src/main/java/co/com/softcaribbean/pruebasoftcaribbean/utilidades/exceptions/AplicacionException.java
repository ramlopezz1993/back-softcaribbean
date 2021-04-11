package co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions;

/**
 * <p>
 * Excepción tipo {@link Exception} para el aplicativo.
 * </p>
 *
 * @author Juan Guillermo Martínez
 * @since 17/03/2020 - 1:08 p. m.
 */
public class AplicacionException extends Exception {

  private static final long serialVersionUID = 358829107907685133L;

  /**
   * Constructor
   */
  public AplicacionException() {
  }

  /**
   * Constructor
   *
   * @param mensaje
   */
  public AplicacionException(String mensaje) {
    super(mensaje);
  }

  /**
   * Constructor
   *
   * @param causa
   */
  public AplicacionException(Throwable causa) {
    super(causa);
  }

  /**
   * Constructor
   *
   * @param mensaje
   * @param causa
   */
  public AplicacionException(String mensaje, Throwable causa) {
    super(mensaje, causa);
  }

  /**
   * Constructor
   *
   * @param mensaje
   * @param causa
   * @param habilitarSupresion
   * @param escribirTrazaError
   */
  public AplicacionException(String mensaje, Throwable causa, boolean habilitarSupresion, boolean escribirTrazaError) {
    super(mensaje, causa, habilitarSupresion, escribirTrazaError);
  }

}
