package org.example.voucher_manager.domain.entity;


import org.example.voucher_manager.domain.constant.VoucherStatus;
import org.example.voucher_manager.domain.exception.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Voucher {

    private Long id;

    private String code;

    private Integer discountPercent;

    private Integer quantity;

    private LocalDate expiredDate;

    private VoucherStatus status;

    private LocalDateTime createdAt;

    public Voucher() {
    }

    public Voucher(
            Long id,
            String code,
            Integer discountPercent,
            Integer quantity,
            LocalDate expiredDate,
            VoucherStatus status,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.code = code;
        this.discountPercent = discountPercent;
        this.quantity = quantity;
        this.expiredDate = expiredDate;
        this.status = status;
        this.createdAt = createdAt;
    }

    // ===== BUSINESS VALIDATION =====

    public void validateDiscountPercent() {
        if (discountPercent == null || discountPercent < 1 || discountPercent > 100) {
            throw new InvalidDiscountPercentException();
        }
    }

    public void validateQuantity() {
        if (quantity == null || quantity < 0) {
            throw new InvalidDiscountPercentException();
        }
    }

    public void validateExpiredDate() {
        if (expiredDate == null || !expiredDate.isAfter(LocalDate.now())) {
            throw new VoucherExpiredDateException();
        }
    }

    public void validate() {
        validateDiscountPercent();
        validateQuantity();
        validateExpiredDate();
    }

    // ===== GETTER SETTER =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public VoucherStatus getStatus() {
        return status;
    }

    public void setStatus(VoucherStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void validateCanUseVoucher() {

        if (expiredDate.isBefore(LocalDate.now())) {
            throw new VoucherExpiredException();
        }

        if (status == VoucherStatus.INACTIVE) {
            throw new VoucherInactiveException();
        }

        if (quantity <= 0) {
            throw new VoucherOutOfStockException();
        }
    }

    public void decreaseQuantity() {

        validateCanUseVoucher();

        this.quantity = this.quantity - 1;
    }

}