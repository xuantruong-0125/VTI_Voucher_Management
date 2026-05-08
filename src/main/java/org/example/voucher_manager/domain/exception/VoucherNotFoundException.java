package org.example.voucher_manager.domain.exception;

public class VoucherNotFoundException extends RuntimeException {

    public VoucherNotFoundException(Long id) {
        super("Voucher not found with id: " + id);
    }
}
