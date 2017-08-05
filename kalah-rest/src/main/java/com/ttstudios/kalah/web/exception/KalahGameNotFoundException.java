package com.ttstudios.kalah.web.exception;

public class KalahGameNotFoundException extends RuntimeException {

    public KalahGameNotFoundException() {
        super();
    }

    public KalahGameNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public KalahGameNotFoundException(final String message) {
        super(message);
    }

    public KalahGameNotFoundException(final Throwable cause) {
        super(cause);
    }
}
