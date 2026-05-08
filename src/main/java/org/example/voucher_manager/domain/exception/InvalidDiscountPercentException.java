package org.example.voucher_manager.domain.exception;
public class InvalidDiscountPercentException extends RuntimeException {

    public InvalidDiscountPercentException() {
        super("Discount percent must be between 1 and 100");
    }
}
