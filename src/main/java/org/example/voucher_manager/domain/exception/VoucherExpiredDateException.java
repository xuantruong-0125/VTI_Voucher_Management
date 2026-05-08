package org.example.voucher_manager.domain.exception;

public class VoucherExpiredDateException extends RuntimeException {

    public VoucherExpiredDateException() {
        super("Expired date must be greater than current date");
    }
}
