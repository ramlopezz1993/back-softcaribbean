package co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions;

public class ObjetoRepetidoException extends AplicacionIOException {
    private static final long serialVersionUID = -8511113826986866537L;

    public ObjetoRepetidoException() {
        super();
    }

    public ObjetoRepetidoException(String message) {
        super(message);
    }

    public ObjetoRepetidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjetoRepetidoException(Throwable cause) {
        super(cause);
    }
}
