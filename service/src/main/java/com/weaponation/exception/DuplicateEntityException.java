package com.weaponation.exception;

/**
 * @author Wallison Freitas
 */
public class DuplicateEntityException extends RuntimeException {

    public DuplicateEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
