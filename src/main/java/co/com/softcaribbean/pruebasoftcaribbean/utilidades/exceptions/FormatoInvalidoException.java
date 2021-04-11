package co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions;

public class FormatoInvalidoException extends AplicacionIOException{
    private static final long serialVersionUID = 775031014437462876L;

    public FormatoInvalidoException() {
        super();
    }

    public FormatoInvalidoException(String message) {
        super(message);
    }

    public FormatoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormatoInvalidoException(Throwable cause) {
        super(cause);
    }
}
