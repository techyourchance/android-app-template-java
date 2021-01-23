package com.techyourchance.template.common.exceptions;

/**
 * Base class for all application specific checked exceptions
 */
public abstract class MyCheckedException extends Exception {

    public MyCheckedException() {
    }

    public MyCheckedException(String message) {
        super(message);
    }

    public MyCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyCheckedException(Throwable cause) {
        super(cause);
    }
}
