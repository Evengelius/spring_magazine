package com.main.magazine.errors;

import lombok.Getter;

import java.util.Date;

@Getter
public class ErrorBuilder {

    /* ******** Properties ********** */

    private final Date timestamp;
    private final Integer status;
    private final String error;
    private final String message;

    /* ******** Construct ********** */

    public ErrorBuilder(Date timestamp, Integer status, String message, String errorMessage) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = message;
        this.message = errorMessage;
    }
}
