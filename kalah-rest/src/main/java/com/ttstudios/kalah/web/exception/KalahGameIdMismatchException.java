package com.ttstudios.kalah.web.exception;

public class KalahGameIdMismatchException extends RuntimeException {

    public KalahGameIdMismatchException() {
        super();
    }

    public KalahGameIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public KalahGameIdMismatchException(final String message) {
        super(message);
    }

    public KalahGameIdMismatchException(final Throwable cause) {
        super(cause);
    }
}
