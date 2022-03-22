package com.youcode.clientsmanagement.exceptions;


public class ApiRequestException extends RuntimeException {

    private String message;

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }

}
