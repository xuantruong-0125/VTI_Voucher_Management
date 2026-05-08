package org.example.voucher_manager.domain.exception;

public class InvalidEmailFormatException extends RuntimeException {

    public InvalidEmailFormatException() {
        super("Invalid email format");
    }
}