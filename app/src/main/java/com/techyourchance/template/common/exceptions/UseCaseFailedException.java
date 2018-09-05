package com.techyourchance.template.common.exceptions;

/**
 * This exception and its subclasses can be thrown when synchronous use cases fail.
 * Implementation of flow of control using exceptions is bad idea in general, but I find it
 * relatively safe and convenient for use cases.
 */
public class UseCaseFailedException extends MyCheckedException {
    public UseCaseFailedException() {
    }

    public UseCaseFailedException(String message) {
        super(message);
    }

    public UseCaseFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UseCaseFailedException(Throwable cause) {
        super(cause);
    }
}
