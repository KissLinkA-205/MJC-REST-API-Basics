package com.epam.esm.exceptions;

/**
 * {@code IncorrectParameterException} is generated in case received parameters have unacceptable value.
 *
 * @author Anzhalika Dziarkach
 * @version 1.0
 * @see Exception
 */
public class IncorrectParameterException extends Exception {
    public IncorrectParameterException() {
    }

    public IncorrectParameterException(String messageCode) {
        super(messageCode);
    }

    public IncorrectParameterException(String messageCode, Throwable cause) {
        super(messageCode, cause);
    }

    public IncorrectParameterException(Throwable cause) {
        super(cause);
    }
}
