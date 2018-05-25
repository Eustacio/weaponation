package com.weaponation.exception;

/**
 * @author Wallison Freitas
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
