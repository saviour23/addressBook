package com.saviour23.book.addressbook.exception;

/**
 * Exception thrown for any Validation failure.
 */
public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable t) {
        super(message, t);
    }
}
