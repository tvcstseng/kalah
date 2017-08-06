package com.ttstudios.kalah.web;

import com.ttstudios.kalah.web.exception.BookIdMismatchException;
import com.ttstudios.kalah.web.exception.BookNotFoundException;
import com.ttstudios.kalah.web.exception.KalahGameIdMismatchException;
import com.ttstudios.kalah.web.exception.KalahGameNotFoundException;
import com.ttstudios.kalah.web.exception.UserIdMismatchException;
import com.ttstudios.kalah.web.exception.UserNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    public RestExceptionHandler() {
        super();
    }

    @ExceptionHandler({BookNotFoundException.class, KalahGameNotFoundException.class, UserNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound( Exception ex, WebRequest request ) {
        return handleExceptionInternal( ex, "Entity not found", new HttpHeaders(), HttpStatus.NOT_FOUND, request );
    }

    @ExceptionHandler({BookIdMismatchException.class, UserIdMismatchException.class, KalahGameIdMismatchException.class, ConstraintViolationException.class, DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleBadRequest( Exception ex, WebRequest request ) {
        return handleExceptionInternal( ex, ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request );
    }
}