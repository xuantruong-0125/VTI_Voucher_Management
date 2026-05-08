package org.example.voucher_manager.domain.exception;

public class InvalidQuantityException extends RuntimeException {

    public InvalidQuantityException() {
        super("Quantity must be greater than or equal to 0");
    }
}
