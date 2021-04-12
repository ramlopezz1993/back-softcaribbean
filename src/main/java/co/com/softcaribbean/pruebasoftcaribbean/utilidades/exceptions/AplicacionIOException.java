package co.com.softcaribbean.pruebasoftcaribbean.utilidades.exceptions;

import java.io.IOException;

public class AplicacionIOException extends IOException {
    private static final long serialVersionUID = 4857063240717914943L;

    public AplicacionIOException() {
        super();
    }

    public AplicacionIOException(String message) {
        super(message);
    }

    public AplicacionIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public AplicacionIOException(Throwable cause) {
        super(cause);
    }
}
