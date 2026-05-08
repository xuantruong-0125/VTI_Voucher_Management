package org.example.voucher_manager.domain.exception;

public class VoucherOutOfStockException extends RuntimeException {

    public VoucherOutOfStockException() {
        super("Voucher quantity is 0");
    }
}