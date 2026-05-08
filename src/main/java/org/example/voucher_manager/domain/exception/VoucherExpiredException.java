package org.example.voucher_manager.domain.exception;

public class VoucherExpiredException extends RuntimeException {

    public VoucherExpiredException() {
        super("Voucher expired");
    }
}