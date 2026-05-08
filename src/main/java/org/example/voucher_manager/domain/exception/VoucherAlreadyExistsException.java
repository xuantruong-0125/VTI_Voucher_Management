package org.example.voucher_manager.domain.exception;

public class VoucherAlreadyExistsException extends RuntimeException {

    public VoucherAlreadyExistsException(String code) {
        super("Voucher code already exists: " + code);
    }
}
