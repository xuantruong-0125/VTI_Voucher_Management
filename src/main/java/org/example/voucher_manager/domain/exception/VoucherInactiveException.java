package org.example.voucher_manager.domain.exception;

public class VoucherInactiveException extends RuntimeException {

    public VoucherInactiveException() {
        super("Voucher is inactive");
    }
}