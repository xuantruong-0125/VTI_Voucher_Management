package org.example.voucher_manager.domain.exception;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String email) {
        super("User email already exists: " + email);
    }
}