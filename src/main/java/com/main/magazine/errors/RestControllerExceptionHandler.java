package com.main.magazine.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Date;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    /* ******** NotFound | Exception ********** */

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorBuilder customErrorDetails(NotFoundException ex) {
        return new ErrorBuilder(
                new Date(),
                404,
                "Not found | Custom Exception",
                ex.getMessage()
        );
    }

    /* ******** BadRequest | Exception ********** */

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorBuilder customErrorDetails(BadRequestException ex) {
        return new ErrorBuilder(
                new Date(),
                400,
                "Bad Request | Custom Exception",
                ex.getMessage()
        );
    }

    /* ******** ConstraintViolation | Exception ********** */

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorBuilder customErrorDetails(ConstraintViolationException ex) {
        return new ErrorBuilder(
                new Date(),
                400,
                "Constraint Violation (Global) | Custom Exception",
                ex.getMessage()
        );
    }



}
