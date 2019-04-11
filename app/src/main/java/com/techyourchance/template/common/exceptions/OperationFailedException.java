package com.techyourchance.template.common.exceptions;

/**
 * This exception and its subclasses can be thrown when some operation fails.
 * Implementation of flow of control using exceptions is a bad idea in general, but I find it
 * relatively safe and convenient in some cases.
 */
public class OperationFailedException extends MyCheckedException {

    public OperationFailedException() {
    }

    public OperationFailedException(String message) {
        super(message);
    }

    public OperationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperationFailedException(Throwable cause) {
        super(cause);
    }
}
