package br.com.mkanton.walletsapi.controller;

import br.com.mkanton.walletsapi.exception.WalletException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for the API.
 */
@Hidden
@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * Handles custom wallet exceptions.
     *
     * @return standard response with problem details
     */
    @ExceptionHandler(WalletException.class)
    public ProblemDetail handleWalletException(WalletException e){
        return e.toProblemDetail();
    }
}
